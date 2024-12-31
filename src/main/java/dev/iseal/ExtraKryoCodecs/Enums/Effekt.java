package dev.iseal.ExtraKryoCodecs.Enums;

import dev.iseal.ExtraKryoCodecs.Holders.WorldParticleBuilderHolder;
import team.lodestar.lodestone.systems.screenshake.ScreenshakeInstance;

public enum Effekt {
    SCREENSHAKE(ScreenshakeInstance.class),
    PARTICLE(WorldParticleBuilderHolder.class);

    private final Class<?> targetClass;

    Effekt(Class<?> targetClass) {
        this.targetClass = targetClass;
    }

    public Class<?> getEffectClass() {
        return targetClass;
    }
}
