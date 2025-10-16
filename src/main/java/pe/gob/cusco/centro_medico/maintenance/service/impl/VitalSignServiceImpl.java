package pe.gob.cusco.centro_medico.maintenance.service.impl;

import org.springframework.stereotype.Service;

import pe.gob.cusco.centro_medico.maintenance.entity.VitalSign;
import pe.gob.cusco.centro_medico.maintenance.repository.VitalSignRepository;
import pe.gob.cusco.centro_medico.maintenance.service.VitalSignService;
import pe.gob.cusco.centro_medico.maintenance.util.VitalSignDTO;
import pe.gob.cusco.centro_medico.maintenance.util.VitalSignDTO.CreateVitalSignDTO;
import pe.gob.cusco.centro_medico.maintenance.util.VitalSignDTO.FiltersVitalSignDTO;
import pe.gob.cusco.centro_medico.maintenance.util.VitalSignDTO.UpdateVitalSignDTO;
import pe.gob.cusco.centro_medico.maintenance.util.VitalSignMapper;
import pe.gob.cusco.centro_medico.shared.BaseServiceImpl;

@Service
public class VitalSignServiceImpl extends
        BaseServiceImpl<VitalSign, CreateVitalSignDTO, UpdateVitalSignDTO, VitalSignDTO, FiltersVitalSignDTO>
        implements VitalSignService {

    public VitalSignServiceImpl(VitalSignRepository repository,
            VitalSignMapper mapper) {
        super(repository, mapper);

    }

}