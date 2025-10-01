package pe.gob.cusco.centro_medico.attention.util;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import pe.gob.cusco.centro_medico.attention.entity.Appointment;
import pe.gob.cusco.centro_medico.maintenance.entity.Concept;
import pe.gob.cusco.centro_medico.maintenance.entity.Doctor;
import pe.gob.cusco.centro_medico.maintenance.entity.Patient;
import pe.gob.cusco.centro_medico.shared.BaseMapper;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class AppointmentMapper implements
        BaseMapper<Appointment, AppointmentDTO, AppointmentDTO.CreateAppointmentDTO, AppointmentDTO.UpdateAppointmentDTO> {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "lastModifiedDate", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "lastModifiedBy", ignore = true)
    @Mapping(target = "isDeleted", ignore = true)
    @Mapping(target = "patient", source = "patient", qualifiedByName = "mapPatientFromId")
    @Mapping(target = "doctor", source = "doctor", qualifiedByName = "mapDoctorFromId")
    @Mapping(target = "concept", source = "concept", qualifiedByName = "mapConceptFromId")
    public abstract Appointment toEntity(AppointmentDTO.CreateAppointmentDTO dto);

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "lastModifiedDate", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "lastModifiedBy", ignore = true)
    @Mapping(target = "isDeleted", ignore = true)
    @Mapping(target = "patient", source = "patient", qualifiedByName = "mapPatientFromId")
    @Mapping(target = "doctor", source = "doctor", qualifiedByName = "mapDoctorFromId")
    @Mapping(target = "concept", source = "concept", qualifiedByName = "mapConceptFromId")
    public abstract void updateEntityFromDTO(AppointmentDTO.UpdateAppointmentDTO dto,
            @MappingTarget Appointment entity);

    @Named("mapPatientFromId")
    protected Patient mapPatientFromId(Long id) {
        if (id == null) {
            return null;
        }
        return entityManager.find(Patient.class, id);
    }

    @Named("mapDoctorFromId")
    protected Doctor mapDoctorFromId(Long id) {
        if (id == null) {
            return null;
        }
        return entityManager.find(Doctor.class, id);
    }

    @Named("mapConceptFromId")
    protected Concept mapConceptFromId(Long id) {
        if (id == null) {
            return null;
        }
        return entityManager.find(Concept.class, id);
    }

}