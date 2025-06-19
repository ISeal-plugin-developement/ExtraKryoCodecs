package dev.iseal.ExtraKryoCodecs.Holders.AnalyticsAPI.SealLib;

import java.util.Date;
import java.util.logging.Level;

public record ErrorReport(String reporter, String reporterVersion, String errorMessage, String[] stackTrace,
                          Date timestamp, Level level) {

}
