package pe.gob.cusco.centro_medico.attention.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.gob.cusco.centro_medico.maintenance.dto.LaboratoryDTO;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LaboratoryOrderDTO {
    private Long id;

    private LaboratoryDTO laboratory;

    private AppointmentDTO appointment;

    private String status;

    @Data
    public static class CreateLaboratoryOrderDTO {

        private Long laboratory;

        private Long appointment;

        private String status;

    }

    @Data
    public static class LaboratoryOrderMinDTO {

        private LaboratoryDTO laboratory;

        private Long appointment;

        private String status;

    }

    @Data
    public static class UpdateLaboratoryOrderDTO {

        private Long laboratory;

        private Long appointment;

        private String status;

    }

    @Data
    public static class FiltersLaboratoryOrderDTO {

        private String status;

    }
}