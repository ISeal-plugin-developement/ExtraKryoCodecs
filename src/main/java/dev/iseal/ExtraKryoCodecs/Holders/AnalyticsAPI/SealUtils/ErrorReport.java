package dev.iseal.ExtraKryoCodecs.Holders.AnalyticsAPI.SealUtils;

import java.time.Instant;
import java.util.Date;
import java.util.logging.Level;

public record ErrorReport(String reporterVersion, String errorMessage,
                          String responsibleClass, Instant timestamp, Level level) {

}
