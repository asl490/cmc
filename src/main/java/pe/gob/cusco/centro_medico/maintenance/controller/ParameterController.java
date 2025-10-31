package pe.gob.cusco.centro_medico.maintenance.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.gob.cusco.centro_medico.maintenance.dto.ParameterDTO;
import pe.gob.cusco.centro_medico.maintenance.service.ParameterService;
import pe.gob.cusco.centro_medico.shared.BaseController;

@RestController
@RequestMapping("maintenance/parameter")
public class ParameterController
        extends
        BaseController<ParameterDTO.CreateParameterDTO, ParameterDTO.UpdateParameterDTO, ParameterDTO, ParameterDTO.FiltersParameterDTO> {

    private final ParameterService service;

    public ParameterController(ParameterService service) {
        super(service);
        this.service = service;
    }

    @GetMapping("/laboratory/{laboratory}")
    public ResponseEntity<List<ParameterDTO>> getByLaboratory(@PathVariable Long laboratory) {
        return ResponseEntity.ok(service.getByLaboratoryId(laboratory));
    }

}