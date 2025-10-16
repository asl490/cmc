package pe.gob.cusco.centro_medico.maintenance.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;








@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AntecedentDTO {
    private Long id;

    private String name;

    private String description;

    private String type;


    @Data
    public static class CreateAntecedentDTO {
        
        
            private String name;
        
        
            private String description;
        
        
            private String type;
        
    }

    @Data
    public static class UpdateAntecedentDTO {
        
        private String name;
    
        private String description;
    
        private String type;
    
    }

    @Data
    public static class FiltersAntecedentDTO {

    
        private String name;
    
        private String description;
    
        private String type;
    
    }
}