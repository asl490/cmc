package pe.gob.cusco.centro_medico.maintenance.entity;

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
public class Person extends Auditable {

    private String name;

    private String surname;

    private String email;

    private String phone;

    private String dni;

    private String civilStatus;

    private String address;

    private LocalDate birthDate;

    private Integer age;

    private String birthLocation;

}