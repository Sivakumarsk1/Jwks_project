package com.Jwks_projects1;


import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

import java.security.SecureRandom;

@Component
public class SecureRandomInitializer {

    @PostConstruct
    public void init() {
        // Pre-initialize SecureRandom
        new SecureRandom();
    }
}