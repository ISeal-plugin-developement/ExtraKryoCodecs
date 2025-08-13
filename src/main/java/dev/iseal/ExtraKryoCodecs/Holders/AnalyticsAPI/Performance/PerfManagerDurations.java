package dev.iseal.ExtraKryoCodecs.Holders.AnalyticsAPI.Performance;

import java.util.Map;

public record PerfManagerDurations(
        Map<String, Double> durations
) {
    public PerfManagerDurations {
        if (durations == null) {
            throw new IllegalArgumentException("Durations map cannot be null");
        }
    }

    @Override
    public String toString() {
        return "PerfManagerDurations{" +
                "durations=" + durations +
                '}';
    }
}
