package pe.gob.cusco.centro_medico.attention.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.gob.cusco.centro_medico.attention.dto.LaboratoryResultDTO;
import pe.gob.cusco.centro_medico.attention.dto.LaboratoryResultDTO.CreateLaboratoryResultDTO;
import pe.gob.cusco.centro_medico.attention.dto.LaboratoryResultDTO.LaboratoryResultFieldsDTO;
import pe.gob.cusco.centro_medico.attention.dto.LaboratoryResultDTO.LaboratoryResultMinDTO;
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

    @GetMapping("/get-parameters-by-appointment/{appointment}")
    public ResponseEntity<LaboratoryResultFieldsDTO> getParameterByAppointment(@PathVariable Long appointment) {
        return ResponseEntity.ok(service.getParametersByAppointmentId(appointment));
    }

    @PostMapping("/save/all")
    public ResponseEntity<Void> saveAll(@RequestBody List<CreateLaboratoryResultDTO> dto) {

        service.createAllDto(dto);

        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @GetMapping("/appointment/{appointment}")
    public ResponseEntity<List<LaboratoryResultMinDTO>> getResultsbyAppointment(@PathVariable Long appointment) {

        return ResponseEntity.ok(service.getResultsByAppointmentId(appointment));
    }

}