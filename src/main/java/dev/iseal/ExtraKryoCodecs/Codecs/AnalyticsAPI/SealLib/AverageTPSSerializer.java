package dev.iseal.ExtraKryoCodecs.Codecs.AnalyticsAPI.SealLib;

import com.esotericsoftware.kryo.kryo5.Kryo;
import com.esotericsoftware.kryo.kryo5.Serializer;
import com.esotericsoftware.kryo.kryo5.io.Input;
import com.esotericsoftware.kryo.kryo5.io.Output;
import dev.iseal.ExtraKryoCodecs.Holders.AnalyticsAPI.SealLib.AverageTPS;

public class AverageTPSSerializer extends Serializer<AverageTPS> {
    @Override
    public void write(Kryo kryo, Output output, AverageTPS object) {
        output.writeInt(object.TPS());
    }

    @Override
    public AverageTPS read(Kryo kryo, Input input, Class<? extends AverageTPS> type) {
        int tps = input.readInt();
        return new AverageTPS(tps);
    }
}
