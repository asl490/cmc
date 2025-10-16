package pe.gob.cusco.centro_medico.maintenance.util;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import pe.gob.cusco.centro_medico.maintenance.entity.Patient;
import pe.gob.cusco.centro_medico.maintenance.entity.Person;
import pe.gob.cusco.centro_medico.maintenance.util.PatientDTO.FiltersPatientDTO;
import pe.gob.cusco.centro_medico.maintenance.util.PatientDTO.FiltersPatientSpecDTO;
import pe.gob.cusco.centro_medico.shared.BaseMapper;

@Mapper(componentModel = "spring", uses = {
        PersonMapper.class }, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class PatientMapper
        implements BaseMapper<Patient, PatientDTO, PatientDTO.CreatePatientDTO, PatientDTO.UpdatePatientDTO> {

    @PersistenceContext
    private EntityManager entityManager;

    @Mapping(target = "person", source = "person")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "lastModifiedDate", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "lastModifiedBy", ignore = true)
    @Mapping(target = "isDeleted", ignore = true)
    public abstract Patient toEntity(PatientDTO.CreatePatientAndPersonDTO dto);

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "lastModifiedDate", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "lastModifiedBy", ignore = true)
    @Mapping(target = "isDeleted", ignore = true)
    @Mapping(target = "person", source = "person", qualifiedByName = "mapPersonFromId")
    public abstract Patient toEntity(PatientDTO.CreatePatientDTO dto);

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "lastModifiedDate", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "lastModifiedBy", ignore = true)
    @Mapping(target = "isDeleted", ignore = true)
    @Mapping(target = "person", source = "person", qualifiedByName = "mapPersonFromId")
    public abstract void updateEntityFromDTO(PatientDTO.UpdatePatientDTO dto, @MappingTarget Patient entity);

    @Mapping(target = "person", source = "person", qualifiedByName = "mapPersonFromId")
    public abstract FiltersPatientSpecDTO toSpec(FiltersPatientDTO dto);

    @Named("mapPersonFromId")
    protected Person mapPersonFromId(Long id) {
        if (id == null) {
            return null;
        }
        return entityManager.find(Person.class, id);
    }

}