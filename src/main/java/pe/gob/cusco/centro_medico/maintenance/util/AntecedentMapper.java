package pe.gob.cusco.centro_medico.maintenance.util;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import pe.gob.cusco.centro_medico.maintenance.entity.Antecedent;
import pe.gob.cusco.centro_medico.shared.BaseMapper;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface AntecedentMapper extends BaseMapper<Antecedent, AntecedentDTO, AntecedentDTO.CreateAntecedentDTO, AntecedentDTO.UpdateAntecedentDTO> {

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "lastModifiedDate", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "lastModifiedBy", ignore = true)
    @Mapping(target = "isDeleted", ignore = true)
    Antecedent toEntity(AntecedentDTO.CreateAntecedentDTO dto);

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "lastModifiedDate", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "lastModifiedBy", ignore = true)
    @Mapping(target = "isDeleted", ignore = true)
    void updateEntityFromDTO(AntecedentDTO.UpdateAntecedentDTO dto, @MappingTarget Antecedent entity);

}