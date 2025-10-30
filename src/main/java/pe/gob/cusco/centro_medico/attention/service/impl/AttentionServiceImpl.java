package pe.gob.cusco.centro_medico.attention.service.impl;

import org.springframework.stereotype.Service;

import pe.gob.cusco.centro_medico.attention.dto.AttentionDTO;
import pe.gob.cusco.centro_medico.attention.dto.AttentionDTO.CreateAttentionDTO;
import pe.gob.cusco.centro_medico.attention.dto.AttentionDTO.FiltersAttentionDTO;
import pe.gob.cusco.centro_medico.attention.dto.AttentionDTO.UpdateAttentionDTO;
import pe.gob.cusco.centro_medico.attention.entity.Attention;
import pe.gob.cusco.centro_medico.attention.entity.enums.AppointmentStatus;
import pe.gob.cusco.centro_medico.attention.mapper.AttentionMapper;
import pe.gob.cusco.centro_medico.attention.repository.AttentionRepository;
import pe.gob.cusco.centro_medico.attention.service.AppointmentService;
import pe.gob.cusco.centro_medico.attention.service.AttentionService;
import pe.gob.cusco.centro_medico.shared.BaseServiceImpl;

@Service
public class AttentionServiceImpl extends
        BaseServiceImpl<Attention, CreateAttentionDTO, UpdateAttentionDTO, AttentionDTO, FiltersAttentionDTO>
        implements AttentionService {

    private final AttentionRepository repository;
    private final AppointmentService appointmentService;
    private final AppointmentStatus IN_CONSULTATION = AppointmentStatus.IN_CONSULTATION;

    public AttentionServiceImpl(AttentionRepository repository, AppointmentService appointmentService,
            AttentionMapper mapper) {

        super(repository, mapper);
        this.repository = repository;
        this.appointmentService = appointmentService;

    }

    @Override
    public AttentionDTO create(CreateAttentionDTO request) {
        // var appointment = appointmentService.getById(request.getAppointment());

        appointmentService.UpdateStatus(request.getAppointment(), IN_CONSULTATION.getDescription());

        return super.create(request);
    }

    @Override
    public AttentionDTO findByAppointment(Long id) {

        return super.mapper.toDTO(repository.findByAppointmentId(id).orElse(null));

    }

}