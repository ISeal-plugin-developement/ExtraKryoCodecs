package dev.iseal.ExtraKryoCodecs.Codecs.Lodestone.Internal;

import com.esotericsoftware.kryo.kryo5.Kryo;
import com.esotericsoftware.kryo.kryo5.Serializer;
import com.esotericsoftware.kryo.kryo5.io.Input;
import com.esotericsoftware.kryo.kryo5.io.Output;
import team.lodestar.lodestone.systems.easing.Easing;
import team.lodestar.lodestone.systems.particle.data.GenericParticleData;

import static dev.iseal.ExtraKryoCodecs.ExtraKryoCodecs.debug;

public class GenericParticleDataSerializer extends Serializer<GenericParticleData> {
    @Override
    public void write(Kryo kryo, Output output, GenericParticleData genericParticleData) {
        output.writeFloat(genericParticleData.startingValue);
        output.writeFloat(genericParticleData.middleValue);
        output.writeFloat(genericParticleData.endingValue);
        output.writeFloat(genericParticleData.coefficient);
        output.writeString(genericParticleData.startToMiddleEasing.name);
        output.writeString(genericParticleData.middleToEndEasing.name);
        if (debug) {
            System.out.println("Serializing GenericParticleData:");
            System.out.println("startingValue: " + genericParticleData.startingValue);
            System.out.println("middleValue: " + genericParticleData.middleValue);
            System.out.println("endingValue: " + genericParticleData.endingValue);
            System.out.println("coefficient: " + genericParticleData.coefficient);
            System.out.println("startToMiddleEasing: " + genericParticleData.startToMiddleEasing.name);
            System.out.println("middleToEndEasing: " + genericParticleData.middleToEndEasing.name);
        }
    }

    @Override
    public GenericParticleData read(Kryo kryo, Input input, Class<? extends GenericParticleData> aClass) {
        float startingValue = input.readFloat();
        float middleValue = input.readFloat();
        float endingValue = input.readFloat();
        float coefficient = input.readFloat();
        Easing startToMiddleEasing = Easing.valueOf(input.readString());
        Easing middleToEndEasing = Easing.valueOf(input.readString());
        if (debug) {
            System.out.println("Deserialized GenericParticleData:");
            System.out.println("startingValue: " + startingValue);
            System.out.println("middleValue: " + middleValue);
            System.out.println("endingValue: " + endingValue);
            System.out.println("coefficient: " + coefficient);
            System.out.println("startToMiddleEasing: " + startToMiddleEasing);
            System.out.println("middleToEndEasing: " + middleToEndEasing);
        }
        return GenericParticleData.create(startingValue, middleValue, endingValue)
                .setEasing(startToMiddleEasing, middleToEndEasing)
                .setCoefficient(coefficient)
                .build();
    }
}
