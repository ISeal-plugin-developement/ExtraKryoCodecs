package dev.iseal.ExtraKryoCodecs.Holders.AnalyticsAPI.PowerGems;

import java.util.Map;

public record PGAddonsLoaded(Map<String, String> addons) {
    public PGAddonsLoaded {
        if (addons == null) {
            throw new IllegalArgumentException("Addons cannot be null");
        }
        for (Map.Entry<String, String> addon : addons.entrySet()) {
            if (addon == null || addon.getKey().isBlank() || addon.getValue() == null || addon.getValue().isBlank()) {
                throw new IllegalArgumentException("Addon names cannot be null or blank");
            }
        }
    }
}
