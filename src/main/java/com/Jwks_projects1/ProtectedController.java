package com.Jwks_projects1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class ProtectedController {

	  @GetMapping("/protected")
	    public Map<String, String> protectedEndpoint() {
	        return Map.of("message", "This is a protected message!");
	    }
}
