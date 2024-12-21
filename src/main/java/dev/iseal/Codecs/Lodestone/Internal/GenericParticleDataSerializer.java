package dev.iseal.Codecs.Lodestone.Internal;

import com.esotericsoftware.kryo.kryo5.Kryo;
import com.esotericsoftware.kryo.kryo5.Serializer;
import com.esotericsoftware.kryo.kryo5.io.Input;
import com.esotericsoftware.kryo.kryo5.io.Output;
import team.lodestar.lodestone.systems.easing.Easing;
import team.lodestar.lodestone.systems.particle.data.GenericParticleData;

public class GenericParticleDataSerializer extends Serializer<GenericParticleData> {
    @Override
    public void write(Kryo kryo, Output output, GenericParticleData genericParticleData) {
        output.writeFloat(genericParticleData.startingValue);
        output.writeFloat(genericParticleData.middleValue);
        output.writeFloat(genericParticleData.endingValue);
        output.writeFloat(genericParticleData.coefficient);
        output.writeString(genericParticleData.startToMiddleEasing.name);
        output.writeString(genericParticleData.middleToEndEasing.name);
    }

    @Override
    public GenericParticleData read(Kryo kryo, Input input, Class<? extends GenericParticleData> aClass) {
        float startingValue = input.readFloat();
        float middleValue = input.readFloat();
        float endingValue = input.readFloat();
        float coefficient = input.readFloat();
        Easing startToMiddleEasing = Easing.valueOf(input.readString());
        Easing middleToEndEasing = Easing.valueOf(input.readString());
        return GenericParticleData.create(startingValue, middleValue, endingValue)
                .setEasing(startToMiddleEasing, middleToEndEasing)
                .setCoefficient(coefficient)
                .build();
    }
}
