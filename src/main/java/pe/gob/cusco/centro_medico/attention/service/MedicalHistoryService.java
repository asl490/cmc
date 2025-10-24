package pe.gob.cusco.centro_medico.attention.service;

import pe.gob.cusco.centro_medico.attention.dto.MedicalHistoryDTO;
import pe.gob.cusco.centro_medico.shared.BaseService;

public interface MedicalHistoryService
                extends
                BaseService<MedicalHistoryDTO.CreateMedicalHistoryDTO, MedicalHistoryDTO.UpdateMedicalHistoryDTO, MedicalHistoryDTO, MedicalHistoryDTO.FiltersMedicalHistoryDTO> {
}