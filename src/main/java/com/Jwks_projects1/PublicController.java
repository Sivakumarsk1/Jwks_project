package com.Jwks_projects1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class PublicController {

    @GetMapping("/public")
    public Map<String, String> publicMessage() {
        return Map.of("message", "This is a public message!");
    }
}
