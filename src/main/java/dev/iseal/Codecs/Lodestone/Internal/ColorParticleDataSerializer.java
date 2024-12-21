package dev.iseal.Codecs.Lodestone.Internal;

import com.esotericsoftware.kryo.kryo5.Kryo;
import com.esotericsoftware.kryo.kryo5.Serializer;
import com.esotericsoftware.kryo.kryo5.io.Input;
import com.esotericsoftware.kryo.kryo5.io.Output;
import team.lodestar.lodestone.systems.particle.data.color.ColorParticleData;

public class ColorParticleDataSerializer extends Serializer<ColorParticleData> {
    @Override
    public void write(Kryo kryo, Output output, ColorParticleData colorParticleData) {
        output.writeFloat(colorParticleData.r1);
        output.writeFloat(colorParticleData.g1);
        output.writeFloat(colorParticleData.b1);
        output.writeFloat(colorParticleData.r2);
        output.writeFloat(colorParticleData.g2);
        output.writeFloat(colorParticleData.b2);
        output.writeFloat(colorParticleData.colorCoefficient);
        output.writeFloat(colorParticleData.coefficientMultiplier);
        output.writeString(colorParticleData.colorCurveEasing.name);
    }

    @Override
    public ColorParticleData read(Kryo kryo, Input input, Class<? extends ColorParticleData> aClass) {
        return null;
    }
}
