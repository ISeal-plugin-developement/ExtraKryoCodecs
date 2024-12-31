package dev.iseal.ExtraKryoCodecs.Enums;

import dev.iseal.ExtraKryoCodecs.Enums.SerializersEnums.LodestioneSerializers;

public enum Serializers {

    LODESTONE(LodestioneSerializers.class);

    private final Class<? extends Enum<?>> clazz;

    Serializers(Class<? extends Enum<?>> clazz) {
        this.clazz = clazz;
    }

    public Class<? extends Enum<?>> getClazz() {
        return clazz;
    }
}
