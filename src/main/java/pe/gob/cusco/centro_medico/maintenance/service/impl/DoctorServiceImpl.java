package pe.gob.cusco.centro_medico.maintenance.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import pe.gob.cusco.centro_medico.maintenance.entity.Doctor;
import pe.gob.cusco.centro_medico.maintenance.repository.DoctorRepository;
import pe.gob.cusco.centro_medico.maintenance.service.DoctorService;
import pe.gob.cusco.centro_medico.maintenance.util.DoctorDTO;
import pe.gob.cusco.centro_medico.maintenance.util.DoctorDTO.CreateDoctorDTO;
import pe.gob.cusco.centro_medico.maintenance.util.DoctorDTO.FiltersDoctorDTO;
import pe.gob.cusco.centro_medico.maintenance.util.DoctorDTO.FiltersDoctorPersonDTO;
import pe.gob.cusco.centro_medico.maintenance.util.DoctorDTO.FiltersDoctorSpecDTO;
import pe.gob.cusco.centro_medico.maintenance.util.DoctorDTO.UpdateDoctorDTO;
import pe.gob.cusco.centro_medico.maintenance.util.DoctorMapper;
import pe.gob.cusco.centro_medico.shared.BaseServiceImpl;
import pe.gob.cusco.centro_medico.shared.GenericSpecificationBuilder;
import pe.gob.cusco.centro_medico.shared.PagedResponse;

@Service
public class DoctorServiceImpl extends
        BaseServiceImpl<Doctor, CreateDoctorDTO, UpdateDoctorDTO, DoctorDTO, FiltersDoctorDTO>
        implements DoctorService {

    private final DoctorRepository repository;
    private final DoctorMapper mapper;
    private final GenericSpecificationBuilder<Doctor> specificationBuilder;

    public DoctorServiceImpl(DoctorRepository repository,
            DoctorMapper mapper) {
        super(repository, mapper);
        this.mapper = mapper;
        this.repository = repository;
        this.specificationBuilder = new GenericSpecificationBuilder<>();
    }

    @Override
    public PagedResponse<DoctorDTO> getAll(int page, int size, FiltersDoctorDTO filters) {
        Pageable pageable = PageRequest.of(page, size);
        FiltersDoctorSpecDTO specDTO = mapper.toSpec(filters);
        Specification<Doctor> spec = specificationBuilder.build(specDTO);
        Page<Doctor> entityPage = repository.findAll(spec, pageable);
        List<DoctorDTO> domainList = mapper.toDTOList(entityPage.getContent());

        return new PagedResponse<>(
                domainList,
                entityPage.getNumber(),
                entityPage.getSize(),
                entityPage.getTotalElements(),
                entityPage.getTotalPages(),
                entityPage.isLast());
    }

    @Override
    public PagedResponse<DoctorDTO> pageFilterDoctorPerson(int page, int size, FiltersDoctorPersonDTO filters) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Doctor> entityPage = repository
                .findByPersonDniContainsAndPersonNameContainsAndPersonSurnameContainsAndSpecialtyContains(
                        filters.getDni() != null ? filters.getDni() : "",
                        filters.getName() != null ? filters.getName() : "",
                        filters.getSurname() != null ? filters.getSurname() : "",
                        filters.getSpecialty() != null ? filters.getSpecialty() : "",
                        pageable);
        List<DoctorDTO> domainList = mapper.toDTOList(entityPage.getContent());
        return new PagedResponse<>(
                domainList,
                entityPage.getNumber(),
                entityPage.getSize(),
                entityPage.getTotalElements(),
                entityPage.getTotalPages(),
                entityPage.isLast());
    }
}