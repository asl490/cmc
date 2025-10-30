package pe.gob.cusco.centro_medico.attention.service.impl;

import java.util.List;

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
    private final MedicalHistoryRepository repository;

    public MedicalHistoryServiceImpl(MedicalHistoryRepository repository,
            MedicalHistoryMapper mapper) {
        super(repository, mapper);
        this.repository = repository;

    }

    @Override
    public List<MedicalHistoryDTO> getByPatient(Long patientId) {

        return super.mapper.toDTOList(repository.findByPatient(patientId));
    }

}