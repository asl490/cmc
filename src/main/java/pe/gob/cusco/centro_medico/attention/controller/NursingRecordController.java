package pe.gob.cusco.centro_medico.attention.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.gob.cusco.centro_medico.attention.dto.NursingRecordDTO;
import pe.gob.cusco.centro_medico.attention.dto.NursingRecordDTO.CreateFullNursingRecordDTO;
import pe.gob.cusco.centro_medico.attention.service.NursingRecordService;
import pe.gob.cusco.centro_medico.shared.BaseController;

@RestController
@RequestMapping("attention/nursingrecord")
public class NursingRecordController
        extends
        BaseController<NursingRecordDTO.CreateNursingRecordDTO, NursingRecordDTO.UpdateNursingRecordDTO, NursingRecordDTO, NursingRecordDTO.FiltersNursingRecordDTO> {

    private final NursingRecordService service;

    public NursingRecordController(NursingRecordService service) {
        super(service);
        this.service = service;
    }

    @PostMapping("/save/all")
    public ResponseEntity<Void> saveAll(@RequestBody CreateFullNursingRecordDTO dto) {

        service.createAllDto(dto);

        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @GetMapping("/appointment/{appointment}")
    public ResponseEntity<List<NursingRecordDTO>> getByAppointmEntity(@PathVariable Long appointment) {

        return ResponseEntity.ok(service.getByAppointmentId(appointment));
    }

}