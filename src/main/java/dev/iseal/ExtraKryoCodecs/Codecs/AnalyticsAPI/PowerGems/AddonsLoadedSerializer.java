package dev.iseal.ExtraKryoCodecs.Codecs.AnalyticsAPI.PowerGems;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import dev.iseal.ExtraKryoCodecs.Holders.AnalyticsAPI.PowerGems.PGAddonsLoaded;

import java.util.HashMap;
import java.util.Map;

public class AddonsLoadedSerializer extends Serializer<PGAddonsLoaded> {
    @Override
    public void write(Kryo kryo, Output output, PGAddonsLoaded object) {
        Map<String, String> addons = object.addons();
        output.writeInt(addons.size(), true);
        for (Map.Entry<String, String> entry : addons.entrySet()) {
            output.writeString(entry.getKey());
            output.writeString(entry.getValue());
        }
    }

    @Override
    public PGAddonsLoaded read(Kryo kryo, Input input, Class<? extends PGAddonsLoaded> type) {
        int size = input.readInt(true);
        Map<String, String> addons = new HashMap<>(size);
        for (int i = 0; i < size; i++) {
            String key = input.readString();
            String value = input.readString();
            addons.put(key, value);
        }
        return new PGAddonsLoaded(addons);
    }
}
