package pe.gob.cusco.centro_medico.maintenance.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.gob.cusco.centro_medico.maintenance.entity.enums.TypeAntecedent;
import pe.gob.cusco.centro_medico.maintenance.entity.enums.TypeData;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AntecedentDTO {
    private Long id;

    private String name;

    private String description;

    private String typeAntecedent;

    private String typeData;

    @Data
    public static class CreateAntecedentDTO {

        private String name;

        private String description;

        private TypeAntecedent typeAntecedent;

        private TypeData typeData;

    }

    @Data
    public static class UpdateAntecedentDTO {

        private String name;

        private String description;

        private TypeAntecedent typeAntecedent;

        private TypeData typeData;

    }

    @Data
    public static class FiltersAntecedentDTO {

        private String name;

        private String description;

        private TypeAntecedent typeAntecedent;

        private TypeData typeData;

    }
}