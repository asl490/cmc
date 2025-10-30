package pe.gob.cusco.centro_medico.attention.service;

import java.util.List;

import pe.gob.cusco.centro_medico.attention.dto.NursingRecordDTO;
import pe.gob.cusco.centro_medico.attention.dto.NursingRecordDTO.CreateFullNursingRecordDTO;
import pe.gob.cusco.centro_medico.maintenance.util.PatientDTO.FiltersPatientPersonDTO;
import pe.gob.cusco.centro_medico.shared.BaseService;
import pe.gob.cusco.centro_medico.shared.PagedResponse;

public interface NursingRecordService
                extends
                BaseService<NursingRecordDTO.CreateNursingRecordDTO, NursingRecordDTO.UpdateNursingRecordDTO, NursingRecordDTO, NursingRecordDTO.FiltersNursingRecordDTO> {

        public void createAllDto(CreateFullNursingRecordDTO dto);

        List<NursingRecordDTO> getByAppointmentId(Long appointmentId);

        PagedResponse<NursingRecordDTO> pageFilterPatientPerson(int page, int size, FiltersPatientPersonDTO filters);
}