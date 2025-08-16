package dev.iseal.ExtraKryoCodecs.Codecs.AnalyticsAPI.PowerGems;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import dev.iseal.ExtraKryoCodecs.Holders.AnalyticsAPI.PowerGems.PGGemUsagesHourly;
import dev.iseal.ExtraKryoCodecs.Utils.Pair;

import java.util.HashMap;
import java.util.List;

public class GemUsagesHourlySerializer extends Serializer<PGGemUsagesHourly> {
    @Override
    public void write(Kryo kryo, Output output, PGGemUsagesHourly object) {
        HashMap<String, List<Pair<String, Integer>>> usages = object.gemUsagesByHour();
        output.writeInt(usages.size());
        for (var entry : usages.entrySet()) {
            output.writeString(entry.getKey());
            List<Pair<String, Integer>> list = entry.getValue();
            output.writeInt(list.size());
            for (Pair<String, Integer> pair : list) {
                output.writeString(pair.getFirst());
                output.writeInt(pair.getSecond());
            }
        }
    }

    @Override
    public PGGemUsagesHourly read(Kryo kryo, Input input, Class<? extends PGGemUsagesHourly> type) {
        int mapSize = input.readInt();
        HashMap<String, List<Pair<String, Integer>>> usages = new HashMap<>(mapSize);
        for (int i = 0; i < mapSize; i++) {
            String key = input.readString();
            int listSize = input.readInt();
            List<Pair<String, Integer>> list = new java.util.ArrayList<>(listSize);
            for (int j = 0; j < listSize; j++) {
                String first = input.readString();
                int second = input.readInt();
                list.add(new Pair<>(first, second));
            }
            usages.put(key, list);
        }
        return new PGGemUsagesHourly(usages);
    }
}
