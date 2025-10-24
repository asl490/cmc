package pe.gob.cusco.centro_medico.attention.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.cusco.centro_medico.attention.dto.NursingRecordDTO;
import pe.gob.cusco.centro_medico.attention.dto.NursingRecordDTO.CreateFullNursingRecordDTO;
import pe.gob.cusco.centro_medico.attention.dto.NursingRecordDTO.CreateNursingRecordDTO;
import pe.gob.cusco.centro_medico.attention.dto.NursingRecordDTO.FiltersNursingRecordDTO;
import pe.gob.cusco.centro_medico.attention.dto.NursingRecordDTO.FiltersNursingRecordSpecDTO;
import pe.gob.cusco.centro_medico.attention.dto.NursingRecordDTO.NursingRecordCreateDTO;
import pe.gob.cusco.centro_medico.attention.dto.NursingRecordDTO.UpdateNursingRecordDTO;
import pe.gob.cusco.centro_medico.attention.entity.NursingRecord;
import pe.gob.cusco.centro_medico.attention.entity.enums.AppointmentStatus;
import pe.gob.cusco.centro_medico.attention.mapper.NursingRecordMapper;
import pe.gob.cusco.centro_medico.attention.repository.NursingRecordRepository;
import pe.gob.cusco.centro_medico.attention.service.AppointmentService;
import pe.gob.cusco.centro_medico.attention.service.NursingRecordService;
import pe.gob.cusco.centro_medico.exception.exception.BusinessRuleException;
import pe.gob.cusco.centro_medico.maintenance.util.PatientDTO.FiltersPatientPersonDTO;
import pe.gob.cusco.centro_medico.shared.BaseServiceImpl;
import pe.gob.cusco.centro_medico.shared.GenericSpecificationBuilder;
import pe.gob.cusco.centro_medico.shared.PagedResponse;

@Service
public class NursingRecordServiceImpl extends
        BaseServiceImpl<NursingRecord, CreateNursingRecordDTO, UpdateNursingRecordDTO, NursingRecordDTO, FiltersNursingRecordDTO>
        implements NursingRecordService {

    private final NursingRecordRepository repository;
    private final NursingRecordMapper mapper;
    private final GenericSpecificationBuilder<NursingRecord> specificationBuilder;
    private final AppointmentService appointmentService;
    private final AppointmentStatus NURSE_REVIEW = AppointmentStatus.NURSE_REVIEW;
    private final AppointmentStatus PENDING = AppointmentStatus.PENDING;

    public NursingRecordServiceImpl(NursingRecordRepository repository,
            NursingRecordMapper mapper, AppointmentService appointmentService) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
        this.specificationBuilder = new GenericSpecificationBuilder<>();
        this.appointmentService = appointmentService;

    }

    @Override
    public PagedResponse<NursingRecordDTO> getAll(int page, int size, FiltersNursingRecordDTO filters) {
        Pageable pageable = PageRequest.of(page, size);
        FiltersNursingRecordSpecDTO specDTO = mapper.toSpec(filters);
        Specification<NursingRecord> spec = specificationBuilder.build(specDTO);
        Page<NursingRecord> entityPage = repository.findAll(spec, pageable);
        List<NursingRecordDTO> domainList = mapper.toDTOList(entityPage.getContent());

        return new PagedResponse<>(
                domainList,
                entityPage.getNumber(),
                entityPage.getSize(),
                entityPage.getTotalElements(),
                entityPage.getTotalPages(),
                entityPage.isLast());
    }

    @Override
    @Transactional
    public void createAllDto(CreateFullNursingRecordDTO dto) {
        List<CreateNursingRecordDTO> list = new ArrayList<>();
        for (NursingRecordCreateDTO nursing : dto.getNursingRecords()) {
            CreateNursingRecordDTO createNursingRecordDTO = CreateNursingRecordDTO.builder()
                    .appointment(dto.getAppointment())
                    .vitalSign(nursing.getVitalSign())
                    .numericalValue(nursing.getNumericalValue())
                    .textValue(nursing.getTextValue())
                    .observations(nursing.getObservations())
                    .build();
            list.add(createNursingRecordDTO);
        }
        List<NursingRecord> entities = mapper.toEntityList(list);
        var appointment = appointmentService.getById(dto.getAppointment());
        if (appointment.getStatus().equals(PENDING.getDescription())) {
            repository.saveAll(entities);
            appointmentService.UpdateStatus(dto.getAppointment(), NURSE_REVIEW.getDescription());
        } else {
            throw new BusinessRuleException("La cita no está en estado pendiente.");
        }

    }

    @Override
    public PagedResponse<NursingRecordDTO> pageFilterPatientPerson(int page, int size,
            FiltersPatientPersonDTO filters) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pageFilterPatientPerson'");
    }

}