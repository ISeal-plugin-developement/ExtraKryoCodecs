package dev.iseal.ExtraKryoCodecs.Enums.SerializersEnums.Effekts;

import com.esotericsoftware.kryo.kryo5.Serializer;
import dev.iseal.ExtraKryoCodecs.Codecs.Lodestone.Internal.ColorParticleDataSerializer;
import dev.iseal.ExtraKryoCodecs.Codecs.Lodestone.Internal.GenericParticleDataSerializer;
import dev.iseal.ExtraKryoCodecs.Codecs.Lodestone.Internal.SpinParticleDataSerializer;
import dev.iseal.ExtraKryoCodecs.Codecs.Lodestone.ScreenFlashHolderSerializer;
import dev.iseal.ExtraKryoCodecs.Codecs.Lodestone.ScreenshakeSerializer;
import dev.iseal.ExtraKryoCodecs.Codecs.Lodestone.WorldParticleBuilderHolderSerializer;
import dev.iseal.ExtraKryoCodecs.Holders.Effekts.ScreenFlashHolder;
import dev.iseal.ExtraKryoCodecs.Holders.Effekts.WorldParticleBuilderHolder;
import dev.iseal.ExtraKryoCodecs.Utils.SerializerEnum;
import team.lodestar.lodestone.systems.particle.data.GenericParticleData;
import team.lodestar.lodestone.systems.particle.data.color.ColorParticleData;
import team.lodestar.lodestone.systems.particle.data.spin.SpinParticleData;
import team.lodestar.lodestone.systems.screenshake.ScreenshakeInstance;

public enum LodestoneSerializers implements SerializerEnum {

    SCREEN_SHAKE(101, ScreenshakeInstance.class, new ScreenshakeSerializer(), "screen_shake_instance"),
    WORLD_PARTICLE_BUILDER_HOLDER(111, WorldParticleBuilderHolder.class, new WorldParticleBuilderHolderSerializer(), "world_particle_builder_holder_instance"),
    COLOR_PARTICLE_DATA(112, ColorParticleData.class, new ColorParticleDataSerializer(), "color_particle_data_instance"),
    SPIN_PARTICLE_DATA(113, SpinParticleData.class, new SpinParticleDataSerializer(), "spin_particle_data_instance"),
    GENERIC_PARTICLE_DATA(114, GenericParticleData.class, new GenericParticleDataSerializer(), "generic_particle_data_instance"),
    SCREEN_FLASH_HOLDER(121, ScreenFlashHolder.class, new ScreenFlashHolderSerializer(), "screen_flash_holder_instance");

    private final int serializerID;
    private final Class<?> effectClass;
    private final Serializer<?> serializer;
    private final String packetName;

    LodestoneSerializers(int serializerID, Class<?> serializedClass, Serializer<?> serializer, String packetName) {
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