package pe.gob.cusco.centro_medico.attention.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import pe.gob.cusco.centro_medico.attention.dto.AppointmentDTO;
import pe.gob.cusco.centro_medico.attention.dto.AppointmentDTO.CreateAppointmentDTO;
import pe.gob.cusco.centro_medico.attention.dto.AppointmentDTO.FiltersAppointmentDTO;
import pe.gob.cusco.centro_medico.attention.dto.AppointmentDTO.UpdateAppointmentDTO;
import pe.gob.cusco.centro_medico.attention.entity.Appointment;
import pe.gob.cusco.centro_medico.attention.entity.enums.AppointmentStatus;
import pe.gob.cusco.centro_medico.attention.mapper.AppointmentMapper;
import pe.gob.cusco.centro_medico.attention.repository.AppointmentRepository;
import pe.gob.cusco.centro_medico.attention.service.AppointmentService;
import pe.gob.cusco.centro_medico.shared.BaseServiceImpl;
import pe.gob.cusco.centro_medico.shared.PagedResponse;

@Service
public class AppointmentServiceImpl extends
        BaseServiceImpl<Appointment, CreateAppointmentDTO, UpdateAppointmentDTO, AppointmentDTO, FiltersAppointmentDTO>
        implements AppointmentService {
    private final AppointmentStatus PENDING = AppointmentStatus.PENDING;
    private final AppointmentRepository repository;
    private final SimpMessagingTemplate messagingTemplate;

    public AppointmentServiceImpl(AppointmentRepository repository,
            AppointmentMapper mapper, SimpMessagingTemplate messagingTemplate) {
        super(repository, mapper);
        this.repository = repository;
        this.messagingTemplate = messagingTemplate;
    }

    @Override
    public AppointmentDTO create(CreateAppointmentDTO createDTO) {
        createDTO.setStatus(PENDING.getDescription());
        AppointmentDTO newAppointment = super.create(createDTO);
        messagingTemplate.convertAndSend("/topic/appointments", newAppointment);
        return newAppointment;
    }

    @Override
    public AppointmentDTO UpdateStatus(Long id, String status) {

        Appointment appointment = repository.findById(id).orElseThrow();
        appointment.setStatus(status);

        AppointmentDTO updatedAppointment = super.mapper.toDTO(repository.save(appointment));
        messagingTemplate.convertAndSend("/topic/appointments/status", updatedAppointment);
        return updatedAppointment;
    }

    @Override
    public PagedResponse<AppointmentDTO> getAll(int page,
            int size,
            FiltersAppointmentDTO filters) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());
        Page<Appointment> entityPage = repository
                .findByPatientPersonDniContainsAndDoctorPersonDniContainsAndStatusContainsAndPatientClinicHistoryContains(
                        filters.getDni() != null ? filters.getDni() : "",
                        filters.getDniDoctor() != null ? filters.getDniDoctor() : "",
                        filters.getStatus() != null ? filters.getStatus() : "",
                        filters.getClinicHistory() != null ? filters.getClinicHistory() : "",
                        pageable);
        List<AppointmentDTO> domainList = mapper.toDTOList(entityPage.getContent());
        return new PagedResponse<>(
                domainList,
                entityPage.getNumber(),
                entityPage.getSize(),
                entityPage.getTotalElements(),
                entityPage.getTotalPages(),
                entityPage.isLast());
    }

}