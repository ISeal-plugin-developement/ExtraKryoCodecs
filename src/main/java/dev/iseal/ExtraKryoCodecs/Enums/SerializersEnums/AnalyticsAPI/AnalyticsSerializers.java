package dev.iseal.ExtraKryoCodecs.Enums.SerializersEnums.AnalyticsAPI;

import com.esotericsoftware.kryo.kryo5.Serializer;
import dev.iseal.ExtraKryoCodecs.Codecs.AnalyticsAPI.ProgramVersionInfoSerializer;
import dev.iseal.ExtraKryoCodecs.Codecs.AnalyticsAPI.PluginVersionInfoSerializer;
import dev.iseal.ExtraKryoCodecs.Holders.AnalyticsAPI.ProgramVersionInfo;
import dev.iseal.ExtraKryoCodecs.Holders.AnalyticsAPI.PluginVersionInfo;
import dev.iseal.ExtraKryoCodecs.Utils.SerializerEnum;

public enum AnalyticsSerializers implements SerializerEnum {

    PLUGIN_VERSION_INFO(1101, PluginVersionInfo.class, new PluginVersionInfoSerializer(), "plugin_version_info"),
    PROGRAM_VERSION_INFO(1102, ProgramVersionInfo.class, new ProgramVersionInfoSerializer(), "program_version_info");

    private final int serializerID;
    private final Class<?> effectClass;
    private final Serializer<?> serializer;
    private final String packetName;

    AnalyticsSerializers(int serializerID, Class<?> serializedClass, Serializer<?> serializer, String packetName) {
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
