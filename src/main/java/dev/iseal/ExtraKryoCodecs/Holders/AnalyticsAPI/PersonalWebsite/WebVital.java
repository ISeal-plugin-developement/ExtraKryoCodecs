package dev.iseal.ExtraKryoCodecs.Holders.AnalyticsAPI.PersonalWebsite;

import java.util.List;

public record WebVital(
    String name,
    double value,
    String rating,
    double delta,
    List<Entry> entries,
    String id,
    String navigationType
) {
    public record Entry(
        String name,
        String entryType,
        double startTime,
        double duration,
        // Fields specific to different vital types
        Double paintTime,
        Double presentationTime,
        Double renderTime,
        Double loadTime,
        Double size,
        String url,
        // TTFB specific fields
        String initiatorType,
        String nextHopProtocol,
        Double workerStart,
        Double redirectStart,
        Double redirectEnd,
        Double fetchStart,
        Double domainLookupStart,
        Double domainLookupEnd,
        Double connectStart,
        Double connectEnd,
        Double secureConnectionStart,
        Double requestStart,
        Double responseStart,
        Double responseEnd,
        Double transferSize,
        Double encodedBodySize,
        Double decodedBodySize,
        Double responseStatus,
        String contentType,
        List<Object> serverTiming,
        Double unloadEventStart,
        Double unloadEventEnd,
        Double domInteractive,
        Double domContentLoadedEventStart,
        Double domContentLoadedEventEnd,
        Double domComplete,
        Double loadEventStart,
        Double loadEventEnd,
        String type,
        Double redirectCount
    ) {}
}