package pe.gob.cusco.centro_medico.maintenance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import pe.gob.cusco.centro_medico.maintenance.entity.enums.TypeAntecedent;
import pe.gob.cusco.centro_medico.maintenance.entity.enums.TypeData;
import pe.gob.cusco.centro_medico.shared.Auditable;

@Data
@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Antecedent extends Auditable {

    private String name;

    private String description;

    @Enumerated(EnumType.STRING)
    private TypeAntecedent typeAntecedent;

    @Enumerated(EnumType.STRING)
    private TypeData typeData;

}