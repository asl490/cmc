package pe.gob.cusco.centro_medico.attention.service.impl;

import org.springframework.stereotype.Service;

import pe.gob.cusco.centro_medico.attention.entity.LaboratoryResult;
import pe.gob.cusco.centro_medico.attention.repository.LaboratoryResultRepository;
import pe.gob.cusco.centro_medico.attention.service.LaboratoryResultService;
import pe.gob.cusco.centro_medico.attention.dto.LaboratoryResultDTO;
import pe.gob.cusco.centro_medico.attention.dto.LaboratoryResultDTO.CreateLaboratoryResultDTO;
import pe.gob.cusco.centro_medico.attention.dto.LaboratoryResultDTO.FiltersLaboratoryResultDTO;
import pe.gob.cusco.centro_medico.attention.dto.LaboratoryResultDTO.UpdateLaboratoryResultDTO;
import pe.gob.cusco.centro_medico.attention.mapper.LaboratoryResultMapper;
import pe.gob.cusco.centro_medico.shared.BaseServiceImpl;

@Service
public class LaboratoryResultServiceImpl extends
        BaseServiceImpl<LaboratoryResult, CreateLaboratoryResultDTO, UpdateLaboratoryResultDTO, LaboratoryResultDTO, FiltersLaboratoryResultDTO>
        implements LaboratoryResultService {

    public LaboratoryResultServiceImpl(LaboratoryResultRepository repository,
            LaboratoryResultMapper mapper) {
        super(repository, mapper);

    }

}