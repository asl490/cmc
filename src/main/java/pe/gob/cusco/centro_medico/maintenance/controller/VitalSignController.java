package pe.gob.cusco.centro_medico.maintenance.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.gob.cusco.centro_medico.maintenance.service.VitalSignService;
import pe.gob.cusco.centro_medico.maintenance.util.VitalSignDTO;
import pe.gob.cusco.centro_medico.shared.BaseController;

@RestController
@RequestMapping("maintenance/vitalsign")
public class VitalSignController
        extends
        BaseController<VitalSignDTO.CreateVitalSignDTO, VitalSignDTO.UpdateVitalSignDTO, VitalSignDTO, VitalSignDTO.FiltersVitalSignDTO> {

    public VitalSignController(VitalSignService service) {
        super(service);
    }

}