package pe.gob.cusco.centro_medico.maintenance.util;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.gob.cusco.centro_medico.maintenance.entity.Person;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PatientDTO {
    private Long id;

    private String ocupation;

    private String instructionLevel;

    private String workplace;

    private Long clinicHistory;

    private PersonDTO person;

    @Data
    public static class CreatePatientDTO {

        @NotBlank

        private String ocupation;

        @NotBlank

        private String instructionLevel;

        @NotBlank

        private String workplace;

        @NotNull

        private Long clinicHistory;

        private Long person;

    }

    @Data
    public static class UpdatePatientDTO {

        private String ocupation;

        private String instructionLevel;

        private String workplace;

        private Long clinicHistory;

        private Long person;

    }

    @Data
    public static class FiltersPatientDTO {

        private String ocupation;

        private String instructionLevel;

        private String workplace;

        private Long clinicHistory;

        private Long person;

    }

    @Data
    public static class FiltersPatientSpecDTO {

        private String ocupation;

        private String instructionLevel;

        private String workplace;

        private Long clinicHistory;

        private Person person;

    }
}