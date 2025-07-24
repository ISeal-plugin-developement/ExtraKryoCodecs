package dev.iseal.ExtraKryoCodecs.Codecs.AnalyticsAPI;

import com.esotericsoftware.kryo.kryo5.Kryo;
import com.esotericsoftware.kryo.kryo5.Serializer;
import com.esotericsoftware.kryo.kryo5.io.Input;
import com.esotericsoftware.kryo.kryo5.io.Output;
import dev.iseal.ExtraKryoCodecs.Holders.AnalyticsAPI.PluginVersionInfo;

public class PluginVersionInfoSerializer extends Serializer<PluginVersionInfo> {
    @Override
    public void write(Kryo kryo, Output output, PluginVersionInfo object) {
        output.writeString(object.pluginVersion());
        output.writeString(object.serverVersion());
        output.writeString(object.serverSoftware());
        output.writeString(object.serverJavaVersion());
        output.writeString(object.serverOS());
        output.writeString(object.serverOSVersion());
        output.writeString(object.serverArchitecture());
    }

    @Override
    public PluginVersionInfo read(Kryo kryo, Input input, Class<? extends PluginVersionInfo> type) {
        String pluginVersion = input.readString();
        String serverVersion = input.readString();
        String serverSoftware = input.readString();
        String serverJavaVersion = input.readString();
        String serverOS = input.readString();
        String serverOSVersion = input.readString();
        String serverArchitecture = input.readString();
        return new PluginVersionInfo(pluginVersion, serverVersion, serverSoftware, serverJavaVersion,
                                     serverOS, serverOSVersion, serverArchitecture);
    }
}
