package pe.gob.cusco.centro_medico.maintenance.service.impl;

import org.springframework.stereotype.Service;

import pe.gob.cusco.centro_medico.maintenance.entity.Parameter;
import pe.gob.cusco.centro_medico.maintenance.repository.ParameterRepository;
import pe.gob.cusco.centro_medico.maintenance.service.ParameterService;
import pe.gob.cusco.centro_medico.maintenance.dto.ParameterDTO;
import pe.gob.cusco.centro_medico.maintenance.dto.ParameterDTO.CreateParameterDTO;
import pe.gob.cusco.centro_medico.maintenance.dto.ParameterDTO.FiltersParameterDTO;
import pe.gob.cusco.centro_medico.maintenance.dto.ParameterDTO.UpdateParameterDTO;
import pe.gob.cusco.centro_medico.maintenance.mapper.ParameterMapper;
import pe.gob.cusco.centro_medico.shared.BaseServiceImpl;

@Service
public class ParameterServiceImpl extends
        BaseServiceImpl<Parameter, CreateParameterDTO, UpdateParameterDTO, ParameterDTO, FiltersParameterDTO>
        implements ParameterService {

    public ParameterServiceImpl(ParameterRepository repository,
            ParameterMapper mapper) {
        super(repository, mapper);

    }

}