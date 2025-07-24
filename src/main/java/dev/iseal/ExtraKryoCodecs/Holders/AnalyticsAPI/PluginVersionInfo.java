package dev.iseal.ExtraKryoCodecs.Holders.AnalyticsAPI;

public record PluginVersionInfo(String pluginVersion, String serverVersion,
                                String serverSoftware, String serverJavaVersion,
                                String serverOS, String serverOSVersion,
                                String serverArchitecture) {

}
