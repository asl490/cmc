package pe.gob.cusco.centro_medico.attention.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import pe.gob.cusco.centro_medico.attention.dto.AttentionDTO;
import pe.gob.cusco.centro_medico.attention.entity.Appointment;
import pe.gob.cusco.centro_medico.attention.entity.Attention;
// import pe.gob.cusco.centro_medico.maintenance.util.AttentionDTO.FiltersAttentionDTO;
// import pe.gob.cusco.centro_medico.maintenance.util.AttentionDTO.FiltersAttentionSpecDTO;
import pe.gob.cusco.centro_medico.shared.BaseMapper;

@Mapper(componentModel = "spring", uses = {
        AppointmentMapper.class }, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class AttentionMapper
        implements
        BaseMapper<Attention, AttentionDTO, AttentionDTO.CreateAttentionDTO, AttentionDTO.UpdateAttentionDTO> {

    @PersistenceContext
    private EntityManager entityManager;

    // @Mapping(target = "appointment", source = "appointment")
    // @Mapping(target = "id", ignore = true)
    // @Mapping(target = "createdDate", ignore = true)
    // @Mapping(target = "lastModifiedDate", ignore = true)
    // @Mapping(target = "createdBy", ignore = true)
    // @Mapping(target = "lastModifiedBy", ignore = true)
    // @Mapping(target = "isDeleted", ignore = true)
    // public abstract Attention
    // toEntity(AttentionDTO.CreateAttentionAndAppointmentDTO dto);

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "lastModifiedDate", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "lastModifiedBy", ignore = true)
    @Mapping(target = "isDeleted", ignore = true)
    @Mapping(target = "appointment", source = "appointment", qualifiedByName = "mapAppointmentFromId")
    public abstract Attention toEntity(AttentionDTO.CreateAttentionDTO dto);

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "lastModifiedDate", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "lastModifiedBy", ignore = true)
    @Mapping(target = "isDeleted", ignore = true)
    @Mapping(target = "appointment", source = "appointment", qualifiedByName = "mapAppointmentFromId")
    public abstract void updateEntityFromDTO(AttentionDTO.UpdateAttentionDTO dto, @MappingTarget Attention entity);

    // @Mapping(target = "appointment", source = "appointment", qualifiedByName =
    // "mapAppointmentFromId")
    // public abstract FiltersAttentionSpecDTO toSpec(FiltersAttentionDTO dto);

    @Named("mapAppointmentFromId")
    protected Appointment mapAppointmentFromId(Long id) {
        if (id == null) {
            return null;
        }
        return entityManager.find(Appointment.class, id);
    }

}