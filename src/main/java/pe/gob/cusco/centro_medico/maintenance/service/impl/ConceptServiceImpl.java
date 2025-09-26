package pe.gob.cusco.centro_medico.maintenance.service.impl;

import org.springframework.stereotype.Service;

import pe.gob.cusco.centro_medico.maintenance.entity.Concept;
import pe.gob.cusco.centro_medico.maintenance.repository.ConceptRepository;
import pe.gob.cusco.centro_medico.maintenance.service.ConceptService;
import pe.gob.cusco.centro_medico.maintenance.util.ConceptDTO;
import pe.gob.cusco.centro_medico.maintenance.util.ConceptDTO.CreateConceptDTO;
import pe.gob.cusco.centro_medico.maintenance.util.ConceptDTO.FiltersConceptDTO;
import pe.gob.cusco.centro_medico.maintenance.util.ConceptDTO.UpdateConceptDTO;
import pe.gob.cusco.centro_medico.maintenance.util.ConceptMapper;
import pe.gob.cusco.centro_medico.shared.BaseServiceImpl;

@Service
public class ConceptServiceImpl extends
        BaseServiceImpl<Concept, CreateConceptDTO, UpdateConceptDTO, ConceptDTO, FiltersConceptDTO>
        implements ConceptService {

    public ConceptServiceImpl(ConceptRepository repository,
            ConceptMapper mapper) {
        super(repository, mapper);

    }

}