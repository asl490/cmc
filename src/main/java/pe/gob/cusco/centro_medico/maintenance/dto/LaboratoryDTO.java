package pe.gob.cusco.centro_medico.maintenance.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.gob.cusco.centro_medico.maintenance.dto.ParameterDTO.ParameterPlainDTO;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LaboratoryDTO {
    private Long id;

    private String name;

    private String type;

    @Data
    public static class CreateLaboratoryDTO {

        private String name;

        private String type;

    }

    @Data
    public static class UpdateLaboratoryDTO {

        private String name;

        private String type;

    }

    @Data
    public static class FiltersLaboratoryDTO {

        private String name;

        private String type;

    }

    @Data
    @Builder
    public static class LaboratoryParameterDTO {

        private Long id;

        private String name;

        private String type;

        private Long laboratoryOrder;

        private List<ParameterPlainDTO> parameter;

    }

}