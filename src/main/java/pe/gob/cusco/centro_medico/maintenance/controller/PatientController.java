package pe.gob.cusco.centro_medico.maintenance.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pe.gob.cusco.centro_medico.maintenance.service.PatientService;
import pe.gob.cusco.centro_medico.maintenance.util.PatientDTO;
import pe.gob.cusco.centro_medico.maintenance.util.PatientDTO.FiltersPatientPersonDTO;
import pe.gob.cusco.centro_medico.shared.BaseController;
import pe.gob.cusco.centro_medico.shared.PagedResponse;

@RestController
@RequestMapping(value = "/patient")
public class PatientController
        extends
        BaseController<PatientDTO.CreatePatientDTO, PatientDTO.UpdatePatientDTO, PatientDTO, PatientDTO.FiltersPatientDTO> {

    private final PatientService service;

    public PatientController(PatientService service) {
        super(service);
        this.service = service;
    }

    public ResponseEntity<PagedResponse<PatientDTO>> getAllFilteredPagedByPerson(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestBody FiltersPatientPersonDTO filters) {
        PagedResponse<PatientDTO> response = service.pageFilterPatientPerson(page, size, filters);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/full")
    public ResponseEntity<PatientDTO> createPatientAndPerson(@RequestBody PatientDTO.CreatePatientAndPersonDTO dto) {
        PatientDTO response = service.createPatientAndPerson(dto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}