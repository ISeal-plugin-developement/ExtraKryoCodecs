package dev.iseal.ExtraKryoCodecs.Codecs.Lodestone;

import com.esotericsoftware.kryo.kryo5.Kryo;
import com.esotericsoftware.kryo.kryo5.Serializer;
import com.esotericsoftware.kryo.kryo5.io.Input;
import com.esotericsoftware.kryo.kryo5.io.Output;
import team.lodestar.lodestone.systems.easing.Easing;
import team.lodestar.lodestone.systems.screenshake.ScreenshakeInstance;

import static dev.iseal.ExtraKryoCodecs.ExtraKryoCodecs.debug;

public class ScreenshakeSerializer extends Serializer<ScreenshakeInstance> {
    @Override
    public void write(Kryo kryo, Output output, ScreenshakeInstance screenshakeInstance) {
        output.writeInt(screenshakeInstance.duration, false);
        output.writeFloat(screenshakeInstance.intensity1);
        output.writeFloat(screenshakeInstance.intensity2);
        output.writeFloat(screenshakeInstance.intensity3);
        output.writeInt(screenshakeInstance.progress, false);
        output.writeString(screenshakeInstance.intensityCurveStartEasing.name);
        output.writeString(screenshakeInstance.intensityCurveEndEasing.name);
        if (debug) {
            System.out.println("Serializing ScreenshakeInstance:");
            System.out.println("Duration: " + screenshakeInstance.duration);
            System.out.println("Intensity1: " + screenshakeInstance.intensity1);
            System.out.println("Intensity2: " + screenshakeInstance.intensity2);
            System.out.println("Intensity3: " + screenshakeInstance.intensity3);
            System.out.println("Progress: " + screenshakeInstance.progress);
            System.out.println("IntensityCurveStartEasing: " + screenshakeInstance.intensityCurveStartEasing.name);
            System.out.println("IntensityCurveEndEasing: " + screenshakeInstance.intensityCurveEndEasing.name);
        }
    }

    @Override
    public ScreenshakeInstance read(Kryo kryo, Input input, Class<? extends ScreenshakeInstance> aClass) {
        int duration = input.readInt(false);
        float intensity1 = input.readFloat();
        float intensity2 = input.readFloat();
        float intensity3 = input.readFloat();
        int progress = input.readInt(false);
        String intensityCurveStartEasing = input.readString();
        String intensityCurveEndEasing = input.readString();
        ScreenshakeInstance inst = new ScreenshakeInstance(duration)
                .setEasing(Easing.valueOf(intensityCurveStartEasing), Easing.valueOf(intensityCurveEndEasing))
                .setIntensity(intensity1, intensity2, intensity3);
        inst.progress = progress;
        if (debug) {
            System.out.println("Read ScreenshakeInstance:");
            System.out.println("Duration: " + inst.duration);
            System.out.println("Intensity1: " + inst.intensity1);
            System.out.println("Intensity2: " + inst.intensity2);
            System.out.println("Intensity3: " + inst.intensity3);
            System.out.println("Progress: " + inst.progress);
            System.out.println("IntensityCurveStartEasing: " + inst.intensityCurveStartEasing);
            System.out.println("IntensityCurveEndEasing: " + inst.intensityCurveEndEasing);
        }
        return inst;
    }
}
