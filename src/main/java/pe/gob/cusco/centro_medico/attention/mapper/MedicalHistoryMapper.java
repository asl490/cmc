package pe.gob.cusco.centro_medico.attention.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import pe.gob.cusco.centro_medico.attention.dto.MedicalHistoryDTO;
import pe.gob.cusco.centro_medico.attention.entity.MedicalHistory;
import pe.gob.cusco.centro_medico.shared.BaseMapper;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface MedicalHistoryMapper extends
        BaseMapper<MedicalHistory, MedicalHistoryDTO, MedicalHistoryDTO.CreateMedicalHistoryDTO, MedicalHistoryDTO.UpdateMedicalHistoryDTO> {

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "lastModifiedDate", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "lastModifiedBy", ignore = true)
    @Mapping(target = "isDeleted", ignore = true)
    MedicalHistory toEntity(MedicalHistoryDTO.CreateMedicalHistoryDTO dto);

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "lastModifiedDate", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "lastModifiedBy", ignore = true)
    @Mapping(target = "isDeleted", ignore = true)
    void updateEntityFromDTO(MedicalHistoryDTO.UpdateMedicalHistoryDTO dto, @MappingTarget MedicalHistory entity);

}