package pe.gob.cusco.centro_medico.maintenance.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.gob.cusco.centro_medico.maintenance.service.PersonService;
import pe.gob.cusco.centro_medico.maintenance.util.PersonDTO;
import pe.gob.cusco.centro_medico.shared.BaseController;

@RestController
@RequestMapping("/person")
public class PersonController
        extends BaseController<PersonDTO.CreatePersonDTO, PersonDTO.UpdatePersonDTO, PersonDTO, PersonDTO.FiltersPersonDTO> {

    public PersonController(PersonService service) {
        super(service);
    }

}