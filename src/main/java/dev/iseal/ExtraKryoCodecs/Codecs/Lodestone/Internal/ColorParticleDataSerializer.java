package dev.iseal.ExtraKryoCodecs.Codecs.Lodestone.Internal;

import com.esotericsoftware.kryo.kryo5.Kryo;
import com.esotericsoftware.kryo.kryo5.Serializer;
import com.esotericsoftware.kryo.kryo5.io.Input;
import com.esotericsoftware.kryo.kryo5.io.Output;
import team.lodestar.lodestone.systems.easing.Easing;
import team.lodestar.lodestone.systems.particle.data.color.ColorParticleData;

import static dev.iseal.ExtraKryoCodecs.ExtraKryoCodecs.debug;

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
        output.writeString(colorParticleData.colorCurveEasing.name);
        if (debug) {
            System.out.println("Serializing ColorParticleData:");
            System.out.println("r1: " + colorParticleData.r1);
            System.out.println("g1: " + colorParticleData.g1);
            System.out.println("b1: " + colorParticleData.b1);
            System.out.println("r2: " + colorParticleData.r2);
            System.out.println("g2: " + colorParticleData.g2);
            System.out.println("b2: " + colorParticleData.b2);
            System.out.println("colorCoefficient: " + colorParticleData.colorCoefficient);
            System.out.println("colorCurveEasing: " + colorParticleData.colorCurveEasing.name);
        }
    }

    @Override
    public ColorParticleData read(Kryo kryo, Input input, Class<? extends ColorParticleData> aClass) {
        ColorParticleData data = ColorParticleData.create(
                // r1
                input.readFloat(),
                // g1
                input.readFloat(),
                // b1
                input.readFloat(),
                // r2
                input.readFloat(),
                // g2
                input.readFloat(),
                // b2
                input.readFloat())
                .setCoefficient(input.readFloat())
                .setEasing(Easing.valueOf(input.readString()))
                .build();
        if (debug) {
            System.out.println("Deserialized ColorParticleData:");
            System.out.println("r1: " + data.r1);
            System.out.println("g1: " + data.g1);
            System.out.println("b1: " + data.b1);
            System.out.println("r2: " + data.r2);
            System.out.println("g2: " + data.g2);
            System.out.println("b2: " + data.b2);
            System.out.println("colorCoefficient: " + data.colorCoefficient);
            System.out.println("colorCurveEasing: " + data.colorCurveEasing);
        }
        return data;
    }
}
