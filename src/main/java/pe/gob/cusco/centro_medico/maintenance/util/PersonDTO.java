package pe.gob.cusco.centro_medico.maintenance.util;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {
    private Long id;

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
    private String gender;

    @Data
    @Builder
    public static class CreatePersonDTO {

        @NotBlank

        private String name;

        @NotBlank

        private String surname;

        @Email

        private String email;

        @NotBlank

        private String phone;

        @NotBlank

        private String dni;

        @NotBlank

        private String civilStatus;

        @NotBlank

        private String address;

        private LocalDate birthDate;

        private Integer age;

        private String birthLocation;
        private String gender;
    }

    @Data
    public static class UpdatePersonDTO {

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
        private String gender;
    }

    @Data
    public static class FiltersPersonDTO {
        private Long id;

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
        private String gender;
    }
}