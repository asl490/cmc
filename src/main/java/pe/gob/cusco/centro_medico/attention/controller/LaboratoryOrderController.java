package pe.gob.cusco.centro_medico.attention.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pe.gob.cusco.centro_medico.attention.dto.AppointmentDTO;
import pe.gob.cusco.centro_medico.attention.dto.LaboratoryOrderDTO;
import pe.gob.cusco.centro_medico.attention.dto.LaboratoryOrderDTO.CreateLaboratoryOrderDTO;
import pe.gob.cusco.centro_medico.attention.dto.LaboratoryOrderDTO.FiltersLaboratoryOrderDTO;
import pe.gob.cusco.centro_medico.attention.service.LaboratoryOrderService;
import pe.gob.cusco.centro_medico.shared.BaseController;
import pe.gob.cusco.centro_medico.shared.PagedResponse;

@RestController
@RequestMapping("/laboratoryorder")
public class LaboratoryOrderController
        extends
        BaseController<LaboratoryOrderDTO.CreateLaboratoryOrderDTO, LaboratoryOrderDTO.UpdateLaboratoryOrderDTO, LaboratoryOrderDTO, LaboratoryOrderDTO.FiltersLaboratoryOrderDTO> {

    private final LaboratoryOrderService service;

    public LaboratoryOrderController(LaboratoryOrderService service) {
        super(service);

        this.service = service;
    }

    @PostMapping("/save/all")
    public ResponseEntity<Void> saveAll(@RequestBody List<CreateLaboratoryOrderDTO> dto) {

        service.createAll(dto);

        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @GetMapping("/appointment/{appointment}")
    public ResponseEntity<List<LaboratoryOrderDTO>> getByAppointmentEntity(@PathVariable Long appointment) {

        return ResponseEntity.ok(service.getByAppointmentId(appointment));
    }

    @GetMapping("/get-appointment-by-laboratory")
    public ResponseEntity<List<AppointmentDTO>> getAppointments() {

        return ResponseEntity.ok(service.getAppointmentsWithPendingLaboratoryOrders());
    }

    @PostMapping("/page-appointment-by-laboratory")
    public ResponseEntity<PagedResponse<AppointmentDTO>> pageAppointments(@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size, FiltersLaboratoryOrderDTO filters) {

        return ResponseEntity.ok(service.getAppointments(page, size, filters));
    }

}