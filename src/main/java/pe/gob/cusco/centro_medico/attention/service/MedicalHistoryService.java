package pe.gob.cusco.centro_medico.attention.service;

import java.util.List;

import pe.gob.cusco.centro_medico.attention.dto.MedicalHistoryDTO;
import pe.gob.cusco.centro_medico.shared.BaseService;

public interface MedicalHistoryService
        extends
        BaseService<MedicalHistoryDTO.CreateMedicalHistoryDTO, MedicalHistoryDTO.UpdateMedicalHistoryDTO, MedicalHistoryDTO, MedicalHistoryDTO.FiltersMedicalHistoryDTO> {

    List<MedicalHistoryDTO> getByPatient(Long patientId);
}