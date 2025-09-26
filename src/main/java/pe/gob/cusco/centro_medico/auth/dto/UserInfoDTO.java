package pe.gob.cusco.centro_medico.auth.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserInfoDTO {
    private String username;
    private String name;
    private String email;
    private String cargo;
    private String dependencia;
    private String entidad;
    private List<String> roles;

}
