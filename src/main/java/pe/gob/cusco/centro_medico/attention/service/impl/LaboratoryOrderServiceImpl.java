package pe.gob.cusco.centro_medico.attention.service.impl;

import org.springframework.stereotype.Service;

import pe.gob.cusco.centro_medico.attention.entity.LaboratoryOrder;
import pe.gob.cusco.centro_medico.attention.repository.LaboratoryOrderRepository;
import pe.gob.cusco.centro_medico.attention.service.LaboratoryOrderService;
import pe.gob.cusco.centro_medico.attention.dto.LaboratoryOrderDTO;
import pe.gob.cusco.centro_medico.attention.dto.LaboratoryOrderDTO.CreateLaboratoryOrderDTO;
import pe.gob.cusco.centro_medico.attention.dto.LaboratoryOrderDTO.FiltersLaboratoryOrderDTO;
import pe.gob.cusco.centro_medico.attention.dto.LaboratoryOrderDTO.UpdateLaboratoryOrderDTO;
import pe.gob.cusco.centro_medico.attention.mapper.LaboratoryOrderMapper;
import pe.gob.cusco.centro_medico.shared.BaseServiceImpl;

@Service
public class LaboratoryOrderServiceImpl extends
        BaseServiceImpl<LaboratoryOrder, CreateLaboratoryOrderDTO, UpdateLaboratoryOrderDTO, LaboratoryOrderDTO, FiltersLaboratoryOrderDTO>
        implements LaboratoryOrderService {

    public LaboratoryOrderServiceImpl(LaboratoryOrderRepository repository,
            LaboratoryOrderMapper mapper) {
        super(repository, mapper);

    }

}