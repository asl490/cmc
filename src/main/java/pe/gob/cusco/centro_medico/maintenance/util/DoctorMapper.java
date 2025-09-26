package pe.gob.cusco.centro_medico.maintenance.util;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import pe.gob.cusco.centro_medico.maintenance.entity.Doctor;
import pe.gob.cusco.centro_medico.maintenance.entity.Person;
import pe.gob.cusco.centro_medico.maintenance.util.DoctorDTO.FiltersDoctorDTO;
import pe.gob.cusco.centro_medico.maintenance.util.DoctorDTO.FiltersDoctorSpecDTO;
import pe.gob.cusco.centro_medico.shared.BaseMapper;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class DoctorMapper
        implements BaseMapper<Doctor, DoctorDTO, DoctorDTO.CreateDoctorDTO, DoctorDTO.UpdateDoctorDTO> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "lastModifiedDate", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "lastModifiedBy", ignore = true)
    @Mapping(target = "isDeleted", ignore = true)
    @Mapping(target = "person", source = "person", qualifiedByName = "mapPersonFromId")
    public abstract Doctor toEntity(DoctorDTO.CreateDoctorDTO dto);

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "lastModifiedDate", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "lastModifiedBy", ignore = true)
    @Mapping(target = "isDeleted", ignore = true)
    @Mapping(target = "person", source = "person", qualifiedByName = "mapPersonFromId")
    public abstract void updateEntityFromDTO(DoctorDTO.UpdateDoctorDTO dto, @MappingTarget Doctor entity);

    @Mapping(target = "person", source = "person", qualifiedByName = "mapPersonFromId")
    public abstract FiltersDoctorSpecDTO toSpec(FiltersDoctorDTO dto);

    @Named("mapPersonFromId")
    protected Person mapPersonFromId(Long id) {
        if (id == null) {
            return null;
        }
        return entityManager.find(Person.class, id);
    }

}