package com.Jwks_projects1;
import com.auth0.jwk.JwkProvider;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtException;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;

import java.security.interfaces.RSAPublicKey;
import java.util.Date;

@Configuration
public class Jwtvalidation {

    @Value("${auth0.audience}")
    private String audience;

    @Value("${auth0.issuer}")
    private String issuer;

    @Bean
    public JwtDecoder jwtDecoder(JwkProvider jwkProvider) {
        return token -> {
            try {
                DecodedJWT jwt = JWT.decode(token);
                Algorithm algorithm = Algorithm.RSA256((RSAPublicKey) jwkProvider.get(jwt.getKeyId()).getPublicKey(), null);
                algorithm.verify(jwt);
                
                // Validate claims
                if (!jwt.getAudience().contains(audience)) {
                    throw new JwtException("Invalid audience");
                }
                if (!jwt.getIssuer().equals(issuer)) {
                    throw new JwtException("Invalid issuer");
                }
                if (jwt.getExpiresAt().before(new Date())) {
                    throw new JwtException("Token expired");
                }
                
                return NimbusJwtDecoder.withPublicKey((RSAPublicKey) jwkProvider.get(jwt.getKeyId()).getPublicKey()).build().decode(token);
            } catch (Exception e) {
                throw new JwtException("Invalid token", e);
            }
        };
    }
}