package pe.gob.cusco.centro_medico.maintenance.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.cusco.centro_medico.maintenance.entity.Patient;
import pe.gob.cusco.centro_medico.maintenance.repository.PatientRepository;
import pe.gob.cusco.centro_medico.maintenance.service.PatientService;
import pe.gob.cusco.centro_medico.maintenance.util.PatientDTO;
import pe.gob.cusco.centro_medico.maintenance.util.PatientDTO.CreatePatientDTO;
import pe.gob.cusco.centro_medico.maintenance.util.PatientDTO.FiltersPatientDTO;
import pe.gob.cusco.centro_medico.maintenance.util.PatientDTO.FiltersPatientPersonDTO;
import pe.gob.cusco.centro_medico.maintenance.util.PatientDTO.FiltersPatientSpecDTO;
import pe.gob.cusco.centro_medico.maintenance.util.PatientDTO.UpdatePatientDTO;
import pe.gob.cusco.centro_medico.maintenance.util.PatientMapper;
import pe.gob.cusco.centro_medico.shared.BaseServiceImpl;
import pe.gob.cusco.centro_medico.shared.GenericSpecificationBuilder;
import pe.gob.cusco.centro_medico.shared.PagedResponse;

@Service
public class PatientServiceImpl extends
        BaseServiceImpl<Patient, CreatePatientDTO, UpdatePatientDTO, PatientDTO, FiltersPatientDTO>
        implements PatientService {

    private final PatientMapper mapper;
    private final PatientRepository repository;
    private final GenericSpecificationBuilder<Patient> specificationBuilder;

    public PatientServiceImpl(PatientRepository repository,
            PatientMapper mapper) {
        super(repository, mapper);
        this.mapper = mapper;
        this.repository = repository;
        this.specificationBuilder = new GenericSpecificationBuilder<>();
    }

    @Override
    public PagedResponse<PatientDTO> getAll(int page, int size, FiltersPatientDTO filters) {
        Pageable pageable = PageRequest.of(page, size);
        FiltersPatientSpecDTO specDTO = mapper.toSpec(filters);
        Specification<Patient> spec = specificationBuilder.build(specDTO);
        Page<Patient> entityPage = repository.findAll(spec, pageable);
        List<PatientDTO> domainList = mapper.toDTOList(entityPage.getContent());

        return new PagedResponse<>(
                domainList,
                entityPage.getNumber(),
                entityPage.getSize(),
                entityPage.getTotalElements(),
                entityPage.getTotalPages(),
                entityPage.isLast());
    }

    @Override
    public PagedResponse<PatientDTO> pageFilterPatientPerson(int page, int size, FiltersPatientPersonDTO filters) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Patient> entityPage = repository
                .findByPersonDniContainsAndPersonNameContainsAndPersonSurnameContainsAndClinicHistoryContains(
                        filters.getDni() != null ? filters.getDni() : "",
                        filters.getName() != null ? filters.getName() : "",
                        filters.getSurname() != null ? filters.getSurname() : "",
                        filters.getClinicHistory() != null ? filters.getClinicHistory() : "",
                        pageable);
        List<PatientDTO> domainList = mapper.toDTOList(entityPage.getContent());
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
    public PatientDTO createPatientAndPerson(PatientDTO.CreatePatientAndPersonDTO dto) {
        Patient entity = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(entity));
    }

    @Override
    public PatientDTO getByDni(String dni) {

        Patient patientOpt = repository.findByPersonDni(dni).orElse(null);

        return mapper.toDTO(patientOpt);

    }

    @Override
    public PatientDTO updateHistory(Long id) {
        Patient patientOpt = repository.findById(id).orElse(null);
        patientOpt.setHasHistory(true);
        return super.mapper.toDTO(repository.save(patientOpt));
    }

}