package pe.gob.cusco.centro_medico.attention.controller;

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

    public MedicalHistoryController(MedicalHistoryService service) {
        super(service);
    }

}