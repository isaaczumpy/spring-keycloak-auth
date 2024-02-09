package org.eoisaac.springkeycloakauth.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.HashMap;
import java.util.Map;


@Slf4j
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiRestController {

    public Map<String, Object> getResponse(Jwt jwt) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", String.format("Hello, %s!", jwt.getClaimAsString("preferred_username")));
        response.put("jwt", jwt);
        return response;
    }

    @GetMapping("/")
    public Map<String, Object> index(@AuthenticationPrincipal Jwt jwt) {
        return getResponse(jwt);
    }

    @GetMapping("/protected/premium")
    public Map<String, Object> premium(@AuthenticationPrincipal Jwt jwt) {
        return getResponse(jwt);
    }

}
