package pe.gob.cusco.centro_medico.attention.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import pe.gob.cusco.centro_medico.maintenance.entity.Parameter;
import pe.gob.cusco.centro_medico.shared.Auditable;

@Data
@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class LaboratoryResult extends Auditable {

    @ManyToOne
    @JoinColumn(name = "laboratory_order_id")
    private LaboratoryOrder laboratoryOrder;
    @ManyToOne
    @JoinColumn(name = "parameter_id")
    private Parameter parameter;

    private Long numericalValue;

    private String textValue;

    private String observation;

}