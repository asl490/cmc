package pe.gob.cusco.centro_medico.attention.service.impl;

import org.springframework.stereotype.Service;

import pe.gob.cusco.centro_medico.attention.dto.MedicalHistoryDTO;
import pe.gob.cusco.centro_medico.attention.dto.MedicalHistoryDTO.CreateMedicalHistoryDTO;
import pe.gob.cusco.centro_medico.attention.dto.MedicalHistoryDTO.FiltersMedicalHistoryDTO;
import pe.gob.cusco.centro_medico.attention.dto.MedicalHistoryDTO.UpdateMedicalHistoryDTO;
import pe.gob.cusco.centro_medico.attention.entity.MedicalHistory;
import pe.gob.cusco.centro_medico.attention.mapper.MedicalHistoryMapper;
import pe.gob.cusco.centro_medico.attention.repository.MedicalHistoryRepository;
import pe.gob.cusco.centro_medico.attention.service.MedicalHistoryService;
import pe.gob.cusco.centro_medico.shared.BaseServiceImpl;

@Service
public class MedicalHistoryServiceImpl extends
        BaseServiceImpl<MedicalHistory, CreateMedicalHistoryDTO, UpdateMedicalHistoryDTO, MedicalHistoryDTO, FiltersMedicalHistoryDTO>
        implements MedicalHistoryService {

    public MedicalHistoryServiceImpl(MedicalHistoryRepository repository,
            MedicalHistoryMapper mapper) {
        super(repository, mapper);

    }

}