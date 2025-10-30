package pe.gob.cusco.centro_medico.attention.service;

import pe.gob.cusco.centro_medico.attention.dto.AttentionDTO;
import pe.gob.cusco.centro_medico.shared.BaseService;

public interface AttentionService
                extends
                BaseService<AttentionDTO.CreateAttentionDTO, AttentionDTO.UpdateAttentionDTO, AttentionDTO, AttentionDTO.FiltersAttentionDTO> {

        AttentionDTO findByAppointment(Long id);
}