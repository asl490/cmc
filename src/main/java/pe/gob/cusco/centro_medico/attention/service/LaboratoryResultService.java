package pe.gob.cusco.centro_medico.attention.service;

import pe.gob.cusco.centro_medico.attention.dto.LaboratoryResultDTO;
import pe.gob.cusco.centro_medico.shared.BaseService;

public interface LaboratoryResultService
        extends BaseService<LaboratoryResultDTO.CreateLaboratoryResultDTO, LaboratoryResultDTO.UpdateLaboratoryResultDTO, LaboratoryResultDTO, LaboratoryResultDTO.FiltersLaboratoryResultDTO> {
}