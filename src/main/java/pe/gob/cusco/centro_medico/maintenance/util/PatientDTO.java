package pe.gob.cusco.centro_medico.maintenance.util;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.gob.cusco.centro_medico.maintenance.entity.Person;
import pe.gob.cusco.centro_medico.maintenance.util.PersonDTO.CreatePersonDTO;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PatientDTO {
    private Long id;

    private String occupation;

    private String instructionLevel;

    private String workplace;

    private String clinicHistory;

    private PersonDTO person;
    private Boolean hasHistory;

    @Data
    public static class CreatePatientDTO {

        @NotBlank

        private String occupation;

        @NotBlank

        private String instructionLevel;

        @NotBlank

        private String workplace;

        @NotNull

        private String clinicHistory;

        private Long person;

    }

    @Data
    public static class UpdatePatientDTO {

        private String occupation;

        private String instructionLevel;

        private String workplace;

        private String clinicHistory;

        private Long person;

    }

    @Data
    public static class FiltersPatientDTO {

        private String occupation;

        private String instructionLevel;

        private String workplace;

        private String clinicHistory;

        private Long person;

    }

    @Data
    public static class FiltersPatientSpecDTO {

        private String occupation;

        private String instructionLevel;

        private String workplace;

        private String clinicHistory;

        private Person person;

    }

    @Data
    public static class FiltersPatientPersonDTO {

        private String clinicHistory;

        private String dni;

        private String name;

        private String surname;

    }

    @Data
    public static class CreatePatientAndPersonDTO {
        private CreatePersonDTO person;
        @NotBlank
        private String occupation;

        @NotBlank
        private String instructionLevel;

        @NotBlank
        private String workplace;

        @NotBlank
        private String clinicHistory;
    }
}
