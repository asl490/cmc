package pe.gob.cusco.centro_medico.auth.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtDecoders;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pe.gob.cusco.centro_medico.auth.dto.LoginRequest;
import pe.gob.cusco.centro_medico.auth.dto.TokenResponse;
import pe.gob.cusco.centro_medico.exception.exception.UnauthorizedException;
import pe.gob.cusco.centro_medico.maintenance.entity.Person;
import pe.gob.cusco.centro_medico.maintenance.service.PersonService;
import pe.gob.cusco.centro_medico.maintenance.util.PersonDTO.CreatePersonDTO;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthService {
    @Value("${spring.security.oauth2.client.provider.keycloak.token-uri}")
    private String TOKEN_URL;

    @Value("${spring.security.oauth2.client.provider.keycloak.issuer-uri}")
    private String ISSUER_URI;

    @Value("${spring.security.oauth2.client.registration.keycloak.client-id}")
    private String CLIENT_ID;
    @Value("${spring.security.oauth2.client.registration.keycloak.client-secret}")
    private String CLIENT_SECRET;

    private final RestTemplate restTemplate;
    private final PersonService personService;

    public TokenResponse authenticateUser(LoginRequest loginRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("grant_type", "password");
        map.add("client_id", CLIENT_ID);
        map.add("client_secret", CLIENT_SECRET);
        map.add("username", loginRequest.getUsername());
        map.add("password", loginRequest.getPassword());
        map.add("scope", "openid");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
        try {
            ResponseEntity<TokenResponse> response = restTemplate.postForEntity(
                    TOKEN_URL, request, TokenResponse.class);

            if (response.getBody() != null && response.getBody().getAccessToken() != null) {
                syncUserFromToken(response.getBody().getAccessToken());
            } else {
                log.warn("No access token received from authentication response.");
            }
            return response.getBody();
        } catch (HttpClientErrorException e) {
            String responseBody = e.getResponseBodyAsString();
            log.error("Error al autenticar usuario: {} - Body: {}", e.getMessage(), responseBody);
            if (e.getStatusCode().value() == 401) {
                throw new UnauthorizedException("Credenciales inválidas");
            } else if (e.getStatusCode().value() == 400) {
                throw new UnauthorizedException("Solicitud inválida: " + responseBody);
            } else {
                throw new UnauthorizedException("Error de autenticación: " + responseBody);
            }
        } catch (ResourceAccessException e) {
            log.error("No se pudo conectar al servidor de identidad: {}", e.getMessage());
            throw new UnauthorizedException("No se pudo conectar al servidor de identidad. Intente más tarde.");

        } catch (Exception e) {
            log.error("Error inesperado al autenticar usuario", e);
            throw new UnauthorizedException("Error inesperado al autenticar usuario");
        }
    }

    private void syncUserFromToken(String accessToken) {
        JwtDecoder jwtDecoder = JwtDecoders.fromIssuerLocation(ISSUER_URI);
        Jwt jwt = jwtDecoder.decode(accessToken);

        final String dni = jwt.getClaimAsString("preferred_username");
        final String dependencia = jwt.getClaimAsString("dependencia");
        final String givenName = jwt.getClaimAsString("given_name");
        final String familyName = jwt.getClaimAsString("family_name");
        final String email = jwt.getClaimAsString("email");

        Optional<Person> personEntity = personService.findOptionalByDNI(dni);

        if (personEntity.isEmpty()) {
            CreatePersonDTO person = CreatePersonDTO.builder()
                    .dni(dni)
                    .name(givenName)
                    .surname(familyName)
                    .email(email)
                    .build();
            personService.create(person);

            log.info("Usuario y relación persona-oficina creados: {} - {}", dni, dependencia);
        } else {
            log.info("Usuario ya existe: {}", personEntity.get().getDni());
        }
    }

    public TokenResponse refreshToken(String refreshToken) {
        String tokenUrl = TOKEN_URL;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("grant_type", "refresh_token");
        map.add("client_id", CLIENT_ID);
        map.add("client_secret", CLIENT_SECRET);
        map.add("refresh_token", refreshToken);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map,
                headers);

        try {
            ResponseEntity<TokenResponse> response = restTemplate.postForEntity(
                    tokenUrl, request, TokenResponse.class);
            return response.getBody();
        } catch (ResourceAccessException e) {
            log.error("Error al refrescar token: {}", e.getMessage());
            throw new UnauthorizedException("Refresh token inválido");
        } catch (HttpClientErrorException e) {
            log.error("Error al refrescar token: {}", e.getMessage());
            throw new UnauthorizedException("Refresh token inválido");
        }
    }

    public void logout(String refreshToken) {
        String logoutUrl = ISSUER_URI +
                "/protocol/openid_connect/logout";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("client_id", CLIENT_ID);
        map.add("client_secret", CLIENT_SECRET);
        map.add("refresh_token", refreshToken);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map,
                headers);

        try {
            restTemplate.postForEntity(logoutUrl, request, String.class);
        } catch (ResourceAccessException e) {
            log.error("No se pudo conectar al servidor de identidad: {}", e.getMessage());
            throw new UnauthorizedException("No se pudo conectar al servidor de identidad. Intente más tarde.");
        } catch (Exception e) {
            log.warn("Error al hacer logout: {}", e.getMessage());
        }
    }
}