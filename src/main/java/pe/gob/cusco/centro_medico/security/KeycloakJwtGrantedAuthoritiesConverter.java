package pe.gob.cusco.centro_medico.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

public class KeycloakJwtGrantedAuthoritiesConverter implements Converter<Jwt, Collection<GrantedAuthority>> {

    @Value("${spring.security.oauth2.client.registration.keycloak.client-id}")
    private String clientId;

    @Override
    public Collection<GrantedAuthority> convert(Jwt jwt) {
        Collection<GrantedAuthority> authorities = new ArrayList<>();

        // Extraer roles específicos de resource_access
        Map<String, Object> resourceAccess = jwt.getClaimAsMap("resource_access");
        if (resourceAccess != null) {
            // Roles de app-logistica
            Object appLogisObj = resourceAccess.get(clientId);
            if (appLogisObj instanceof Map) {
                Map<?, ?> appLogisMap = (Map<?, ?>) appLogisObj;
                Object rolesObj = appLogisMap.get("roles");
                if (rolesObj instanceof List) {
                    List<?> rolesList = (List<?>) rolesObj;
                    for (Object roleObj : rolesList) {
                        if (roleObj instanceof String) {
                            String role = (String) roleObj;
                            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.toUpperCase().replace("-", "_")));
                        }
                    }
                }
            }
        }

        return authorities;
    }
}