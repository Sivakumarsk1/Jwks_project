package com.Jwks_projects1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class PublicController {


    @GetMapping("/public")
    public String publicEndpoint() {
        return "This is a public endpoint";
    }
}
