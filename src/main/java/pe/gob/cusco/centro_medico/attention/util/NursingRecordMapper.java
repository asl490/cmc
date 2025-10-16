package pe.gob.cusco.centro_medico.attention.util;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import pe.gob.cusco.centro_medico.attention.entity.Appointment;
import pe.gob.cusco.centro_medico.attention.entity.NursingRecord;
import pe.gob.cusco.centro_medico.attention.util.NursingRecordDTO.FiltersNursingRecordDTO;
import pe.gob.cusco.centro_medico.attention.util.NursingRecordDTO.FiltersNursingRecordSpecDTO;
import pe.gob.cusco.centro_medico.maintenance.entity.VitalSign;
import pe.gob.cusco.centro_medico.shared.BaseMapper;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class NursingRecordMapper implements
        BaseMapper<NursingRecord, NursingRecordDTO, NursingRecordDTO.CreateNursingRecordDTO, NursingRecordDTO.UpdateNursingRecordDTO> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Mapping(target = "appointment", source = "appointment.id")
    @Mapping(target = "vitalSign", source = "vitalSign.name")
    public abstract NursingRecordDTO toDTO(NursingRecord entity);

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "lastModifiedDate", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "lastModifiedBy", ignore = true)
    @Mapping(target = "isDeleted", ignore = true)
    @Mapping(target = "appointment", source = "appointment", qualifiedByName = "mapAppointmentFromId")
    @Mapping(target = "vitalSign", source = "vitalSign", qualifiedByName = "mapVitalSignFromId")
    public abstract NursingRecord toEntity(NursingRecordDTO.CreateNursingRecordDTO dto);

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "lastModifiedDate", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "lastModifiedBy", ignore = true)
    @Mapping(target = "isDeleted", ignore = true)
    @Mapping(target = "appointment", source = "appointment", qualifiedByName = "mapAppointmentFromId")
    @Mapping(target = "vitalSign", source = "vitalSign", qualifiedByName = "mapVitalSignFromId")
    public abstract void updateEntityFromDTO(NursingRecordDTO.UpdateNursingRecordDTO dto,
            @MappingTarget NursingRecord entity);

    @Mapping(target = "appointment", source = "appointment", qualifiedByName = "mapAppointmentFromId")
    public abstract FiltersNursingRecordSpecDTO toSpec(FiltersNursingRecordDTO dto);

    @Named("mapAppointmentFromId")
    protected Appointment mapAppointmentFromId(Long id) {
        if (id == null) {
            return null;
        }
        return entityManager.find(Appointment.class, id);
    }

    @Named("mapVitalSignFromId")
    protected VitalSign mapVitalSignFromId(Long id) {
        if (id == null) {
            return null;
        }
        return entityManager.find(VitalSign.class, id);
    }
}