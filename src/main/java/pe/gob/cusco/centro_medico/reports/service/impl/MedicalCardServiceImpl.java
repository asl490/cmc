package pe.gob.cusco.centro_medico.reports.service.impl;

import org.springframework.stereotype.Service;

import pe.gob.cusco.centro_medico.reports.entity.MedicalCard;
import pe.gob.cusco.centro_medico.reports.repository.MedicalCardRepository;
import pe.gob.cusco.centro_medico.reports.service.MedicalCardService;
import pe.gob.cusco.centro_medico.reports.util.MedicalCardDTO;
import pe.gob.cusco.centro_medico.reports.util.MedicalCardDTO.CreateMedicalCardDTO;
import pe.gob.cusco.centro_medico.reports.util.MedicalCardDTO.FiltersMedicalCardDTO;
import pe.gob.cusco.centro_medico.reports.util.MedicalCardDTO.UpdateMedicalCardDTO;
import pe.gob.cusco.centro_medico.reports.util.MedicalCardMapper;
import pe.gob.cusco.centro_medico.shared.BaseServiceImpl;

@Service
public class MedicalCardServiceImpl extends
        BaseServiceImpl<MedicalCard, CreateMedicalCardDTO, UpdateMedicalCardDTO, MedicalCardDTO, FiltersMedicalCardDTO>
        implements MedicalCardService {

    public MedicalCardServiceImpl(MedicalCardRepository repository,
            MedicalCardMapper mapper) {
        super(repository, mapper);

    }

}