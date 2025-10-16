package pe.gob.cusco.centro_medico.maintenance.service.impl;

import org.springframework.stereotype.Service;

import pe.gob.cusco.centro_medico.maintenance.entity.Antecedent;
import pe.gob.cusco.centro_medico.maintenance.repository.AntecedentRepository;
import pe.gob.cusco.centro_medico.maintenance.service.AntecedentService;
import pe.gob.cusco.centro_medico.maintenance.util.AntecedentDTO;
import pe.gob.cusco.centro_medico.maintenance.util.AntecedentDTO.CreateAntecedentDTO;
import pe.gob.cusco.centro_medico.maintenance.util.AntecedentDTO.FiltersAntecedentDTO;
import pe.gob.cusco.centro_medico.maintenance.util.AntecedentDTO.UpdateAntecedentDTO;
import pe.gob.cusco.centro_medico.maintenance.util.AntecedentMapper;
import pe.gob.cusco.centro_medico.shared.BaseServiceImpl;

@Service
public class AntecedentServiceImpl extends
        BaseServiceImpl<Antecedent, CreateAntecedentDTO, UpdateAntecedentDTO, AntecedentDTO, FiltersAntecedentDTO>
        implements AntecedentService {

    public AntecedentServiceImpl(AntecedentRepository repository,
            AntecedentMapper mapper) {
        super(repository, mapper);

    }

}