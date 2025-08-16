package dev.iseal.ExtraKryoCodecs.Codecs.AnalyticsAPI.Performance;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import dev.iseal.ExtraKryoCodecs.Holders.AnalyticsAPI.Performance.PerfManagerDurations;

import java.util.Map;

public class PerfManagerDurationsSerializer extends Serializer<PerfManagerDurations> {
    @Override
    public void write(Kryo kryo, Output output, PerfManagerDurations object) {
        Map<String, Double> durations = object.durations();
        output.writeInt(durations.size(), true); // Write the size of the map
        for (Map.Entry<String, Double> entry : durations.entrySet()) {
            output.writeString(entry.getKey()); // Write the key
            output.writeDouble(entry.getValue()); // Write the value
        }
    }

    @Override
    public PerfManagerDurations read(Kryo kryo, Input input, Class<? extends PerfManagerDurations> type) {
        int size = input.readInt(true); // Read the size of the map
        Map<String, Double> durations = new java.util.HashMap<>(size);
        for (int i = 0; i < size; i++) {
            String key = input.readString(); // Read the key
            Double value = input.readDouble(); // Read the value
            durations.put(key, value);
        }
        return new PerfManagerDurations(durations); // Return a new instance of PerfManagerDurations
    }
}
