package pe.gob.cusco.centro_medico.maintenance.controller;

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

    public ParameterController(ParameterService service) {
        super(service);
    }

}