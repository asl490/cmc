package pe.gob.cusco.centro_medico.attention.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.gob.cusco.centro_medico.attention.dto.LaboratoryResultDTO;
import pe.gob.cusco.centro_medico.attention.dto.LaboratoryResultDTO.LaboratoryResultFieldsDTO;
import pe.gob.cusco.centro_medico.attention.service.LaboratoryResultService;
import pe.gob.cusco.centro_medico.shared.BaseController;

@RestController
@RequestMapping("/laboratoryresult")
public class LaboratoryResultController
        extends
        BaseController<LaboratoryResultDTO.CreateLaboratoryResultDTO, LaboratoryResultDTO.UpdateLaboratoryResultDTO, LaboratoryResultDTO, LaboratoryResultDTO.FiltersLaboratoryResultDTO> {

    private final LaboratoryResultService service;

    public LaboratoryResultController(LaboratoryResultService service) {
        super(service);
        this.service = service;
    }

    @GetMapping("/appointment/{appointment}")
    public ResponseEntity<LaboratoryResultFieldsDTO> getByAppointmEntity(@PathVariable Long appointment) {

        return ResponseEntity.ok(service.getParamtersByAppointmentId(appointment));
    }

}