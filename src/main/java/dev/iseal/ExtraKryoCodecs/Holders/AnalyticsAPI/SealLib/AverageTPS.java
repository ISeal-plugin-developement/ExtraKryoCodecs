package dev.iseal.ExtraKryoCodecs.Holders.AnalyticsAPI.SealLib;

public record AverageTPS(int TPS) {

    public AverageTPS {
        if (TPS < 0 || TPS > 20) {
            throw new IllegalArgumentException("TPS must be between 0 and 20");
        }
    }

}
