package pe.gob.cusco.centro_medico.reports.util;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import pe.gob.cusco.centro_medico.maintenance.entity.Patient;
import pe.gob.cusco.centro_medico.reports.entity.MedicalCard;
import pe.gob.cusco.centro_medico.reports.util.MedicalCardDTO.FiltersMedicalCardDTO;
import pe.gob.cusco.centro_medico.reports.util.MedicalCardDTO.FiltersMedicalCardSpecDTO;
import pe.gob.cusco.centro_medico.shared.BaseMapper;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class MedicalCardMapper
        implements
        BaseMapper<MedicalCard, MedicalCardDTO, MedicalCardDTO.CreateMedicalCardDTO, MedicalCardDTO.UpdateMedicalCardDTO> {

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
    public abstract MedicalCard toEntity(MedicalCardDTO.CreateMedicalCardDTO dto);

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "lastModifiedDate", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "lastModifiedBy", ignore = true)
    @Mapping(target = "isDeleted", ignore = true)
    @Mapping(target = "patient", source = "patient", qualifiedByName = "mapPatientFromId")
    public abstract void updateEntityFromDTO(MedicalCardDTO.UpdateMedicalCardDTO dto,
            @MappingTarget MedicalCard entity);

    @Mapping(target = "patient", source = "patient", qualifiedByName = "mapPatientFromId")
    public abstract FiltersMedicalCardSpecDTO toSpec(FiltersMedicalCardDTO dto);

    @Named("mapPatientFromId")
    protected Patient mapPatientFromId(Long id) {
        if (id == null) {
            return null;
        }
        return entityManager.find(Patient.class, id);
    }

}