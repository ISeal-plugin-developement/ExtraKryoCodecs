package dev.iseal.Codecs.Lodestone.Internal;

import com.esotericsoftware.kryo.kryo5.Kryo;
import com.esotericsoftware.kryo.kryo5.Serializer;
import com.esotericsoftware.kryo.kryo5.io.Input;
import com.esotericsoftware.kryo.kryo5.io.Output;
import team.lodestar.lodestone.systems.easing.Easing;
import team.lodestar.lodestone.systems.particle.data.spin.SpinParticleData;

public class SpinParticleDataSerializer extends Serializer<SpinParticleData> {
    @Override
    public void write(Kryo kryo, Output output, SpinParticleData spinParticleData) {
        output.writeFloat(spinParticleData.startingValue);
        output.writeFloat(spinParticleData.middleValue);
        output.writeFloat(spinParticleData.endingValue);
        output.writeFloat(spinParticleData.spinOffset);
        output.writeFloat(spinParticleData.coefficient);
        output.writeString(spinParticleData.startToMiddleEasing.name);
        output.writeString(spinParticleData.middleToEndEasing.name);
    }

    @Override
    public SpinParticleData read(Kryo kryo, Input input, Class<? extends SpinParticleData> aClass) {
        float startingValue = input.readFloat();
        float middleValue = input.readFloat();
        float endingValue = input.readFloat();
        float spinOffset = input.readFloat();
        float coefficient = input.readFloat();
        Easing startToMiddleEasing = Easing.valueOf(input.readString());
        Easing middleToEndEasing = Easing.valueOf(input.readString());
        return SpinParticleData.create(startingValue, middleValue, endingValue)
                .setEasing(startToMiddleEasing, middleToEndEasing)
                .setSpinOffset(spinOffset)
                .setCoefficient(coefficient)
                .build();
    }
}
