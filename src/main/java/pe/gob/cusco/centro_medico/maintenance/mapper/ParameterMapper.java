package pe.gob.cusco.centro_medico.maintenance.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import pe.gob.cusco.centro_medico.maintenance.dto.ParameterDTO;
import pe.gob.cusco.centro_medico.maintenance.dto.ParameterDTO.ParameterPlainDTO;
import pe.gob.cusco.centro_medico.maintenance.entity.Laboratory;
import pe.gob.cusco.centro_medico.maintenance.entity.Parameter;
// import pe.gob.cusco.centro_medico.maintenance.util.ParameterDTO.FiltersParameterDTO;
// import pe.gob.cusco.centro_medico.maintenance.util.ParameterDTO.FiltersParameterSpecDTO;
import pe.gob.cusco.centro_medico.shared.BaseMapper;

@Mapper(componentModel = "spring", uses = {
        LaboratoryMapper.class }, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class ParameterMapper
        implements
        BaseMapper<Parameter, ParameterDTO, ParameterDTO.CreateParameterDTO, ParameterDTO.UpdateParameterDTO> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "lastModifiedDate", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "lastModifiedBy", ignore = true)
    @Mapping(target = "isDeleted", ignore = true)
    @Mapping(target = "laboratory", source = "laboratory", qualifiedByName = "mapLaboratoryFromId")
    public abstract Parameter toEntity(ParameterDTO.CreateParameterDTO dto);

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "lastModifiedDate", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "lastModifiedBy", ignore = true)
    @Mapping(target = "isDeleted", ignore = true)
    @Mapping(target = "laboratory", source = "laboratory", qualifiedByName = "mapLaboratoryFromId")
    public abstract void updateEntityFromDTO(ParameterDTO.UpdateParameterDTO dto, @MappingTarget Parameter entity);

    @Mapping(target = "laboratory", source = "laboratory.id")
    public abstract ParameterPlainDTO toPlainDTO(Parameter entity);

    @Named("mapLaboratoryFromId")
    protected Laboratory mapLaboratoryFromId(Long id) {
        if (id == null) {
            return null;
        }
        return entityManager.find(Laboratory.class, id);
    }

}