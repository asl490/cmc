package pe.gob.cusco.centro_medico.attention.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.gob.cusco.centro_medico.maintenance.dto.LaboratoryDTO.LaboratoryParameterDTO;
import pe.gob.cusco.centro_medico.maintenance.dto.ParameterDTO;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LaboratoryResultDTO {
    private Long id;

    private LaboratoryOrderDTO laboratoryOrder;

    private ParameterDTO parameter;

    private Long numericalValue;

    private String textValue;

    private String observation;

    @Data
    public static class CreateLaboratoryResultDTO {

        private Long laboratoryOrder;

        private Long parameter;

        private Long numericalValue;

        private String textValue;

        private String observation;

    }

    @Data
    public static class LaboratoryResultMinDTO {

        private Long laboratoryOrder;

        private ParameterDTO parameter;

        private Long numericalValue;

        private String textValue;

        private String observation;

    }

    @Data
    public static class UpdateLaboratoryResultDTO {

        private Long laboratoryOrder;

        private Long parameter;

        private Long numericalValue;

        private String textValue;

        private String observation;

    }

    @Data
    public static class FiltersLaboratoryResultDTO {

        private Long laboratoryOrder;

        private Long parameter;

        private Long numericalValue;

        private String textValue;

        private String observation;

    }

    @Data
    @Builder
    public static class LaboratoryResultFieldsDTO {

        private Long appointment;
        // private Long labortoryOrder;

        private List<LaboratoryParameterDTO> laboratory;

    }

}