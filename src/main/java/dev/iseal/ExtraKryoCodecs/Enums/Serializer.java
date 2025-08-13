package dev.iseal.ExtraKryoCodecs.Enums;

import dev.iseal.ExtraKryoCodecs.Enums.SerializersEnums.AnalyticsAPI.*;
import dev.iseal.ExtraKryoCodecs.Utils.SerializerEnum;

public enum Serializer {

    ANALYTICS_API(
            AnalyticsSerializers.class,
            AuthenticationAnalyticsSerializers.class,
            PerformanceAnalyticsSerializers.class,
            PowerGemsAnalyticsSerializers.class,
            SealLibAnalyticsSerializers.class,
            SealUtilsAnalyticsSerializers.class
    );

    private final Class<? extends Enum<?>>[] classes;

    @SafeVarargs
    Serializer(Class<? extends Enum<?>>... classes) {
        this.classes = classes;
    }

    public Class<? extends Enum<?>>[] getClasses() {
        return classes;
    }

    /**
     * Returns the serializer enum constant for the given packet name.
     *
     * @param packetName the name of the packet to find the serializer for
     * @return the serializer enum constant
     * @throws IllegalArgumentException if no serializer is found for the given ID
     */
    @SuppressWarnings("unchecked")
    public static <T extends Enum<T> & SerializerEnum> T forPacketName(String packetName) {
        for (Serializer value : Serializer.values()) {
            for (Class<? extends Enum<?>> aClass : value.getClasses()) {
                for (Object serializerEnum : aClass.getEnumConstants()) {
                    if (((SerializerEnum) serializerEnum).getPacketName().equals(packetName)) {
                        return (T) serializerEnum;
                    }
                }
            }
        }
        throw new IllegalArgumentException("No serializer found for packet name: " + packetName);
    }
}
