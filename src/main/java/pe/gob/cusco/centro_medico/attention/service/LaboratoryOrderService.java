package pe.gob.cusco.centro_medico.attention.service;

import pe.gob.cusco.centro_medico.attention.dto.LaboratoryOrderDTO;
import pe.gob.cusco.centro_medico.shared.BaseService;

public interface LaboratoryOrderService
        extends BaseService<LaboratoryOrderDTO.CreateLaboratoryOrderDTO, LaboratoryOrderDTO.UpdateLaboratoryOrderDTO, LaboratoryOrderDTO, LaboratoryOrderDTO.FiltersLaboratoryOrderDTO> {
}