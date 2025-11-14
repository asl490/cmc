package pe.gob.cusco.centro_medico.attention.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import pe.gob.cusco.centro_medico.attention.dto.LaboratoryOrderDTO;
import pe.gob.cusco.centro_medico.attention.dto.LaboratoryResultDTO;
import pe.gob.cusco.centro_medico.attention.dto.LaboratoryResultDTO.CreateLaboratoryResultDTO;
import pe.gob.cusco.centro_medico.attention.dto.LaboratoryResultDTO.FiltersLaboratoryResultDTO;
import pe.gob.cusco.centro_medico.attention.dto.LaboratoryResultDTO.LaboratoryResultFieldsDTO;
import pe.gob.cusco.centro_medico.attention.dto.LaboratoryResultDTO.LaboratoryResultMinDTO;
import pe.gob.cusco.centro_medico.attention.dto.LaboratoryResultDTO.UpdateLaboratoryResultAllDTO;
import pe.gob.cusco.centro_medico.attention.dto.LaboratoryResultDTO.UpdateLaboratoryResultDTO;
import pe.gob.cusco.centro_medico.attention.entity.LaboratoryResult;
import pe.gob.cusco.centro_medico.attention.mapper.LaboratoryResultMapper;
import pe.gob.cusco.centro_medico.attention.repository.LaboratoryResultRepository;
import pe.gob.cusco.centro_medico.attention.service.LaboratoryOrderService;
import pe.gob.cusco.centro_medico.attention.service.LaboratoryResultService;
import pe.gob.cusco.centro_medico.maintenance.dto.LaboratoryDTO.LaboratoryParameterDTO;
import pe.gob.cusco.centro_medico.maintenance.service.LaboratoryService;
import pe.gob.cusco.centro_medico.shared.BaseServiceImpl;

@Service
public class LaboratoryResultServiceImpl extends
        BaseServiceImpl<LaboratoryResult, CreateLaboratoryResultDTO, UpdateLaboratoryResultDTO, LaboratoryResultDTO, FiltersLaboratoryResultDTO>
        implements LaboratoryResultService {
    private final LaboratoryOrderService laboratoryOrderService;
    private final LaboratoryService laboratoryService;
    private final LaboratoryResultRepository repository;
    private final LaboratoryResultMapper mapper;

    public LaboratoryResultServiceImpl(LaboratoryResultRepository repository,
            LaboratoryResultMapper mapper, LaboratoryOrderService laboratoryOrderService,
            LaboratoryService laboratoryService) {
        super(repository, mapper);
        this.laboratoryOrderService = laboratoryOrderService;
        this.laboratoryService = laboratoryService;
        this.repository = repository;
        this.mapper = mapper;

    }

    @Override
    public LaboratoryResultFieldsDTO getParametersByAppointmentId(Long appointmentId) {

        List<LaboratoryOrderDTO> laboratoryOrders = laboratoryOrderService.getByAppointmentId(appointmentId);

        LaboratoryResultFieldsDTO result = null;
        List<LaboratoryParameterDTO> labs = new ArrayList<>();
        for (LaboratoryOrderDTO order : laboratoryOrders) {

            LaboratoryParameterDTO labParameter = laboratoryService
                    .getAllWithParametersById(order.getLaboratory().getId());
            labParameter.setLaboratoryOrder(order.getId());
            labs.add(labParameter);

            result = LaboratoryResultFieldsDTO.builder()
                    .appointment(appointmentId)
                    .laboratory(labs)
                    .build();

        }
        return result;
    }

    @Override
    public List<LaboratoryResultMinDTO> getResultsByAppointmentId(Long appointmentId) {
        return repository.findByLaboratoryOrderAppointmentId(appointmentId).stream()
                .map(mapper::toMinDTO)
                .toList();
    }

    @Override
    public void createAllDto(List<CreateLaboratoryResultDTO> dtoList) {

        dtoList.forEach(dto -> {
            super.create(dto);
            laboratoryOrderService.updateStatusById(dto.getLaboratoryOrder(), "COMPLETADO");
        });
    }

    @Override
    public void updateAllDto(List<UpdateLaboratoryResultAllDTO> dtoList) {
        dtoList.forEach(dto -> {
            UpdateLaboratoryResultDTO updateDto = new UpdateLaboratoryResultDTO();
            updateDto.setLaboratoryOrder(dto.getLaboratoryOrder());
            updateDto.setParameter(dto.getParameter());
            updateDto.setNumericalValue(dto.getNumericalValue());
            updateDto.setTextValue(dto.getTextValue());
            updateDto.setObservation(dto.getObservation());

            super.update(dto.getId(), updateDto);
        });
    }

}