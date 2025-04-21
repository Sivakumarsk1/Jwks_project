package com.Jwks_projects1;

import org.apache.catalina.SessionIdGenerator;
import java.util.UUID;

public class CustomSessionIdGenerator implements SessionIdGenerator {

    @Override
    public String generateSessionId() {
        // Using UUID for session ID generation (UUID.randomUUID())
        return UUID.randomUUID().toString().replace("-", ""); // Removing the dashes for a cleaner ID
    }

    @Override
    public String getJvmRoute() {
        return null;  // Optional: default value
    }

    @Override
    public void setJvmRoute(String jvmRoute) {
        // Optional: no need for implementation
    }

    @Override
    public int getSessionIdLength() {
        return 32;  // Length of the UUID string after removing dashes
    }

    @Override
    public void setSessionIdLength(int sessionIdLength) {
        // Optional: no need for implementation
    }

    @Override
    public String generateSessionId(String route) {
        return null;  // Optional: no need for implementation
    }
}
