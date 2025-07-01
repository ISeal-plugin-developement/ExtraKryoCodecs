package dev.iseal.ExtraKryoCodecs.Holders.AnalyticsAPI;

public record ProgramVersionInfo(String programVersion, String javaVersion,
                                 String osName, String osVersion,
                                 String osArch) {
    public ProgramVersionInfo {
        if (programVersion == null || programVersion.isBlank()) {
            throw new IllegalArgumentException("Program version cannot be null or blank");
        }
        if (javaVersion == null || javaVersion.isBlank()) {
            throw new IllegalArgumentException("Java version cannot be null or blank");
        }
        if (osName == null || osName.isBlank()) {
            throw new IllegalArgumentException("OS name cannot be null or blank");
        }
        if (osVersion == null || osVersion.isBlank()) {
            throw new IllegalArgumentException("OS version cannot be null or blank");
        }
        if (osArch == null || osArch.isBlank()) {
            throw new IllegalArgumentException("OS architecture cannot be null or blank");
        }
    }
}
