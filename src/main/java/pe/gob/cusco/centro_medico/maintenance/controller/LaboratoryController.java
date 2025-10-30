package pe.gob.cusco.centro_medico.maintenance.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.gob.cusco.centro_medico.maintenance.dto.LaboratoryDTO;
import pe.gob.cusco.centro_medico.maintenance.service.LaboratoryService;
import pe.gob.cusco.centro_medico.shared.BaseController;

@RestController
@RequestMapping("maintenance/laboratory")
public class LaboratoryController
        extends
        BaseController<LaboratoryDTO.CreateLaboratoryDTO, LaboratoryDTO.UpdateLaboratoryDTO, LaboratoryDTO, LaboratoryDTO.FiltersLaboratoryDTO> {

    public LaboratoryController(LaboratoryService service) {
        super(service);
    }

}