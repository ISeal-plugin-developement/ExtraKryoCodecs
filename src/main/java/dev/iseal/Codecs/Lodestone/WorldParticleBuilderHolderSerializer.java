package dev.iseal.Codecs.Lodestone;

import com.esotericsoftware.kryo.kryo5.Kryo;
import com.esotericsoftware.kryo.kryo5.KryoException;
import com.esotericsoftware.kryo.kryo5.Serializer;
import com.esotericsoftware.kryo.kryo5.io.Input;
import com.esotericsoftware.kryo.kryo5.io.Output;
import dev.iseal.Enums.Lodestone.ParticleEffect;
import dev.iseal.Holders.WorldParticleBuilderHolder;
import io.github.fabricators_of_create.porting_lib.util.RegistryObject;
import team.lodestar.lodestone.systems.particle.SimpleParticleOptions;
import team.lodestar.lodestone.systems.particle.builder.WorldParticleBuilder;
import team.lodestar.lodestone.systems.particle.data.GenericParticleData;
import team.lodestar.lodestone.systems.particle.data.color.ColorParticleData;
import team.lodestar.lodestone.systems.particle.data.spin.SpinParticleData;
import team.lodestar.lodestone.systems.particle.world.options.WorldParticleOptions;
import team.lodestar.lodestone.systems.particle.world.type.LodestoneWorldParticleType;
import team.lodestar.lodestone.registry.common.particle.LodestoneParticleRegistry;

import java.util.HashMap;

public class WorldParticleBuilderHolderSerializer extends Serializer<WorldParticleBuilderHolder> {

    private static final HashMap<Integer, RegistryObject<LodestoneWorldParticleType>> CACHE = new HashMap<>();

    public WorldParticleBuilderHolderSerializer() {
        super(false, true);
        // build the cache
        CACHE.put(0, LodestoneParticleRegistry.WISP_PARTICLE);
        CACHE.put(1, LodestoneParticleRegistry.SMOKE_PARTICLE);
        CACHE.put(2, LodestoneParticleRegistry.SPARKLE_PARTICLE);
        CACHE.put(3, LodestoneParticleRegistry.TWINKLE_PARTICLE);
        CACHE.put(4, LodestoneParticleRegistry.STAR_PARTICLE);
        CACHE.put(5, LodestoneParticleRegistry.SPARK_PARTICLE);
        CACHE.put(6, LodestoneParticleRegistry.EXTRUDING_SPARK_PARTICLE);
        CACHE.put(7, LodestoneParticleRegistry.THIN_EXTRUDING_SPARK_PARTICLE);
    }

    @Override
    public void write(Kryo kryo, Output output, WorldParticleBuilderHolder worldParticleBuilderHolder) {
        output.writeInt(getIDFromParticleType(worldParticleBuilderHolder.getType()));
        output.writeBoolean(worldParticleBuilderHolder.isNoClip());
        output.writeBoolean(worldParticleBuilderHolder.isForcedSpawn());
        output.writeBoolean(worldParticleBuilderHolder.isShouldCull());
        output.writeDouble(worldParticleBuilderHolder.getXLocation());
        output.writeDouble(worldParticleBuilderHolder.getYLocation());
        output.writeDouble(worldParticleBuilderHolder.getZLocation());
        output.writeDouble(worldParticleBuilderHolder.getMaxXSpeed());
        output.writeDouble(worldParticleBuilderHolder.getMaxYSpeed());
        output.writeDouble(worldParticleBuilderHolder.getMaxZSpeed());
        output.writeDouble(worldParticleBuilderHolder.getXMotion());
        output.writeDouble(worldParticleBuilderHolder.getYMotion());
        output.writeDouble(worldParticleBuilderHolder.getZMotion());
        output.writeDouble(worldParticleBuilderHolder.getMaxXOffset());
        output.writeDouble(worldParticleBuilderHolder.getMaxYOffset());
        output.writeDouble(worldParticleBuilderHolder.getMaxZOffset());
        output.writeFloat(worldParticleBuilderHolder.getGravityStrength());
        output.writeFloat(worldParticleBuilderHolder.getFrictionStrength());
        output.writeInt(worldParticleBuilderHolder.getLifetime());
        output.writeInt(worldParticleBuilderHolder.getLifeDelay());
        output.writeInt(worldParticleBuilderHolder.getParticleEffect().ordinal());
        output.writeInt(worldParticleBuilderHolder.getDiscardFunctionType().ordinal());
        kryo.writeObject(output, worldParticleBuilderHolder.getColorData());
        kryo.writeObject(output, worldParticleBuilderHolder.getScaleData());
        kryo.writeObject(output, worldParticleBuilderHolder.getTransparencyData());
        kryo.writeObject(output, worldParticleBuilderHolder.getSpinData());
    }

    @Override
    public WorldParticleBuilderHolder read(Kryo kryo, Input input, Class<? extends WorldParticleBuilderHolder> aClass) {
        int id = input.readInt();
        RegistryObject<LodestoneWorldParticleType> type = CACHE.get(id);
        WorldParticleBuilderHolder holder = new WorldParticleBuilderHolder(type)
            .setNoClip(input.readBoolean())
            .setForcedSpawn(input.readBoolean())
            .setCull(input.readBoolean())
            .setLocation(input.readDouble(), input.readDouble(), input.readDouble())
            .setRandomMotion(input.readDouble(), input.readDouble(), input.readDouble())
            .setMotion(input.readDouble(), input.readDouble(), input.readDouble())
            .setRandomOffset(input.readDouble(), input.readDouble(), input.readDouble())
            .setGravityStrength(input.readFloat())
            .setFrictionStrength(input.readFloat())
            .setLifetime(input.readInt())
            .setLifeDelay(input.readInt())
            .setParticleEffect(ParticleEffect.values()[input.readInt()])
            .setDiscardFunction(SimpleParticleOptions.ParticleDiscardFunctionType.values()[input.readInt()])
            .setColorData(kryo.readObject(input, ColorParticleData.class))
            .setScaleData(kryo.readObject(input, GenericParticleData.class))
            .setTransparencyData(kryo.readObject(input, GenericParticleData.class))
            .setSpinData(kryo.readObject(input, SpinParticleData.class));
        return holder;
    }

    private int getIDFromParticleType(RegistryObject<LodestoneWorldParticleType> type) {
        // get the id from the cache
        for (int id : CACHE.keySet()) {
            if (CACHE.get(id).equals(type)) {
                return id;
            }
        }
        // particle is not registered!
        // this should never happen
        return -1;
    }

}
