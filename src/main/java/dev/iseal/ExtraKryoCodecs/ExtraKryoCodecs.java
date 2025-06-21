package dev.iseal.ExtraKryoCodecs;

import com.esotericsoftware.kryo.kryo5.Kryo;
import dev.iseal.ExtraKryoCodecs.Enums.Serializer;
import dev.iseal.ExtraKryoCodecs.Utils.SerializerEnum;

public class ExtraKryoCodecs {

    public static boolean debug = false;

    public static void init(Kryo kryo, boolean debugIn) {
        System.out.println("Registering serializers...");
        debug = debugIn;
        for (Serializer serializer : Serializer.values()) {
            for (Class<? extends Enum<?>> clazz : serializer.getClasses()) {
                System.out.println("Registering " + clazz.getName());
                try {
                    for (Enum<?> enumConstant : clazz.getEnumConstants()) {
                        System.out.println("Registering enum constant " + enumConstant.name());
                        SerializerEnum kryoSerializer = (SerializerEnum) enumConstant;
                        kryo.register(kryoSerializer.getEffectClass(), kryoSerializer.getSerializer(), kryoSerializer.getID());
                    }
                } catch (NoClassDefFoundError e) {
                    // ignore the register
                    System.out.println("Failed to register " + clazz.getName());
                    System.out.println("Ignoring...");
                }
            }
        }
    }

    public static void init(Kryo kryo, boolean debugIn, Serializer... toRegister) {
        System.out.println("Registering serializers...");
        debug = debugIn;
        for (Serializer serializer : toRegister) {
            for (Class<? extends Enum<?>> clazz : serializer.getClasses()) {
                System.out.println("Registering " + clazz.getName());
                try {
                    for (Enum<?> enumConstant : clazz.getEnumConstants()) {
                        System.out.println("Registering enum constant " + enumConstant.name());
                        SerializerEnum kryoSerializer = (SerializerEnum) enumConstant;
                        kryo.register(kryoSerializer.getEffectClass(), kryoSerializer.getSerializer(), kryoSerializer.getID());
                    }
                } catch (NoClassDefFoundError e) {
                    // ignore the register
                    System.out.println("Failed to register " + clazz.getName());
                    System.out.println("Ignoring...");
                }
            }
        }
    }
}