package pe.gob.cusco.centro_medico.maintenance.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.gob.cusco.centro_medico.maintenance.service.DoctorService;
import pe.gob.cusco.centro_medico.maintenance.util.DoctorDTO;
import pe.gob.cusco.centro_medico.shared.BaseController;

@RestController
@RequestMapping("/doctor")
public class DoctorController
        extends BaseController<DoctorDTO.CreateDoctorDTO, DoctorDTO.UpdateDoctorDTO, DoctorDTO, DoctorDTO.FiltersDoctorDTO> {

    public DoctorController(DoctorService service) {
        super(service);
    }

}