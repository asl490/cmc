package pe.gob.cusco.centro_medico.maintenance.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import pe.gob.cusco.centro_medico.maintenance.entity.Person;
import pe.gob.cusco.centro_medico.maintenance.repository.PersonRepository;
import pe.gob.cusco.centro_medico.maintenance.service.PersonService;
import pe.gob.cusco.centro_medico.maintenance.util.PersonDTO;
import pe.gob.cusco.centro_medico.maintenance.util.PersonDTO.CreatePersonDTO;
import pe.gob.cusco.centro_medico.maintenance.util.PersonDTO.FiltersPersonDTO;
import pe.gob.cusco.centro_medico.maintenance.util.PersonDTO.UpdatePersonDTO;
import pe.gob.cusco.centro_medico.maintenance.util.PersonMapper;
import pe.gob.cusco.centro_medico.shared.BaseServiceImpl;

@Service
public class PersonServiceImpl extends
        BaseServiceImpl<Person, CreatePersonDTO, UpdatePersonDTO, PersonDTO, FiltersPersonDTO>
        implements PersonService {

    private final PersonRepository repository;

    public PersonServiceImpl(PersonRepository repository,
            PersonMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
    }

    @Override
    public Optional<Person> findOptionalByDNI(String dni) {
        Optional<Person> person = repository.findByDni(dni);
        return person;
    }

}