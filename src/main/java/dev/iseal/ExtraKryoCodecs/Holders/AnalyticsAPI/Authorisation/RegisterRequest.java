package dev.iseal.ExtraKryoCodecs.Holders.AnalyticsAPI.Authorisation;

public record RegisterRequest(String username, String password, String email, String[] requestedScopes) {
    public RegisterRequest {
        if (username == null || username.isBlank()) {
            throw new IllegalArgumentException("Username cannot be null or blank");
        }
        if (password == null || password.isBlank()) {
            throw new IllegalArgumentException("Password cannot be null or blank");
        }
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email cannot be null or blank");
        }
        if (requestedScopes == null || requestedScopes.length == 0) {
            throw new IllegalArgumentException("Requested scopes cannot be null or empty");
        }
    }
}
