package pe.gob.cusco.centro_medico.attention.service;

import java.util.List;

import pe.gob.cusco.centro_medico.attention.dto.AppointmentDTO;
import pe.gob.cusco.centro_medico.attention.dto.LaboratoryOrderDTO;
import pe.gob.cusco.centro_medico.attention.dto.LaboratoryOrderDTO.CreateLaboratoryOrderDTO;
import pe.gob.cusco.centro_medico.attention.dto.LaboratoryOrderDTO.FiltersLaboratoryOrderDTO;
import pe.gob.cusco.centro_medico.shared.BaseService;
import pe.gob.cusco.centro_medico.shared.PagedResponse;

public interface LaboratoryOrderService
                extends
                BaseService<LaboratoryOrderDTO.CreateLaboratoryOrderDTO, LaboratoryOrderDTO.UpdateLaboratoryOrderDTO, LaboratoryOrderDTO, LaboratoryOrderDTO.FiltersLaboratoryOrderDTO> {

        List<LaboratoryOrderDTO> createAll(List<CreateLaboratoryOrderDTO> request);

        List<LaboratoryOrderDTO> getByAppointmentId(Long appointment);

        List<AppointmentDTO> getAppointmentsWithPendingLaboratoryOrders();

        PagedResponse<AppointmentDTO> getAppointments(int page, int size, FiltersLaboratoryOrderDTO filters);
}