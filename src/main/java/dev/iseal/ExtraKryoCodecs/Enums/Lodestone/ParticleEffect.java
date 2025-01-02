package dev.iseal.ExtraKryoCodecs.Enums.Lodestone;

import jdk.jfr.Experimental;

public enum ParticleEffect {

    // as for args:
    // 0: level, then an array of Objects maybe??
    // not sure. need to learn how java works
    SPAWN,
    REPEAT,
    SURROUND_BLOCK,
    REPEAT_SURROUND_BLOCK,
    SPAWN_AT_RANDOM_FACE,
    REPEAT_AT_RANDOM_FACE,
    // TODO: implement on client
    @Experimental
    CIRCLE,
    // TODO: implement on client
    @Experimental
    REPEAT_CIRCLE,

    CREATE_BLOCK_OUTLINE,
    SPAWN_LINE;
}
