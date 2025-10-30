package pe.gob.cusco.centro_medico.attention.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.gob.cusco.centro_medico.attention.dto.MedicalHistoryDTO;
import pe.gob.cusco.centro_medico.attention.service.MedicalHistoryService;
import pe.gob.cusco.centro_medico.shared.BaseController;

@RestController
@RequestMapping("/medicalhistory")
public class MedicalHistoryController
        extends
        BaseController<MedicalHistoryDTO.CreateMedicalHistoryDTO, MedicalHistoryDTO.UpdateMedicalHistoryDTO, MedicalHistoryDTO, MedicalHistoryDTO.FiltersMedicalHistoryDTO> {

    private final MedicalHistoryService service;

    public MedicalHistoryController(MedicalHistoryService service) {
        super(service);
        this.service = service;
    }

    @GetMapping("patient/{patient}")
    public ResponseEntity<List<MedicalHistoryDTO>> getByPatient(@PathVariable Long patient) {
        return ResponseEntity.ok(service.getByPatient(patient));
    }

}