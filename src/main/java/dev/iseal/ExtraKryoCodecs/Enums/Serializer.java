package dev.iseal.ExtraKryoCodecs.Enums;

import dev.iseal.ExtraKryoCodecs.Enums.SerializersEnums.AnalyticsAPI.AnalyticsSerializers;
import dev.iseal.ExtraKryoCodecs.Enums.SerializersEnums.AnalyticsAPI.PowerGemsAnalyticsSerializers;
import dev.iseal.ExtraKryoCodecs.Enums.SerializersEnums.AnalyticsAPI.SealLibAnalyticsSerializers;
import dev.iseal.ExtraKryoCodecs.Utils.SerializerEnum;

public enum Serializer {

    ANALYTICS_API(AnalyticsSerializers.class),
    ANALYTICS_API_POWERGEMS(PowerGemsAnalyticsSerializers.class),
    ANALYTICS_API_SEALLIB(SealLibAnalyticsSerializers.class);

    private final Class<? extends Enum<?>> clazz;

    Serializer(Class<? extends Enum<?>> clazz) {
        this.clazz = clazz;
    }

    public Class<? extends Enum<?>> getClazz() {
        return clazz;
    }

    /**
     * Returns the serializer enum constant for the given packet name.
     *
     * @param packetName the name of the packet to find the serializer for
     * @return the serializer enum constant
     * @throws IllegalArgumentException if no serializer is found for the given ID
     */
    public static <T extends Enum<T> & SerializerEnum> T forPacketName(String packetName) {
        for (Serializer value : Serializer.values()) {
            for (T serializerEnum : (T[]) value.getClazz().getEnumConstants()) {
                if (serializerEnum.getPacketName().equals(packetName)) {
                    return serializerEnum;
                }
            }
        }
        throw new IllegalArgumentException("No serializer found for packet name: " + packetName);
    }
}
