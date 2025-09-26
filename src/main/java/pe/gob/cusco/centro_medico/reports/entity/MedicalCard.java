package pe.gob.cusco.centro_medico.reports.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import pe.gob.cusco.centro_medico.maintenance.entity.Patient;
import pe.gob.cusco.centro_medico.shared.Auditable;

@Data
@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class MedicalCard extends Auditable {

    private String result;

    private String bloodType;

    private String rpr;

    private String parasitology;

    private LocalDate emisionDate;

    private LocalDate caducityDate;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

}