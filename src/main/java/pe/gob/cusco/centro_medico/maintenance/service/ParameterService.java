package pe.gob.cusco.centro_medico.maintenance.service;

import java.util.List;

import pe.gob.cusco.centro_medico.maintenance.dto.ParameterDTO;
import pe.gob.cusco.centro_medico.shared.BaseService;

public interface ParameterService
                extends
                BaseService<ParameterDTO.CreateParameterDTO, ParameterDTO.UpdateParameterDTO, ParameterDTO, ParameterDTO.FiltersParameterDTO> {

        List<ParameterDTO> getByLaboratoryId(Long laboratory);

}