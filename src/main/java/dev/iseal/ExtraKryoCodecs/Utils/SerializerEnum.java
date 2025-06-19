package dev.iseal.ExtraKryoCodecs.Utils;

import com.esotericsoftware.kryo.kryo5.Serializer;

public interface SerializerEnum {

    int getID();
    Class<?> getEffectClass();
    Serializer<?> getSerializer();
    String getPacketName();

}