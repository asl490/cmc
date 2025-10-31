package pe.gob.cusco.centro_medico.attention.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import pe.gob.cusco.centro_medico.attention.dto.LaboratoryResultDTO;
import pe.gob.cusco.centro_medico.attention.entity.LaboratoryOrder;
import pe.gob.cusco.centro_medico.attention.entity.LaboratoryResult;
import pe.gob.cusco.centro_medico.maintenance.entity.Parameter;
import pe.gob.cusco.centro_medico.shared.BaseMapper;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class LaboratoryResultMapper implements
        BaseMapper<LaboratoryResult, LaboratoryResultDTO, LaboratoryResultDTO.CreateLaboratoryResultDTO, LaboratoryResultDTO.UpdateLaboratoryResultDTO> {

    @PersistenceContext
    private EntityManager entityManager;

    // @Override
    // @Mapping(target = "parameter", source = "parameter.id")
    // @Mapping(target = "laboratoryOrder", source = "laboratoryOrder.name")
    // public abstract LaboratoryResultDTO toDTO(LaboratoryResult entity);

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "lastModifiedDate", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "lastModifiedBy", ignore = true)
    @Mapping(target = "isDeleted", ignore = true)
    @Mapping(target = "parameter", source = "parameter", qualifiedByName = "mapParameter")
    @Mapping(target = "laboratoryOrder", source = "laboratoryOrder", qualifiedByName = "mapLaboratoryOrderFromId")
    public abstract LaboratoryResult toEntity(LaboratoryResultDTO.CreateLaboratoryResultDTO dto);

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "lastModifiedDate", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "lastModifiedBy", ignore = true)
    @Mapping(target = "isDeleted", ignore = true)
    @Mapping(target = "parameter", source = "parameter", qualifiedByName = "mapParameter")
    @Mapping(target = "laboratoryOrder", source = "laboratoryOrder", qualifiedByName = "mapLaboratoryOrderFromId")
    public abstract void updateEntityFromDTO(LaboratoryResultDTO.UpdateLaboratoryResultDTO dto,
            @MappingTarget LaboratoryResult entity);

    @Named("mapParameter")
    protected Parameter mapParameter(Long id) {
        if (id == null) {
            return null;
        }
        return entityManager.find(Parameter.class, id);
    }

    @Named("mapLaboratoryOrderFromId")
    protected LaboratoryOrder mapLaboratoryOrderFromId(Long id) {
        if (id == null) {
            return null;
        }
        return entityManager.find(LaboratoryOrder.class, id);
    }
}