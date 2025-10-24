package pe.gob.cusco.centro_medico.maintenance.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.gob.cusco.centro_medico.maintenance.entity.enums.TypeAntecedent;
import pe.gob.cusco.centro_medico.maintenance.entity.enums.TypeData;
import pe.gob.cusco.centro_medico.maintenance.service.AntecedentService;
import pe.gob.cusco.centro_medico.maintenance.util.AntecedentDTO;
import pe.gob.cusco.centro_medico.shared.BaseController;
import pe.gob.cusco.centro_medico.shared.KeyValue;

@RestController
@RequestMapping("maintenance/antecedent")
public class AntecedentController
        extends
        BaseController<AntecedentDTO.CreateAntecedentDTO, AntecedentDTO.UpdateAntecedentDTO, AntecedentDTO, AntecedentDTO.FiltersAntecedentDTO> {

    public AntecedentController(AntecedentService service) {
        super(service);
    }

    @GetMapping("/types-antecedent")
    public List<KeyValue<String, String>> getAntecedentTypes() {
        return Arrays.stream(TypeAntecedent.values())
                .map(type -> new KeyValue<>(type.name(), type.getDescription()))
                .toList();
    }

    @GetMapping("/types-data")
    public List<KeyValue<String, String>> getDataTypes() {
        return Arrays.stream(TypeData.values())
                .map(type -> new KeyValue<>(type.name(), type.getDescription()))
                .toList();
    }

}