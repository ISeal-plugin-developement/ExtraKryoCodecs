package dev.iseal.ExtraKryoCodecs.Enums.SerializersEnums.AnalyticsAPI;

import com.esotericsoftware.kryo.kryo5.Serializer;
import dev.iseal.ExtraKryoCodecs.Codecs.AnalyticsAPI.SealUtils.ErrorReportSerializer;
import dev.iseal.ExtraKryoCodecs.Holders.AnalyticsAPI.SealUtils.ErrorReport;
import dev.iseal.ExtraKryoCodecs.Utils.SerializerEnum;

public enum SealUtilsAnalyticsSerializers implements SerializerEnum {

    ERROR_REPORT(1501, ErrorReport.class, new ErrorReportSerializer(), "error_report");

    private final int serializerID;
    private final Class<?> effectClass;
    private final Serializer<?> serializer;
    private final String packetName;

    SealUtilsAnalyticsSerializers(int serializerID, Class<?> serializedClass, Serializer<?> serializer, String packetName) {
        this.serializerID = serializerID;
        this.effectClass = serializedClass;
        this.serializer = serializer;
        this.packetName = packetName;
    }

    @Override
    public int getID() {
        return serializerID;
    }

    @Override
    public Class<?> getEffectClass() {
        return effectClass;
    }

    @Override
    public Serializer<?> getSerializer() {
        return serializer;
    }

    @Override
    public String getPacketName() {
        return packetName;
    }
}
