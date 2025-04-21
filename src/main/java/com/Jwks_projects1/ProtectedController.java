package com.Jwks_projects1;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class ProtectedController {

    @GetMapping("/protected")
    public Map<String, String> protectedMessage(@AuthenticationPrincipal Jwt jwt) {
        String sub = jwt.getSubject(); // 'sub' claim
        String email = jwt.getClaimAsString("email"); // 'email' claim
        return Map.of(
            "message", "This is a protected message!",
            "sub", sub,
            "email", email != null ? email : "not available"
        );
    }
}
