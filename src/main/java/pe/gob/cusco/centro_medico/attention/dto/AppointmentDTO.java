package pe.gob.cusco.centro_medico.attention.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.gob.cusco.centro_medico.maintenance.util.ConceptDTO;
import pe.gob.cusco.centro_medico.maintenance.util.DoctorDTO;
import pe.gob.cusco.centro_medico.maintenance.util.PatientDTO;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDTO {
    private Long id;

    private PatientDTO patient;

    private DoctorDTO doctor;

    private ConceptDTO concept;

    private String status;

    private String reason;

    private LocalDate appointmentDate;

    @Data
    public static class CreateAppointmentDTO {

        @NotNull

        private Long patient;

        @NotNull

        private Long doctor;

        @NotNull

        private Long concept;

        private String status;

        private String reason;

        private LocalDate appointmentDate;

    }

    @Data
    public static class UpdateAppointmentDTO {

        private Long patient;

        private Long doctor;

        private Long concept;

        private String status;

        private String reason;

        private LocalDate appointmentDate;

    }

    @Data
    public static class FiltersAppointmentDTO {

        private Long patient;

        private Long doctor;

        private Long concept;

        private String status;

        private String reason;

        private LocalDate appointmentDate;

    }

    @Data
    public static class FiltersAppointmentSpecDTO {

        private PatientDTO patient;

        private DoctorDTO doctor;

        private ConceptDTO concept;

        private String status;

        private String reason;

        private LocalDate appointmentDate;

    }

    @Data
    public static class FiltersAppointmentAppointmentDTO {
        private String dni;

        private String dniDoctor;

        private String clinicHistory;

        private String status;

        private LocalDate appointmentDate;

    }
}