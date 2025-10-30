package pe.gob.cusco.centro_medico.maintenance.service.impl;

import org.springframework.stereotype.Service;

import pe.gob.cusco.centro_medico.maintenance.entity.Laboratory;
import pe.gob.cusco.centro_medico.maintenance.repository.LaboratoryRepository;
import pe.gob.cusco.centro_medico.maintenance.service.LaboratoryService;
import pe.gob.cusco.centro_medico.maintenance.dto.LaboratoryDTO;
import pe.gob.cusco.centro_medico.maintenance.dto.LaboratoryDTO.CreateLaboratoryDTO;
import pe.gob.cusco.centro_medico.maintenance.dto.LaboratoryDTO.FiltersLaboratoryDTO;
import pe.gob.cusco.centro_medico.maintenance.dto.LaboratoryDTO.UpdateLaboratoryDTO;
import pe.gob.cusco.centro_medico.maintenance.mapper.LaboratoryMapper;
import pe.gob.cusco.centro_medico.shared.BaseServiceImpl;

@Service
public class LaboratoryServiceImpl extends
        BaseServiceImpl<Laboratory, CreateLaboratoryDTO, UpdateLaboratoryDTO, LaboratoryDTO, FiltersLaboratoryDTO>
        implements LaboratoryService {

    public LaboratoryServiceImpl(LaboratoryRepository repository,
            LaboratoryMapper mapper) {
        super(repository, mapper);

    }

}