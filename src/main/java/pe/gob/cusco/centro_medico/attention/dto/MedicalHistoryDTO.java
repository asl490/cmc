package pe.gob.cusco.centro_medico.attention.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.gob.cusco.centro_medico.maintenance.util.AntecedentDTO;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MedicalHistoryDTO {
    private Long id;

    private Long patient;

    private AntecedentDTO antecedent;

    private Boolean valueBoolean;

    private String valueString;

    private LocalDate valueDate;

    private Integer valueNumber;

    private String observation;

    @Data
    public static class CreateMedicalHistoryDTO {

        private Long patient;

        private Long antecedent;

        private Boolean valueBoolean;

        private String valueString;

        private LocalDate valueDate;

        private Integer valueNumber;

        private String observation;

    }

    @Data
    public static class UpdateMedicalHistoryDTO {

        private Long patient;

        private Long antecedent;

        private Boolean valueBoolean;

        private String valueString;

        private LocalDate valueDate;

        private Integer valueNumber;

        private String observation;

    }

    @Data
    public static class FiltersMedicalHistoryDTO {

        private Long patient;

        private Long antecedent;

        private Boolean valueBoolean;

        private String valueString;

        private LocalDate valueDate;

        private Integer valueNumber;

        private String observation;

    }
}