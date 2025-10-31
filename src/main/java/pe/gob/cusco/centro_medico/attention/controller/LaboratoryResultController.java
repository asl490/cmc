package pe.gob.cusco.centro_medico.attention.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.gob.cusco.centro_medico.attention.service.LaboratoryResultService;
import pe.gob.cusco.centro_medico.attention.dto.LaboratoryResultDTO;
import pe.gob.cusco.centro_medico.shared.BaseController;

@RestController
@RequestMapping("/laboratoryresult")
public class LaboratoryResultController
        extends BaseController<LaboratoryResultDTO.CreateLaboratoryResultDTO, LaboratoryResultDTO.UpdateLaboratoryResultDTO, LaboratoryResultDTO, LaboratoryResultDTO.FiltersLaboratoryResultDTO> {

    public LaboratoryResultController(LaboratoryResultService service) {
        super(service);
    }

}