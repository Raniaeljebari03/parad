package com.project2.security;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Provider
public class BasicAuthFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        // Allow CORS preflight requests
        if ("OPTIONS".equalsIgnoreCase(requestContext.getMethod())) {
            return;
        }

        String authHeader = requestContext.getHeaderString("Authorization");

        if (authHeader == null || !authHeader.startsWith("Basic ")) {
            abort(requestContext);
            return;
        }

        try {
            String base64Credentials = authHeader.substring("Basic ".length()).trim();
            byte[] decodedBytes = Base64.getDecoder().decode(base64Credentials);
            String credentials = new String(decodedBytes, StandardCharsets.UTF_8);

            String[] values = credentials.split(":", 2);
            if (values.length != 2) {
                abort(requestContext);
                return;
            }

            String username = values[0];
            String password = values[1];

            String expectedUsername = "rania";
            String expectedPassword = "project2";

            if (!expectedUsername.equals(username) || !expectedPassword.equals(password)) {
                abort(requestContext);
            }
        } catch (IllegalArgumentException e) {
            abort(requestContext);
        }
    }

    private void abort(ContainerRequestContext requestContext) {
        requestContext.abortWith(
            Response.status(Response.Status.UNAUTHORIZED)
                .entity("Unauthorized")
                .build()
        );
    }
}