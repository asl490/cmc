package pe.gob.cusco.centro_medico.maintenance.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.gob.cusco.centro_medico.maintenance.service.ConceptService;
import pe.gob.cusco.centro_medico.maintenance.util.ConceptDTO;
import pe.gob.cusco.centro_medico.shared.BaseController;

@RestController
@RequestMapping("maintenance/concept")
public class ConceptController
        extends
        BaseController<ConceptDTO.CreateConceptDTO, ConceptDTO.UpdateConceptDTO, ConceptDTO, ConceptDTO.FiltersConceptDTO> {

    public ConceptController(ConceptService service) {
        super(service);
    }

}