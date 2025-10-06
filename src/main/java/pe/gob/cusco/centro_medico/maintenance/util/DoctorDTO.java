package pe.gob.cusco.centro_medico.maintenance.util;

import jakarta.validation.constraints.NotBlank;
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
public class DoctorDTO {
    private Long id;

    private String specialty;

    private PersonDTO person;

    @Data
    public static class CreateDoctorDTO {

        @NotBlank

        private String specialty;

        private Long person;

    }

    @Data
    public static class UpdateDoctorDTO {

        private String specialty;

        private Long person;

    }

    @Data
    public static class FiltersDoctorDTO {
        private Long id;

        private String specialty;

        private Long person;

    }

    @Data
    public static class FiltersDoctorSpecDTO {
        private Long id;

        private String specialty;

        private Person person;

    }

    @Data
    public static class FiltersDoctorPersonDTO {

        private String specialty;

        private String dni;

        private String name;

        private String surname;

    }

    @Data
    public static class CreateDoctorAndPersonDTO {
        private CreatePersonDTO person;
        @NotBlank
        private String specialty;
    }

}
