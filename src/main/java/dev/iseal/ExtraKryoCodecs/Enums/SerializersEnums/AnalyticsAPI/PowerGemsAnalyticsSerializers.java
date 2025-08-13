package dev.iseal.ExtraKryoCodecs.Enums.SerializersEnums.AnalyticsAPI;

import com.esotericsoftware.kryo.kryo5.Serializer;
import dev.iseal.ExtraKryoCodecs.Codecs.AnalyticsAPI.PowerGems.AddonsLoadedSerializer;
import dev.iseal.ExtraKryoCodecs.Codecs.AnalyticsAPI.PowerGems.GemUsagesHourlySerializer;
import dev.iseal.ExtraKryoCodecs.Holders.AnalyticsAPI.PowerGems.PGAddonsLoaded;
import dev.iseal.ExtraKryoCodecs.Holders.AnalyticsAPI.PowerGems.PGGemUsagesHourly;
import dev.iseal.ExtraKryoCodecs.Utils.SerializerEnum;

public enum PowerGemsAnalyticsSerializers implements SerializerEnum {

    GEM_USAGES(1401, PGGemUsagesHourly.class, new GemUsagesHourlySerializer(), "gem_usages"),
    ADDONS_LOADED(1411, PGAddonsLoaded.class, new AddonsLoadedSerializer(), "addons_loaded");

    private final int serializerID;
    private final Class<?> effectClass;
    private final Serializer<?> serializer;
    private final String packetName;

    PowerGemsAnalyticsSerializers(int serializerID, Class<?> serializedClass, Serializer<?> serializer, String packetName) {
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
