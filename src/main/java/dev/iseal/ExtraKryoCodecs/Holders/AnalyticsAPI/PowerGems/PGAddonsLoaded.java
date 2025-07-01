package dev.iseal.ExtraKryoCodecs.Holders.AnalyticsAPI.PowerGems;

public record PGAddonsLoaded(String[] addons) {
    public PGAddonsLoaded {
        if (addons == null) {
            throw new IllegalArgumentException("Addons cannot be null");
        }
        for (String addon : addons) {
            if (addon == null || addon.isBlank()) {
                throw new IllegalArgumentException("Addon names cannot be null or blank");
            }
        }
    }
}
