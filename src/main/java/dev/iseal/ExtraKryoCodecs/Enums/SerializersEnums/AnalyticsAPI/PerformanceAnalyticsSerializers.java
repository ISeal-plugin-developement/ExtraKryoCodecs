package dev.iseal.ExtraKryoCodecs.Enums.SerializersEnums.AnalyticsAPI;

import com.esotericsoftware.kryo.Serializer;
import dev.iseal.ExtraKryoCodecs.Codecs.AnalyticsAPI.Performance.PerfManagerDurationsSerializer;
import dev.iseal.ExtraKryoCodecs.Holders.AnalyticsAPI.Performance.PerfManagerDurations;
import dev.iseal.ExtraKryoCodecs.Utils.SerializerEnum;

public enum PerformanceAnalyticsSerializers implements SerializerEnum {

    PERF_MANAGER_DURATIONS(1301, PerfManagerDurations.class, new PerfManagerDurationsSerializer(), "perf_manager_durations");

    private final int serializerID;
    private final Class<?> effectClass;
    private final Serializer<?> serializer;
    private final String packetName;

    PerformanceAnalyticsSerializers(int serializerID, Class<?> serializedClass, Serializer<?> serializer, String packetName) {
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