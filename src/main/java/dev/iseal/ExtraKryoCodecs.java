package dev.iseal;

import com.esotericsoftware.kryo.kryo5.Kryo;
import com.esotericsoftware.kryo.kryo5.io.Input;
import com.esotericsoftware.kryo.kryo5.io.Output;
import dev.iseal.Enums.Serializers;
import dev.iseal.Holders.WorldParticleBuilderHolder;
import team.lodestar.lodestone.registry.common.particle.LodestoneParticleRegistry;
import team.lodestar.lodestone.systems.particle.builder.WorldParticleBuilder;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class ExtraKryoCodecs {

    public static void init(Kryo kryo) {
        for (Serializers serializer : Serializers.values()) {
            kryo.register(serializer.getEffectClass(), serializer.getSerializer(), serializer.getID());
        }
    }

    public static void main(String[] args) {
        try {
            Kryo kryo = new Kryo();
            init(kryo);
            WorldParticleBuilderHolder holder = new WorldParticleBuilderHolder(LodestoneParticleRegistry.WISP_PARTICLE)
                    .disableCull()
                    .enableNoClip()
                    .setLifetime(20);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            Output output = new Output(outputStream);
            kryo.writeObject(output, holder);
            output.flush();
            output.close();
            outputStream.flush();
            byte[] data = outputStream.toByteArray();
            ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
            Input input = new Input(inputStream);
            WorldParticleBuilderHolder deserialized = kryo.readObject(input, WorldParticleBuilderHolder.class);
            System.out.println(deserialized.getColorData().b2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}