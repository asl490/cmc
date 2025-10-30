package pe.gob.cusco.centro_medico.attention.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.gob.cusco.centro_medico.attention.service.LaboratoryOrderService;
import pe.gob.cusco.centro_medico.attention.dto.LaboratoryOrderDTO;
import pe.gob.cusco.centro_medico.shared.BaseController;

@RestController
@RequestMapping("/laboratoryorder")
public class LaboratoryOrderController
        extends BaseController<LaboratoryOrderDTO.CreateLaboratoryOrderDTO, LaboratoryOrderDTO.UpdateLaboratoryOrderDTO, LaboratoryOrderDTO, LaboratoryOrderDTO.FiltersLaboratoryOrderDTO> {

    public LaboratoryOrderController(LaboratoryOrderService service) {
        super(service);
    }

}