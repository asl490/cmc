package pe.gob.cusco.centro_medico.attention.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
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
public class MedicalHistory extends Auditable {

    private Long patient;

    private Long antecedent;

    private Boolean valueBoolean;

    private String valueString;

    private LocalDate valueDate;

    private Integer valueNumber;

    private String observation;

}