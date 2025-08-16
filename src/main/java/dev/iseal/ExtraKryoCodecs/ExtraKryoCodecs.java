package dev.iseal.ExtraKryoCodecs;

import com.esotericsoftware.kryo.Kryo;
import dev.iseal.ExtraKryoCodecs.Enums.Serializer;
import dev.iseal.ExtraKryoCodecs.Utils.SerializerEnum;

public class ExtraKryoCodecs {

    public static boolean debug = false;

    public static void init(Kryo kryo, boolean debugIn) {
        init(kryo, debugIn, Serializer.values());
    }

    public static void init(Kryo kryo, boolean debugIn, Serializer... toRegister) {
        debug = debugIn;
        if (debug)
            System.out.println("Registering serializers...");
        for (Serializer serializer : toRegister) {
            for (Class<? extends Enum<?>> clazz : serializer.getClasses()) {
                if (debug)
                    System.out.println("Registering " + clazz.getName());
                try {
                    for (Enum<?> enumConstant : clazz.getEnumConstants()) {
                        if (debug)
                            System.out.println("Registering enum constant " + enumConstant.name());
                        SerializerEnum kryoSerializer = (SerializerEnum) enumConstant;
                        kryo.register(kryoSerializer.getEffectClass(), kryoSerializer.getSerializer(), kryoSerializer.getID());
                    }
                } catch (NoClassDefFoundError e) {
                    // ignore the register
                    if (debug) {
                        System.out.println("Failed to register " + clazz.getName());
                        System.out.println("Ignoring...");
                    }
                }
            }
        }
    }
}