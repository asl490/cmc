package pe.gob.cusco.centro_medico.maintenance.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ParameterDTO {
    private Long id;

    private LaboratoryDTO laboratory;

    private String name;

    private Double maxValue;

    private Double minValue;

    private String unit;

    private String isQualitative;

    @Data
    public static class CreateParameterDTO {

        private Long laboratory;

        private String name;

        private Double maxValue;

        private Double minValue;

        private String unit;

        private String isQualitative;

    }

    @Data
    public static class UpdateParameterDTO {

        private Long laboratory;

        private String name;

        private Double maxValue;

        private Double minValue;

        private String unit;

        private String isQualitative;

    }

    @Data
    public static class FiltersParameterDTO {

        private Long laboratory;

        private String name;

        private Double maxValue;

        private Double minValue;

        private String unit;

        private String isQualitative;

    }
}