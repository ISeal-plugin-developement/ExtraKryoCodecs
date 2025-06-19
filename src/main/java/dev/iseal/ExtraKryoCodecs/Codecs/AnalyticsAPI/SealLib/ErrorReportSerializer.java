package dev.iseal.ExtraKryoCodecs.Codecs.AnalyticsAPI.SealLib;

import com.esotericsoftware.kryo.kryo5.Kryo;
import com.esotericsoftware.kryo.kryo5.Serializer;
import com.esotericsoftware.kryo.kryo5.io.Input;
import com.esotericsoftware.kryo.kryo5.io.Output;
import dev.iseal.ExtraKryoCodecs.Holders.AnalyticsAPI.SealLib.ErrorReport;

import java.util.Date;
import java.util.logging.Level;

public class ErrorReportSerializer extends Serializer<ErrorReport> {
    @Override
    public void write(Kryo kryo, Output output, ErrorReport object) {
        output.writeString(object.reporter());
        output.writeString(object.reporterVersion());
        output.writeString(object.errorMessage());
        kryo.writeObject(output, object.stackTrace());
        output.writeLong(object.timestamp().getTime());
        output.writeString(object.level().getName());
    }

    @Override
    public ErrorReport read(Kryo kryo, Input input, Class<? extends ErrorReport> type) {
        String reporter = input.readString();
        String reporterVersion = input.readString();
        String errorMessage = input.readString();
        String[] stackTrace = kryo.readObject(input, String[].class);
        long timestampMillis = input.readLong();
        Date timestamp = new Date(timestampMillis);
        String levelName = input.readString();
        Level level = Level.parse(levelName);

        return new ErrorReport(reporter, reporterVersion, errorMessage, stackTrace, timestamp, level);
    }
}
