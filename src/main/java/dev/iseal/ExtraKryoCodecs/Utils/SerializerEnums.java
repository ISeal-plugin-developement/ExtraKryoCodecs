package dev.iseal.ExtraKryoCodecs.Utils;

import com.esotericsoftware.kryo.kryo5.Serializer;

public interface SerializerEnums {

    int getID();
    Class<?> getEffectClass();
    Serializer<?> getSerializer();

}
