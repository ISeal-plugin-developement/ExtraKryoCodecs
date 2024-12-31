package dev.iseal.ExtraKryoCodecs.Enums.SerializersEnums;

import com.esotericsoftware.kryo.kryo5.Serializer;
import dev.iseal.ExtraKryoCodecs.Codecs.Lodestone.Internal.ColorParticleDataSerializer;
import dev.iseal.ExtraKryoCodecs.Codecs.Lodestone.Internal.GenericParticleDataSerializer;
import dev.iseal.ExtraKryoCodecs.Codecs.Lodestone.Internal.SpinParticleDataSerializer;
import dev.iseal.ExtraKryoCodecs.Codecs.Lodestone.ScreenshakeSerializer;
import dev.iseal.ExtraKryoCodecs.Codecs.Lodestone.WorldParticleBuilderHolderSerializer;
import dev.iseal.ExtraKryoCodecs.Holders.WorldParticleBuilderHolder;
import dev.iseal.ExtraKryoCodecs.Utils.SerializerEnums;
import team.lodestar.lodestone.systems.particle.data.GenericParticleData;
import team.lodestar.lodestone.systems.particle.data.color.ColorParticleData;
import team.lodestar.lodestone.systems.particle.data.spin.SpinParticleData;
import team.lodestar.lodestone.systems.screenshake.ScreenshakeInstance;

public enum LodestioneSerializers implements SerializerEnums {

    SCREENSHAKE(101, ScreenshakeInstance.class, new ScreenshakeSerializer()),
    WORLDPARTICLEBUILDERHOLDER(102, WorldParticleBuilderHolder.class, new WorldParticleBuilderHolderSerializer()),
    COLORPARTICLEDATA(103, ColorParticleData.class, new ColorParticleDataSerializer()),
    SPINPARTICLEDATA(105, SpinParticleData.class, new SpinParticleDataSerializer()),
    GENERICPARTICLEDATA(106, GenericParticleData.class, new GenericParticleDataSerializer());

    private final int serializerID;
    private final Class<?> effectClass;
    private final Serializer<?> serializer;

    LodestioneSerializers(int serializerID, Class<?> effectClass, Serializer<?> serializer) {
        this.serializerID = serializerID;
        this.effectClass = effectClass;
        this.serializer = serializer;
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
}