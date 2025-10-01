package pe.gob.cusco.centro_medico.attention.service.impl;

import org.springframework.stereotype.Service;

import pe.gob.cusco.centro_medico.attention.entity.Appointment;
import pe.gob.cusco.centro_medico.attention.repository.AppointmentRepository;
import pe.gob.cusco.centro_medico.attention.service.AppointmentService;
import pe.gob.cusco.centro_medico.attention.util.AppointmentDTO;
import pe.gob.cusco.centro_medico.attention.util.AppointmentDTO.CreateAppointmentDTO;
import pe.gob.cusco.centro_medico.attention.util.AppointmentDTO.FiltersAppointmentDTO;
import pe.gob.cusco.centro_medico.attention.util.AppointmentDTO.UpdateAppointmentDTO;
import pe.gob.cusco.centro_medico.attention.util.AppointmentMapper;
import pe.gob.cusco.centro_medico.shared.BaseServiceImpl;

@Service
public class AppointmentServiceImpl extends
        BaseServiceImpl<Appointment, CreateAppointmentDTO, UpdateAppointmentDTO, AppointmentDTO, FiltersAppointmentDTO>
        implements AppointmentService {

    public AppointmentServiceImpl(AppointmentRepository repository,
            AppointmentMapper mapper) {
        super(repository, mapper);

    }

}