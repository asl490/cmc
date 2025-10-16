package pe.gob.cusco.centro_medico.maintenance.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.gob.cusco.centro_medico.exception.exception.ResourceNotFoundException;
import pe.gob.cusco.centro_medico.maintenance.service.PersonService;
import pe.gob.cusco.centro_medico.maintenance.util.PersonDTO;
import pe.gob.cusco.centro_medico.maintenance.util.PidePerson;
import pe.gob.cusco.centro_medico.shared.BaseController;

@RestController
@RequestMapping(value = "maintenance/person")
public class PersonController
        extends
        BaseController<PersonDTO.CreatePersonDTO, PersonDTO.UpdatePersonDTO, PersonDTO, PersonDTO.FiltersPersonDTO> {
    private final PersonService service;

    public PersonController(PersonService service) {
        super(service);
        this.service = service;
    }

    @GetMapping("/pide/{dni}")
    public PidePerson getPersonPidePerson(@PathVariable String dni) {
        return service.pidePerson(dni).orElseThrow(() -> new ResourceNotFoundException("Entity not found"));

    }

}