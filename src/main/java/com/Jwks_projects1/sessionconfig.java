package com.Jwks_projects1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.catalina.SessionIdGenerator;

@Configuration
public class sessionconfig {

    @Bean
    public SessionIdGenerator sessionIdGenerator() {
        return new CustomSessionIdGenerator();  // Your custom generator bean
    }
}
