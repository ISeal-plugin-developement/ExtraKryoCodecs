package dev.iseal.ExtraKryoCodecs.Holders.AnalyticsAPI.Authorisation;

public record LoginRequest(String username, String password) {
    public LoginRequest {
        if (username == null || username.isBlank()) {
            throw new IllegalArgumentException("Username cannot be null or blank");
        }
        if (password == null || password.isBlank()) {
            throw new IllegalArgumentException("Password cannot be null or blank");
        }
    }
}
