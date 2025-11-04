package pe.gob.cusco.centro_medico.maintenance.service;

import pe.gob.cusco.centro_medico.maintenance.dto.LaboratoryDTO;
import pe.gob.cusco.centro_medico.shared.BaseService;

public interface LaboratoryService
                extends
                BaseService<LaboratoryDTO.CreateLaboratoryDTO, LaboratoryDTO.UpdateLaboratoryDTO, LaboratoryDTO, LaboratoryDTO.FiltersLaboratoryDTO> {

        LaboratoryDTO.LaboratoryParameterDTO getAllWithParametersById(Long id);
}