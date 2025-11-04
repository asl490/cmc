package pe.gob.cusco.centro_medico.maintenance.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import pe.gob.cusco.centro_medico.maintenance.dto.LaboratoryDTO;
import pe.gob.cusco.centro_medico.maintenance.dto.LaboratoryDTO.CreateLaboratoryDTO;
import pe.gob.cusco.centro_medico.maintenance.dto.LaboratoryDTO.FiltersLaboratoryDTO;
import pe.gob.cusco.centro_medico.maintenance.dto.LaboratoryDTO.LaboratoryParameterDTO;
import pe.gob.cusco.centro_medico.maintenance.dto.LaboratoryDTO.UpdateLaboratoryDTO;
import pe.gob.cusco.centro_medico.maintenance.dto.ParameterDTO.ParameterPlainDTO;
import pe.gob.cusco.centro_medico.maintenance.entity.Laboratory;
import pe.gob.cusco.centro_medico.maintenance.mapper.LaboratoryMapper;
import pe.gob.cusco.centro_medico.maintenance.mapper.ParameterMapper;
import pe.gob.cusco.centro_medico.maintenance.repository.LaboratoryRepository;
import pe.gob.cusco.centro_medico.maintenance.service.LaboratoryService;
import pe.gob.cusco.centro_medico.shared.BaseServiceImpl;

@Service
public class LaboratoryServiceImpl extends
        BaseServiceImpl<Laboratory, CreateLaboratoryDTO, UpdateLaboratoryDTO, LaboratoryDTO, FiltersLaboratoryDTO>
        implements LaboratoryService {

    private final ParameterMapper parameterMapper;

    public LaboratoryServiceImpl(LaboratoryRepository repository,
            LaboratoryMapper mapper, ParameterMapper parameterMapper) {
        super(repository, mapper);

        this.parameterMapper = parameterMapper;
    }

    @Override
    public LaboratoryParameterDTO getAllWithParametersById(Long id) {

        Laboratory laboratories = repository.findById(id).orElse(null);
        List<ParameterPlainDTO> params = new ArrayList<>();
        laboratories.getParameters().stream().forEach(param -> {
            params.add(parameterMapper.toPlainDTO(param));
        });

        LaboratoryParameterDTO response = LaboratoryParameterDTO.builder()
                .id(laboratories.getId())
                .name(laboratories.getName())
                .type(laboratories.getType())
                .parameter(params)
                .build();
        return response;

    }

}