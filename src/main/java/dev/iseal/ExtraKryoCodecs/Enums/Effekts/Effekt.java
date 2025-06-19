package dev.iseal.ExtraKryoCodecs.Enums.Effekts;

import dev.iseal.ExtraKryoCodecs.Holders.Effekts.ScreenFlashHolder;
import dev.iseal.ExtraKryoCodecs.Holders.Effekts.WorldParticleBuilderHolder;
import team.lodestar.lodestone.systems.screenshake.ScreenshakeInstance;

public enum Effekt {
    SCREEN_SHAKE(ScreenshakeInstance.class),
    PARTICLE(WorldParticleBuilderHolder.class),
    SCREEN_FLASH(ScreenFlashHolder.class);

    private final Class<?> targetClass;

    Effekt(Class<?> targetClass) {
        this.targetClass = targetClass;
    }

    public Class<?> getEffectClass() {
        return targetClass;
    }
}
