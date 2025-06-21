package dev.iseal.ExtraKryoCodecs.Codecs.AnalyticsAPI;

import com.esotericsoftware.kryo.kryo5.Kryo;
import com.esotericsoftware.kryo.kryo5.Serializer;
import com.esotericsoftware.kryo.kryo5.io.Input;
import com.esotericsoftware.kryo.kryo5.io.Output;
import dev.iseal.ExtraKryoCodecs.Holders.AnalyticsAPI.VersionInfo;

public class VersionInfoSerializer extends Serializer<VersionInfo> {
    @Override
    public void write(Kryo kryo, Output output, VersionInfo object) {
        output.writeString(object.pluginVersion());
        output.writeString(object.serverVersion());
        output.writeString(object.serverSoftware());
        output.writeString(object.serverJavaVersion());
    }

    @Override
    public VersionInfo read(Kryo kryo, Input input, Class<? extends VersionInfo> type) {
        String pluginVersion = input.readString();
        String serverVersion = input.readString();
        String serverSoftware = input.readString();
        String serverJavaVersion = input.readString();
        return new VersionInfo(pluginVersion, serverVersion, serverSoftware, serverJavaVersion);
    }
}
