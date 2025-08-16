package dev.iseal.ExtraKryoCodecs.Enums.SerializersEnums.AnalyticsAPI;

import com.esotericsoftware.kryo.Serializer;
import dev.iseal.ExtraKryoCodecs.Codecs.AnalyticsAPI.SealLib.AverageTPSSerializer;
import dev.iseal.ExtraKryoCodecs.Holders.AnalyticsAPI.SealLib.AverageTPS;
import dev.iseal.ExtraKryoCodecs.Utils.SerializerEnum;

public enum SealLibAnalyticsSerializers implements SerializerEnum {

    AVERAGE_TPS(1501, AverageTPS.class, new AverageTPSSerializer(), "average_tps");

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