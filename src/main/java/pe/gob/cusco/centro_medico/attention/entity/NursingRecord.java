package pe.gob.cusco.centro_medico.attention.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import pe.gob.cusco.centro_medico.maintenance.entity.VitalSign;
import pe.gob.cusco.centro_medico.shared.Auditable;

@Data
@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class NursingRecord extends Auditable {

    @ManyToOne
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;

    @ManyToOne
    @JoinColumn(name = "vital_sign_id")
    private VitalSign vitalSign;

    private Double numericalValue;

    private String textValue;

    private String observations;

}