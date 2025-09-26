package pe.gob.cusco.centro_medico.maintenance.service;

import pe.gob.cusco.centro_medico.maintenance.util.ConceptDTO;
import pe.gob.cusco.centro_medico.shared.BaseService;

public interface ConceptService
        extends BaseService<ConceptDTO.CreateConceptDTO, ConceptDTO.UpdateConceptDTO, ConceptDTO, ConceptDTO.FiltersConceptDTO> {
}