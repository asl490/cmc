package pe.gob.cusco.centro_medico.maintenance.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pe.gob.cusco.centro_medico.maintenance.service.DoctorService;
import pe.gob.cusco.centro_medico.maintenance.util.DoctorDTO;
import pe.gob.cusco.centro_medico.maintenance.util.DoctorDTO.FiltersDoctorPersonDTO;
import pe.gob.cusco.centro_medico.shared.BaseController;
import pe.gob.cusco.centro_medico.shared.PagedResponse;

@RestController
@RequestMapping("/doctor")
public class DoctorController
        extends
        BaseController<DoctorDTO.CreateDoctorDTO, DoctorDTO.UpdateDoctorDTO, DoctorDTO, DoctorDTO.FiltersDoctorDTO> {

    private final DoctorService service;

    public DoctorController(DoctorService service) {
        super(service);
        this.service = service;
    }

    @PostMapping("/filter-person")
    public ResponseEntity<PagedResponse<DoctorDTO>> getAllFilteredPagedByPerson(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestBody FiltersDoctorPersonDTO filters) {
        PagedResponse<DoctorDTO> response = service.pageFilterDoctorPerson(page, size, filters);
        return ResponseEntity.ok(response);
    }
}