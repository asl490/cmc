package pe.gob.cusco.centro_medico.config;

import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.oauth2.jwt.Jwt;

@Configuration
@EnableJpaAuditing
public class AuditorAwareConfig {

    @Bean
    public AuditorAware<String> auditorAware() {
        return () -> {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

            if (authentication == null || !authentication.isAuthenticated()) {
                return Optional.empty();
            }

            Object principal = authentication.getPrincipal();

            String username = null;
            if (principal instanceof UserDetails) {
                username = ((UserDetails) principal).getUsername();
            } else if (principal instanceof Jwt) {

                username = ((Jwt) principal)
                        .getClaimAsString("preferred_username");
                if (username == null) {
                    username = ((Jwt) principal).getSubject();
                }
            } else if (principal instanceof DefaultOidcUser) {
                username = ((DefaultOidcUser) principal).getName();
            } else {
                username = principal.toString();
            }

            return (username != null && !username.isBlank()) ? Optional.of(username) : Optional.empty();
        };
    }
}
