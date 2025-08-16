package dev.iseal.ExtraKryoCodecs.Codecs.AnalyticsAPI.SealUtils;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import dev.iseal.ExtraKryoCodecs.Holders.AnalyticsAPI.SealUtils.ErrorReport;

import java.time.Instant;
import java.time.InstantSource;
import java.util.Date;
import java.util.logging.Level;

public class ErrorReportSerializer extends Serializer<ErrorReport> {
    @Override
    public void write(Kryo kryo, Output output, ErrorReport object) {
        output.writeString(object.reporterVersion());
        output.writeString(object.errorMessage());
        output.writeString(object.responsibleClass());
        output.writeLong(object.timestamp().toEpochMilli());
        output.writeString(object.level().getName());
    }

    @Override
    public ErrorReport read(Kryo kryo, Input input, Class<? extends ErrorReport> type) {
        String reporterVersion = input.readString();
        String errorMessage = input.readString();
        String responsibleClass = input.readString();
        long timestampMillis = input.readLong();
        Instant timestamp = Instant.ofEpochMilli(timestampMillis);
        String levelName = input.readString();
        Level level = Level.parse(levelName);

        return new ErrorReport(reporterVersion, errorMessage, responsibleClass, timestamp, level);
    }
}
