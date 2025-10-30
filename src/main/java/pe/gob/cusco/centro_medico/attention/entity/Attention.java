package pe.gob.cusco.centro_medico.attention.entity;

import jakarta.persistence.Column;
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
public class Attention extends Auditable {

    @OneToOne
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;

    @Column(length = 1000)
    private String reason;
    @Column(length = 1000)
    private String phisicalExam;
    @Column(length = 1000)
    private String diagnosis;
    @Column(length = 1000)
    private String treatment;

    private String referral;
    @Column(length = 1000)
    private String observation;

}