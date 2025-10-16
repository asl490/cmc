package pe.gob.cusco.centro_medico.attention.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.gob.cusco.centro_medico.attention.service.AppointmentService;
import pe.gob.cusco.centro_medico.attention.util.AppointmentDTO;
import pe.gob.cusco.centro_medico.shared.BaseController;

@RestController
@RequestMapping("attention/appointment")
public class AppointmentController
        extends
        BaseController<AppointmentDTO.CreateAppointmentDTO, AppointmentDTO.UpdateAppointmentDTO, AppointmentDTO, AppointmentDTO.FiltersAppointmentDTO> {

    public AppointmentController(AppointmentService service) {
        super(service);
    }

}