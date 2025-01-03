package dev.iseal.ExtraKryoCodecs;

import com.esotericsoftware.kryo.kryo5.Kryo;
import dev.iseal.ExtraKryoCodecs.Enums.Serializers;
import dev.iseal.ExtraKryoCodecs.Utils.SerializerEnums;
import dev.iseal.ExtraKryoCodecs.Utils.WorldParticleHolderToBuilder;

import java.io.PrintWriter;
import java.util.HashMap;

public class ExtraKryoCodecs {

    public static boolean debug = false;

    public static void init(Kryo kryo, boolean debugIn) {
        System.out.println("Registering serializers...");
        debug = debugIn;
        for (Serializers serializer : Serializers.values()) {
            System.out.println("Registering " + serializer.getClazz().getName());
            try {
                for (Enum<?> enumConstant : serializer.getClazz().getEnumConstants()) {
                    System.out.println("Registering enum constant " + enumConstant.name());
                    SerializerEnums kryoSerializer = (SerializerEnums) enumConstant;
                    kryo.register(kryoSerializer.getEffectClass(), kryoSerializer.getSerializer(), kryoSerializer.getID());
                }
            } catch (NoClassDefFoundError e) {
                // ignore the register
                System.out.println("Failed to register " + serializer.getClazz().getName());
                System.out.println("Ignoring...");
            }
        }
    }

    public static void initClient() {
        WorldParticleHolderToBuilder.getInstance().initClient();
    }
}