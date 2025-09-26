package pe.gob.cusco.centro_medico.maintenance.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.gob.cusco.centro_medico.maintenance.service.PatientService;
import pe.gob.cusco.centro_medico.maintenance.util.PatientDTO;
import pe.gob.cusco.centro_medico.shared.BaseController;

@RestController
@RequestMapping("/patient")
public class PatientController
        extends BaseController<PatientDTO.CreatePatientDTO, PatientDTO.UpdatePatientDTO, PatientDTO, PatientDTO.FiltersPatientDTO> {

    public PatientController(PatientService service) {
        super(service);
    }

}