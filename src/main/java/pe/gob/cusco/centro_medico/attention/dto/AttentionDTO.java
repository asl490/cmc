package pe.gob.cusco.centro_medico.attention.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AttentionDTO {
    private Long id;

    private AppointmentDTO appointment;

    private String reason;

    private String phisicalExam;

    private String diagnosis;

    private String treatment;

    private String referral;

    private String observation;

    @Data
    public static class CreateAttentionDTO {

        private Long appointment;

        private String reason;

        private String phisicalExam;

        private String diagnosis;

        private String treatment;

        private String referral;

        private String observation;

    }

    @Data
    public static class UpdateAttentionDTO {

        private Long appointment;

        private String reason;

        private String phisicalExam;

        private String diagnosis;

        private String treatment;

        private String referral;

        private String observation;

    }

    @Data
    public static class FiltersAttentionDTO {

        private Long appointment;

        private String reason;

        private String phisicalExam;

        private String diagnosis;

        private String treatment;

        private String referral;

        private String observation;

    }
}