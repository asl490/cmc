package pe.gob.cusco.centro_medico.maintenance.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import pe.gob.cusco.centro_medico.shared.Auditable;

@Data
@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Parameter extends Auditable {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "laboratory_id")
    private Laboratory laboratory;

    private String name;

    private Double maxValue;

    private Double minValue;

    private String unit;

    private Boolean isQualitative;

}