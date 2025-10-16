package pe.gob.cusco.centro_medico.maintenance.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.gob.cusco.centro_medico.maintenance.service.AntecedentService;
import pe.gob.cusco.centro_medico.maintenance.util.AntecedentDTO;
import pe.gob.cusco.centro_medico.shared.BaseController;

@RestController
@RequestMapping("/antecedent")
public class AntecedentController
        extends BaseController<AntecedentDTO.CreateAntecedentDTO, AntecedentDTO.UpdateAntecedentDTO, AntecedentDTO, AntecedentDTO.FiltersAntecedentDTO> {

    public AntecedentController(AntecedentService service) {
        super(service);
    }

}