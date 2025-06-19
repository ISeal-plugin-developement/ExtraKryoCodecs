package dev.iseal.ExtraKryoCodecs.Codecs.Lodestone;

import com.esotericsoftware.kryo.kryo5.Kryo;
import com.esotericsoftware.kryo.kryo5.Serializer;
import com.esotericsoftware.kryo.kryo5.io.Input;
import com.esotericsoftware.kryo.kryo5.io.Output;
import dev.iseal.ExtraKryoCodecs.Holders.Effekts.ScreenFlashHolder;

import static dev.iseal.ExtraKryoCodecs.ExtraKryoCodecs.debug;

public class ScreenFlashHolderSerializer extends Serializer<ScreenFlashHolder> {

    @Override
    public void write(Kryo kryo, Output output, ScreenFlashHolder screenFlashHolder) {
        output.writeInt(screenFlashHolder.getDuration());
        output.writeFloat(screenFlashHolder.getIntensity());
        output.writeInt(screenFlashHolder.getColorR());
        output.writeInt(screenFlashHolder.getColorG());
        output.writeInt(screenFlashHolder.getColorB());
        if (debug) {
            System.out.println("Serializing ScreenFlashHolder:");
            System.out.println("Duration: " + screenFlashHolder.getDuration());
            System.out.println("Intensity: " + screenFlashHolder.getIntensity());
            System.out.println("ColorR: " + screenFlashHolder.getColorR());
            System.out.println("ColorG: " + screenFlashHolder.getColorG());
            System.out.println("ColorB: " + screenFlashHolder.getColorB());
        }
    }

    @Override
    public ScreenFlashHolder read(Kryo kryo, Input input, Class<? extends ScreenFlashHolder> aClass) {
        int duration = input.readInt();
        float intensity = input.readFloat();
        int colorR = input.readInt();
        int colorG = input.readInt();
        int colorB = input.readInt();
        if (debug) {
            System.out.println("Deserialized ScreenFlashHolder:");
            System.out.println("Duration: " + duration);
            System.out.println("Intensity: " + intensity);
            System.out.println("ColorR: " + colorR);
            System.out.println("ColorG: " + colorG);
            System.out.println("ColorB: " + colorB);
        }
        return new ScreenFlashHolder(duration, intensity, colorR, colorG, colorB);
    }
}
