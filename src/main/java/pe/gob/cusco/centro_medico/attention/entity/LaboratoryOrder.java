package pe.gob.cusco.centro_medico.attention.entity;

import pe.gob.cusco.centro_medico.shared.Auditable;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class LaboratoryOrder extends Auditable {

    private Long laboratory;

    private Long appointment;

    private String status;

}