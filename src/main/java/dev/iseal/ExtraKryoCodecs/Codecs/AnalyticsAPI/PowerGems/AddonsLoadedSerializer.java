package dev.iseal.ExtraKryoCodecs.Codecs.AnalyticsAPI.PowerGems;

import com.esotericsoftware.kryo.kryo5.Kryo;
import com.esotericsoftware.kryo.kryo5.Serializer;
import com.esotericsoftware.kryo.kryo5.io.Input;
import com.esotericsoftware.kryo.kryo5.io.Output;
import dev.iseal.ExtraKryoCodecs.Holders.AnalyticsAPI.PowerGems.PGAddonsLoaded;

public class AddonsLoadedSerializer extends Serializer<PGAddonsLoaded> {
    @Override
    public void write(Kryo kryo, Output output, PGAddonsLoaded object) {
        output.writeInt(object.addons().length);
        for (String addon : object.addons()) {
            output.writeString(addon);
        }
    }

    @Override
    public PGAddonsLoaded read(Kryo kryo, Input input, Class<? extends PGAddonsLoaded> type) {
        int length = input.readInt();
        String[] addons = new String[length];
        for (int i = 0; i < length; i++) {
            addons[i] = input.readString();
        }
        return new PGAddonsLoaded(addons);
    }
}
