package dev.iseal.ExtraKryoCodecs.Enums.SerializersEnums.AnalyticsAPI;

import com.esotericsoftware.kryo.kryo5.Serializer;
import dev.iseal.ExtraKryoCodecs.Codecs.AnalyticsAPI.PowerGems.ConfigInfoSerializer;
import dev.iseal.ExtraKryoCodecs.Codecs.AnalyticsAPI.SealLib.ErrorReportSerializer;
import dev.iseal.ExtraKryoCodecs.Holders.AnalyticsAPI.PowerGems.PGConfigInfo;
import dev.iseal.ExtraKryoCodecs.Holders.AnalyticsAPI.SealLib.ErrorReport;
import dev.iseal.ExtraKryoCodecs.Utils.SerializerEnum;

public enum SealLibAnalyticsSerializers implements SerializerEnum {

    ERROR_REPORT(1401, ErrorReport.class, new ErrorReportSerializer(), "error_report");

    private final int serializerID;
    private final Class<?> effectClass;
    private final Serializer<?> serializer;
    private final String packetName;

    SealLibAnalyticsSerializers(int serializerID, Class<?> serializedClass, Serializer<?> serializer, String packetName) {
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