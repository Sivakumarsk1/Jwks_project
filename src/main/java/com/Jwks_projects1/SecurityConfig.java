package com.Jwks_projects1;
import com.auth0.jwk.JwkProvider;
import com.auth0.jwk.JwkProviderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import java.util.concurrent.TimeUnit;

    @Configuration
	@EnableWebSecurity
	public class SecurityConfig {
	    @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        http
	            .authorizeHttpRequests(authz -> authz
	                .requestMatchers("/public").permitAll()
	                .anyRequest().authenticated()
	            )
	            .oauth2ResourceServer(oauth2 -> oauth2
	                .jwt()
	            );
	        return http.build();
	    }
	

    @Bean
    public JwkProvider jwkProvider() {
        return new JwkProviderBuilder("https://sivakumar.in.authaction.com")
                .cached(10, 24, TimeUnit.HOURS)
                .rateLimited(10, 1, TimeUnit.MINUTES)
                .build();
    }
}


