package pe.gob.cusco.centro_medico.maintenance.entity.enums;

public enum TypeAntecedent {

    PERSONAL("Personal"),
    FAMILIAR("Familiar"),
    MEDICAL("Médico"),
    SEXUALITY("Sexualidad"),
    WOMAN("Mujer"),
    ALERGIES("Alergias");

    private final String description;

    TypeAntecedent(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
