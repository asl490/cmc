package pe.gob.cusco.centro_medico.maintenance.entity.enums;

public enum TypeData {
    TEXT("Texto"),
    NUMBER("Número"),
    DATE("Fecha"),
    BOOLEAN("Booleano");

    private final String description;

    TypeData(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
