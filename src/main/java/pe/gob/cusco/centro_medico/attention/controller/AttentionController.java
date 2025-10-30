package pe.gob.cusco.centro_medico.attention.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.gob.cusco.centro_medico.attention.dto.AttentionDTO;
import pe.gob.cusco.centro_medico.attention.service.AttentionService;
import pe.gob.cusco.centro_medico.shared.BaseController;

@RestController
@RequestMapping("attention/medical-attention")
public class AttentionController
        extends
        BaseController<AttentionDTO.CreateAttentionDTO, AttentionDTO.UpdateAttentionDTO, AttentionDTO, AttentionDTO.FiltersAttentionDTO> {

    private final AttentionService service;

    public AttentionController(AttentionService service) {
        super(service);
        this.service = service;
    }

    @GetMapping("/appointment/{appointment}")
    public ResponseEntity<AttentionDTO> findByAppointmEntity(@PathVariable Long appointment) {

        return ResponseEntity.ok(service.findByAppointment(appointment));
    }

}