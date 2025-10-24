package pe.gob.cusco.centro_medico.attention.service.impl;

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

@Service
public class AppointmentServiceImpl extends
        BaseServiceImpl<Appointment, CreateAppointmentDTO, UpdateAppointmentDTO, AppointmentDTO, FiltersAppointmentDTO>
        implements AppointmentService {
    private final AppointmentStatus PENDING = AppointmentStatus.PENDING;
    private final AppointmentRepository repository;

    public AppointmentServiceImpl(AppointmentRepository repository,
            AppointmentMapper mapper) {
        super(repository, mapper);
        this.repository = repository;

    }

    @Override
    public AppointmentDTO create(CreateAppointmentDTO createDTO) {
        createDTO.setStatus(PENDING.getDescription());
        return super.create(createDTO);
    }

    @Override
    public AppointmentDTO UpdateStatus(Long id, String status) {

        Appointment appointment = repository.findById(id).orElseThrow();
        appointment.setStatus(status);

        return super.mapper.toDTO(repository.save(appointment));
    }

    // @Override
    // public PagedResponse<AppointmentDTO> pageFilterAppointmentEntity(int page,
    // int size,
    // FiltersAppointmentAppointmentDTO filters) {
    // Pageable pageable = PageRequest.of(page, size);
    // Page<Appointment> entityPage = repository
    // .findByPersonDniContainsAndPersonNameContainsAndPersonSurnameContainsAndClinicHistoryContains(
    // filters.getDni() != null ? filters.getDni() : "",
    // filters.getName() != null ? filters.getName() : "",
    // filters.getSurname() != null ? filters.getSurname() : "",
    // filters.getClinicHistory() != null ? filters.getClinicHistory() : "",
    // pageable);
    // List<AppointmentDTO> domainList = mapper.toDTOList(entityPage.getContent());
    // return new PagedResponse<>(
    // domainList,
    // entityPage.getNumber(),
    // entityPage.getSize(),
    // entityPage.getTotalElements(),
    // entityPage.getTotalPages(),
    // entityPage.isLast());
    // }

}