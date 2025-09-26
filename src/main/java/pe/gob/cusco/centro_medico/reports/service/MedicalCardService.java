package pe.gob.cusco.centro_medico.reports.service;

import pe.gob.cusco.centro_medico.reports.util.MedicalCardDTO;
import pe.gob.cusco.centro_medico.shared.BaseService;

public interface MedicalCardService
        extends BaseService<MedicalCardDTO.CreateMedicalCardDTO, MedicalCardDTO.UpdateMedicalCardDTO, MedicalCardDTO, MedicalCardDTO.FiltersMedicalCardDTO> {
}