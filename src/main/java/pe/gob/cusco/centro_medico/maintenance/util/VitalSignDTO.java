package pe.gob.cusco.centro_medico.maintenance.util;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VitalSignDTO {
    private Long id;

    private String name;

    private String unit;

    @Data
    public static class CreateVitalSignDTO {

        @NotBlank

        private String name;

        @NotBlank

        private String unit;

    }

    @Data
    public static class UpdateVitalSignDTO {

        private String name;

        private String unit;

    }

    @Data
    public static class FiltersVitalSignDTO {

        private String name;

        private String unit;

    }
}