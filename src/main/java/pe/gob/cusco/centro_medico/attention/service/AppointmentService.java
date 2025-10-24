package pe.gob.cusco.centro_medico.attention.service;

import pe.gob.cusco.centro_medico.attention.dto.AppointmentDTO;
import pe.gob.cusco.centro_medico.shared.BaseService;

public interface AppointmentService
                extends
                BaseService<AppointmentDTO.CreateAppointmentDTO, AppointmentDTO.UpdateAppointmentDTO, AppointmentDTO, AppointmentDTO.FiltersAppointmentDTO> {

        public AppointmentDTO UpdateStatus(Long id, String status);
}