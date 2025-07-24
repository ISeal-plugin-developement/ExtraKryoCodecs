package dev.iseal.ExtraKryoCodecs.Holders.AnalyticsAPI.PowerGems;

import dev.iseal.ExtraKryoCodecs.Utils.Pair;

import java.util.HashMap;
import java.util.List;

public record PGGemUsagesHourly(
        HashMap<String, List<Pair<String, Integer>>> gemUsagesByHour
) {
}
