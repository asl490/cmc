package pe.gob.cusco.centro_medico.attention.util;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.gob.cusco.centro_medico.attention.entity.Appointment;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NursingRecordDTO {
    private Long id;

    private Long appointment;

    private String vitalSign;

    private Double numericalValue;

    private String textValue;

    private String observations;

    @Data
    @Builder
    public static class CreateNursingRecordDTO {

        private Long appointment;

        private Long vitalSign;

        private Double numericalValue;

        private String textValue;

        private String observations;

    }

    @Data
    public static class UpdateNursingRecordDTO {

        private Long appointment;

        private Long vitalSign;

        private Double numericalValue;

        private String textValue;

        private String observations;

    }

    @Data
    public static class FiltersNursingRecordDTO {

        private Long appointment;

    }

    @Data
    public static class FiltersNursingRecordSpecDTO {

        private Appointment appointment;

    }

    @Data
    public static class CreateFullNursingRecordDTO {

        private Long appointment;

        List<NursingRecordCreateDTO> nursingRecords;

    }

    @Data
    public static class NursingRecordCreateDTO {

        private Long vitalSign;

        private Double numericalValue;

        private String textValue;

        private String observations;

    }
}