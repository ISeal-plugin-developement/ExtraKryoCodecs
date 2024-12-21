package dev.iseal.Enums;

import com.esotericsoftware.kryo.kryo5.Serializer;
import dev.iseal.Codecs.Lodestone.Internal.ColorParticleDataSerializer;
import dev.iseal.Codecs.Lodestone.Internal.GenericParticleDataSerializer;
import dev.iseal.Codecs.Lodestone.Internal.SpinParticleDataSerializer;
import dev.iseal.Codecs.Lodestone.ScreenshakeSerializer;
import dev.iseal.Codecs.Lodestone.WorldParticleBuilderHolderSerializer;
import dev.iseal.Holders.WorldParticleBuilderHolder;
import team.lodestar.lodestone.systems.particle.SimpleParticleOptions;
import team.lodestar.lodestone.systems.particle.data.GenericParticleData;
import team.lodestar.lodestone.systems.particle.data.color.ColorParticleData;
import team.lodestar.lodestone.systems.particle.data.spin.SpinParticleData;
import team.lodestar.lodestone.systems.screenshake.ScreenshakeInstance;

public enum Serializers {

    SCREENSHAKE(100, ScreenshakeInstance.class, new ScreenshakeSerializer()),
    WORLDPARTICLEBUILDERHOLDER(102, WorldParticleBuilderHolder.class, new WorldParticleBuilderHolderSerializer()),
    COLORPARTICLEDATA(103, ColorParticleData.class, new ColorParticleDataSerializer()),
    SPINPARTICLEDATA(105, SpinParticleData.class, new SpinParticleDataSerializer()),
    GENERICPARTICLEDATA(106, GenericParticleData.class, new GenericParticleDataSerializer());

    public static Serializers fromID(int serializerID) {
        for (Serializers serializer : values()) {
            if (serializer.getID() != serializerID) {
                continue;
            }
            return serializer;
        }
        return SCREENSHAKE;
    }

    private final int serializerID;
    private final Class<?> effectClass;
    private final Serializer<?> serializer;

    Serializers(int serializerID, Class<?> effectClass, Serializer<?> serializer) {
        this.serializerID = serializerID;
        this.effectClass = effectClass;
        this.serializer = serializer;
    }

    public int getID() {
        return serializerID;
    }
    public Class<?> getEffectClass() {
        return effectClass;
    }
    public Serializer<?> getSerializer() {
        return serializer;
    }
}