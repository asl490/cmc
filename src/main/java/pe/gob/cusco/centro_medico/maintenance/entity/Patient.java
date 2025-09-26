package pe.gob.cusco.centro_medico.maintenance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
public class Patient extends Auditable {

    private String ocupation;

    private String instructionLevel;

    private String workplace;

    private Long clinicHistory;

    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;

}