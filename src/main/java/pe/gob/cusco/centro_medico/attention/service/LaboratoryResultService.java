package pe.gob.cusco.centro_medico.attention.service;

import java.util.List;

import pe.gob.cusco.centro_medico.attention.dto.LaboratoryResultDTO;
import pe.gob.cusco.centro_medico.attention.dto.LaboratoryResultDTO.LaboratoryResultFieldsDTO;
import pe.gob.cusco.centro_medico.attention.dto.LaboratoryResultDTO.LaboratoryResultMinDTO;
import pe.gob.cusco.centro_medico.shared.BaseService;

public interface LaboratoryResultService
                extends
                BaseService<LaboratoryResultDTO.CreateLaboratoryResultDTO, LaboratoryResultDTO.UpdateLaboratoryResultDTO, LaboratoryResultDTO, LaboratoryResultDTO.FiltersLaboratoryResultDTO> {

        LaboratoryResultFieldsDTO getParametersByAppointmentId(Long appointmentId);

        List<LaboratoryResultMinDTO> getResultsByAppointmentId(Long appointmentId);

        void createAllDto(List<LaboratoryResultDTO.CreateLaboratoryResultDTO> dtoList);
}