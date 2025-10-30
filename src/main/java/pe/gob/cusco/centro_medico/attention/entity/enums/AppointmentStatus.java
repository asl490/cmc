package pe.gob.cusco.centro_medico.attention.entity.enums;

public enum AppointmentStatus {

    PENDING("Pendiente"),
    NURSE_REVIEW("Enfermería"),

    IN_CONSULTATION("En consulta"),
    // TO_LAB("Laboratorio"),

    COMPLETED("Completada"),

    NO_SHOW("Ausente sin aviso"),
    RESCHEDULED("Reprogramada"),
    EXPIRED("Expirada");

    private final String description;

    AppointmentStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
