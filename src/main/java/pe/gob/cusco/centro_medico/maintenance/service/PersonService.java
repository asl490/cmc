package pe.gob.cusco.centro_medico.maintenance.service;

import java.util.Optional;

import pe.gob.cusco.centro_medico.maintenance.entity.Person;
import pe.gob.cusco.centro_medico.maintenance.util.PersonDTO;
import pe.gob.cusco.centro_medico.maintenance.util.PidePerson;
import pe.gob.cusco.centro_medico.shared.BaseService;

public interface PersonService
                extends
                BaseService<PersonDTO.CreatePersonDTO, PersonDTO.UpdatePersonDTO, PersonDTO, PersonDTO.FiltersPersonDTO> {

        Optional<Person> findOptionalByDNI(String dni);

        Optional<PidePerson> pidePerson(String dni);
}