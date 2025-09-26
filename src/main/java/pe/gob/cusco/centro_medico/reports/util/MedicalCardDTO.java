package pe.gob.cusco.centro_medico.reports.util;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.gob.cusco.centro_medico.maintenance.entity.Patient;
import pe.gob.cusco.centro_medico.maintenance.util.PatientDTO;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MedicalCardDTO {
    private Long id;

    private String result;

    private String bloodType;

    private String rpr;

    private String parasitology;

    private LocalDate emisionDate;

    private LocalDate caducityDate;

    private PatientDTO patient;

    @Data
    public static class CreateMedicalCardDTO {

        @NotBlank

        private String result;

        @NotBlank

        private String bloodType;

        private String rpr;

        private String parasitology;

        private LocalDate emisionDate;

        private LocalDate caducityDate;

        @NotNull

        private Long patient;

    }

    @Data
    public static class UpdateMedicalCardDTO {

        private String result;

        private String bloodType;

        private String rpr;

        private String parasitology;

        private LocalDate emisionDate;

        private LocalDate caducityDate;

        private Long patient;

    }

    @Data
    public static class FiltersMedicalCardDTO {

        private String result;

        private String bloodType;

        private String rpr;

        private String parasitology;

        private LocalDate emisionDate;

        private LocalDate caducityDate;

        private Long patient;

    }

    @Data
    public static class FiltersMedicalCardSpecDTO {

        private String result;

        private String bloodType;

        private String rpr;

        private String parasitology;

        private LocalDate emisionDate;

        private LocalDate caducityDate;

        private Patient patient;

    }
}