package dev.iseal.ExtraKryoCodecs.Utils.Effekts;

import dev.iseal.ExtraKryoCodecs.Holders.Effekts.WorldParticleBuilderHolder;

import io.github.fabricators_of_create.porting_lib.util.RegistryObject;
import team.lodestar.lodestone.registry.common.particle.LodestoneParticleRegistry;
import team.lodestar.lodestone.systems.particle.builder.WorldParticleBuilder;
import team.lodestar.lodestone.systems.particle.world.type.LodestoneWorldParticleType;

import java.util.HashMap;

public class WorldParticleHolderToBuilder {

    private static WorldParticleHolderToBuilder INSTANCE;
    public static WorldParticleHolderToBuilder getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new WorldParticleHolderToBuilder();
        }
        return INSTANCE;
    }

    private final HashMap<Integer, RegistryObject<LodestoneWorldParticleType>> CACHE = new HashMap<>();

    public void initClient() {
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

    public WorldParticleBuilder create(WorldParticleBuilderHolder holder) {
        return WorldParticleBuilder.create(getParticleType(holder.getType()))
                .setColorData(holder.getColorData())
                .setScaleData(holder.getScaleData())
                .setSpinData(holder.getSpinData())
                .setTransparencyData(holder.getTransparencyData())
                .setDiscardFunction(holder.getDiscardFunctionType())
                .setLifetime(holder.getLifetime())
                .setNoClip(holder.isNoClip())
                .setLifeDelay(holder.getLifeDelay())
                .setShouldCull(holder.isShouldCull())
                .setMotion(holder.getXMotion(), holder.getYMotion(), holder.getZMotion())
                .setRandomMotion(holder.getMaxXSpeed(), holder.getMaxXSpeed(), holder.getMaxZSpeed())
                .setForceSpawn(holder.isForcedSpawn())
                .setGravityStrength(holder.getGravityStrength())
                .setFrictionStrength(holder.getFrictionStrength())
                .setRandomOffset(holder.getMaxXOffset(), holder.getMaxYOffset(), holder.getMaxZOffset());
    }

    public RegistryObject<LodestoneWorldParticleType> getParticleType(int id) {
        if (!CACHE.containsKey(id)) {
            throw new IllegalArgumentException("Unknown particle type: " + id);
        }
        return CACHE.get(id);
    }

}
