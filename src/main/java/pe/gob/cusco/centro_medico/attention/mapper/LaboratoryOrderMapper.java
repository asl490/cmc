package pe.gob.cusco.centro_medico.attention.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import pe.gob.cusco.centro_medico.attention.dto.LaboratoryOrderDTO;
import pe.gob.cusco.centro_medico.attention.entity.Appointment;
import pe.gob.cusco.centro_medico.attention.entity.LaboratoryOrder;
import pe.gob.cusco.centro_medico.maintenance.entity.Laboratory;
import pe.gob.cusco.centro_medico.shared.BaseMapper;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class LaboratoryOrderMapper implements
        BaseMapper<LaboratoryOrder, LaboratoryOrderDTO, LaboratoryOrderDTO.CreateLaboratoryOrderDTO, LaboratoryOrderDTO.UpdateLaboratoryOrderDTO> {

    @PersistenceContext
    private EntityManager entityManager;

    // @Override
    // @Mapping(target = "appointment", source = "appointment.id")
    // @Mapping(target = "laboratory", source = "laboratory.name")
    // public abstract LaboratoryOrderDTO toDTO(LaboratoryOrder entity);

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "lastModifiedDate", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "lastModifiedBy", ignore = true)
    @Mapping(target = "isDeleted", ignore = true)
    @Mapping(target = "appointment", source = "appointment", qualifiedByName = "mapAppointmentFromId")
    @Mapping(target = "laboratory", source = "laboratory", qualifiedByName = "mapLaboratoryFromId")
    public abstract LaboratoryOrder toEntity(LaboratoryOrderDTO.CreateLaboratoryOrderDTO dto);

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "lastModifiedDate", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "lastModifiedBy", ignore = true)
    @Mapping(target = "isDeleted", ignore = true)
    @Mapping(target = "appointment", source = "appointment", qualifiedByName = "mapAppointmentFromId")
    @Mapping(target = "laboratory", source = "laboratory", qualifiedByName = "mapLaboratoryFromId")
    public abstract void updateEntityFromDTO(LaboratoryOrderDTO.UpdateLaboratoryOrderDTO dto,
            @MappingTarget LaboratoryOrder entity);

    // @Mapping(target = "appointment", source = "appointment", qualifiedByName =
    // "mapAppointmentFromId")
    // public abstract FiltersLaboratoryOrderSpecDTO
    // toSpec(FiltersLaboratoryOrderDTO dto);

    @Named("mapAppointmentFromId")
    protected Appointment mapAppointmentFromId(Long id) {
        if (id == null) {
            return null;
        }
        return entityManager.find(Appointment.class, id);
    }

    @Named("mapLaboratoryFromId")
    protected Laboratory mapLaboratoryFromId(Long id) {
        if (id == null) {
            return null;
        }
        return entityManager.find(Laboratory.class, id);
    }
}