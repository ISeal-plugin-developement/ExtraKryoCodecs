package dev.iseal.ExtraKryoCodecs.Codecs.AnalyticsAPI.PowerGems;

import com.esotericsoftware.kryo.kryo5.Kryo;
import com.esotericsoftware.kryo.kryo5.Serializer;
import com.esotericsoftware.kryo.kryo5.io.Input;
import com.esotericsoftware.kryo.kryo5.io.Output;
import dev.iseal.ExtraKryoCodecs.Holders.AnalyticsAPI.PowerGems.PGGeneralConfigInfo;

import java.util.HashMap;

public class PGGeneralConfigInfoSerializer extends Serializer<PGGeneralConfigInfo> {
    @Override
    public void write(Kryo kryo, Output output, PGGeneralConfigInfo object) {
        kryo.writeObject(output, object.configMap());
    }

    @Override
    public PGGeneralConfigInfo read(Kryo kryo, Input input, Class<? extends PGGeneralConfigInfo> type) {
        return new PGGeneralConfigInfo(kryo.readObject(input, HashMap.class));
    }
}
