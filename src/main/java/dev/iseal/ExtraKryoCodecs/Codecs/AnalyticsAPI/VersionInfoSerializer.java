package dev.iseal.ExtraKryoCodecs.Codecs.AnalyticsAPI;

import com.esotericsoftware.kryo.kryo5.Kryo;
import com.esotericsoftware.kryo.kryo5.Serializer;
import com.esotericsoftware.kryo.kryo5.io.Input;
import com.esotericsoftware.kryo.kryo5.io.Output;
import dev.iseal.ExtraKryoCodecs.Holders.AnalyticsAPI.PluginVersionInfo;

public class VersionInfoSerializer extends Serializer<PluginVersionInfo> {
    @Override
    public void write(Kryo kryo, Output output, PluginVersionInfo object) {
        output.writeString(object.pluginVersion());
        output.writeString(object.serverVersion());
        output.writeString(object.serverSoftware());
        output.writeString(object.serverJavaVersion());
    }

    @Override
    public PluginVersionInfo read(Kryo kryo, Input input, Class<? extends PluginVersionInfo> type) {
        String pluginVersion = input.readString();
        String serverVersion = input.readString();
        String serverSoftware = input.readString();
        String serverJavaVersion = input.readString();
        return new PluginVersionInfo(pluginVersion, serverVersion, serverSoftware, serverJavaVersion);
    }
}
