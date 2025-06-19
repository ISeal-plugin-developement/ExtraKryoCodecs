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
            System.out.println("Registering " + serializer.getClazz().getName());
            try {
                for (Enum<?> enumConstant : serializer.getClazz().getEnumConstants()) {
                    System.out.println("Registering enum constant " + enumConstant.name());
                    SerializerEnum kryoSerializer = (SerializerEnum) enumConstant;
                    kryo.register(kryoSerializer.getEffectClass(), kryoSerializer.getSerializer(), kryoSerializer.getID());
                }
            } catch (NoClassDefFoundError e) {
                // ignore the register
                System.out.println("Failed to register " + serializer.getClazz().getName());
                System.out.println("Ignoring...");
            }
        }
    }

    public static void init(Kryo kryo, boolean debugIn, Serializer... toRegister) {
        System.out.println("Registering serializers...");
        debug = debugIn;
        for (Serializer serializer : toRegister) {
            System.out.println("Registering " + serializer.getClazz().getName());
            try {
                for (Enum<?> enumConstant : serializer.getClazz().getEnumConstants()) {
                    System.out.println("Registering enum constant " + enumConstant.name());
                    SerializerEnum kryoSerializer = (SerializerEnum) enumConstant;
                    kryo.register(kryoSerializer.getEffectClass(), kryoSerializer.getSerializer(), kryoSerializer.getID());
                }
            } catch (NoClassDefFoundError e) {
                // ignore the register
                System.out.println("Failed to register " + serializer.getClazz().getName());
                System.out.println("Ignoring...");
            }
        }
    }
}