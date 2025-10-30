package pe.gob.cusco.centro_medico.attention.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import pe.gob.cusco.centro_medico.attention.dto.MedicalHistoryDTO;
import pe.gob.cusco.centro_medico.attention.entity.MedicalHistory;
import pe.gob.cusco.centro_medico.maintenance.entity.Antecedent;
import pe.gob.cusco.centro_medico.maintenance.util.AntecedentDTO;
import pe.gob.cusco.centro_medico.maintenance.util.AntecedentMapper;
import pe.gob.cusco.centro_medico.shared.BaseMapper;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class MedicalHistoryMapper implements
        BaseMapper<MedicalHistory, MedicalHistoryDTO, MedicalHistoryDTO.CreateMedicalHistoryDTO, MedicalHistoryDTO.UpdateMedicalHistoryDTO> {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private AntecedentMapper antecedentMapper;

    @Override
    @Mapping(target = "antecedent", source = "antecedent", qualifiedByName = "mapAntecedentFromId")
    public abstract MedicalHistoryDTO toDTO(MedicalHistory entity);

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "lastModifiedDate", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "lastModifiedBy", ignore = true)
    @Mapping(target = "isDeleted", ignore = true)
    public abstract MedicalHistory toEntity(MedicalHistoryDTO.CreateMedicalHistoryDTO dto);

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "lastModifiedDate", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "lastModifiedBy", ignore = true)
    @Mapping(target = "isDeleted", ignore = true)
    public abstract void updateEntityFromDTO(MedicalHistoryDTO.UpdateMedicalHistoryDTO dto,
            @MappingTarget MedicalHistory entity);

    @Named("mapAntecedentFromId")
    protected AntecedentDTO mapAntecedentFromId(Long id) {
        if (id == null) {
            return null;
        }
        Antecedent antecedent = entityManager.find(Antecedent.class, id);
        return antecedentMapper.toDTO(antecedent);
    }

}