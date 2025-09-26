package pe.gob.cusco.centro_medico.reports.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.gob.cusco.centro_medico.reports.service.MedicalCardService;
import pe.gob.cusco.centro_medico.reports.util.MedicalCardDTO;
import pe.gob.cusco.centro_medico.shared.BaseController;

@RestController
@RequestMapping("/medicalcard")
public class MedicalCardController
        extends BaseController<MedicalCardDTO.CreateMedicalCardDTO, MedicalCardDTO.UpdateMedicalCardDTO, MedicalCardDTO, MedicalCardDTO.FiltersMedicalCardDTO> {

    public MedicalCardController(MedicalCardService service) {
        super(service);
    }

}