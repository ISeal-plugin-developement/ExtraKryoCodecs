package dev.iseal.ExtraKryoCodecs.Codecs.AnalyticsAPI.PowerGems;

import com.esotericsoftware.kryo.kryo5.Kryo;
import com.esotericsoftware.kryo.kryo5.Serializer;
import com.esotericsoftware.kryo.kryo5.io.Input;
import com.esotericsoftware.kryo.kryo5.io.Output;
import dev.iseal.ExtraKryoCodecs.Holders.AnalyticsAPI.PowerGems.PGConfigInfo;

import java.util.HashMap;

public class ConfigInfoSerializer extends Serializer<PGConfigInfo> {
    @Override
    public void write(Kryo kryo, Output output, PGConfigInfo object) {
        kryo.writeObject(output, object.configMap());
    }

    @Override
    public PGConfigInfo read(Kryo kryo, Input input, Class<? extends PGConfigInfo> type) {
        return new PGConfigInfo(kryo.readObject(input, HashMap.class));
    }
}
