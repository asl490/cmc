package pe.gob.cusco.centro_medico.maintenance.util;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ConceptDTO {
    private Long id;

    private String code;

    private String name;

    private String type;

    private BigDecimal price;

    @Data
    public static class CreateConceptDTO {

        @NotBlank

        private String code;

        @NotBlank

        private String name;

        @NotBlank

        private String type;

        @NotNull

        @DecimalMin("0.0")

        private BigDecimal price;

    }

    @Data
    public static class UpdateConceptDTO {

        private String code;

        private String name;

        private String type;

        private BigDecimal price;

    }

    @Data
    public static class FiltersConceptDTO {
        private Long id;

        private String code;

        private String name;

        private String type;

        private BigDecimal price;

    }
}