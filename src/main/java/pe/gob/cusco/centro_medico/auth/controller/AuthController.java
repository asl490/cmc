package pe.gob.cusco.centro_medico.auth.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import pe.gob.cusco.centro_medico.auth.dto.LoginRequest;
import pe.gob.cusco.centro_medico.auth.dto.RefreshRequest;
import pe.gob.cusco.centro_medico.auth.dto.TokenResponse;
import pe.gob.cusco.centro_medico.auth.dto.UserInfoDTO;
import pe.gob.cusco.centro_medico.auth.service.AuthService;

@RestController
@RequestMapping(value = "/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@RequestBody LoginRequest loginRequest) {
        TokenResponse tokenResponse = authService.authenticateUser(loginRequest);
        return ResponseEntity.ok(tokenResponse);
    }

    @PostMapping("/refresh")
    public ResponseEntity<TokenResponse> refresh(@RequestBody RefreshRequest request) {

        TokenResponse tokenResponse = authService.refreshToken(request.getRefreshToken());
        return ResponseEntity.ok(tokenResponse);
    }

    @PostMapping("/logout")
    public ResponseEntity<Map<String, String>> logout(@RequestBody RefreshRequest request) {

        authService.logout(request.getRefreshToken());

        Map<String, String> response = new HashMap<>();
        response.put("message", "Logout successful");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/user-info")
    // @PreAuthorize("hasAnyRole('SLOGIS_SUPERVISOR','SLOGIS_REGISTRADOR','SLOGIS_ADMIN','SLOGIS_OPERADOR')")
    public ResponseEntity<UserInfoDTO> getUserInfo(JwtAuthenticationToken token) {
        Jwt jwt = token.getToken();

        UserInfoDTO userInfoDTO = UserInfoDTO.builder()
                .username(jwt.getClaimAsString("preferred_username"))
                .name(jwt.getClaimAsString("name"))
                .email(jwt.getClaimAsString("email"))
                .cargo(jwt.getClaimAsString("cargo"))
                .dependencia(jwt.getClaimAsString("dependencia"))
                .entidad(jwt.getClaimAsString("entidad"))
                .roles(token.getAuthorities().stream()
                        .map(authority -> (String) authority.getAuthority().replace("ROLE_", ""))
                        .toList())
                .build();

        return ResponseEntity.ok(userInfoDTO);
    }
}
