package dev.iseal.ExtraKryoCodecs.Codecs.AnalyticsAPI;

import com.esotericsoftware.kryo.kryo5.Kryo;
import com.esotericsoftware.kryo.kryo5.Serializer;
import com.esotericsoftware.kryo.kryo5.io.Input;
import com.esotericsoftware.kryo.kryo5.io.Output;
import dev.iseal.ExtraKryoCodecs.Holders.AnalyticsAPI.ProgramVersionInfo;

public class ProgramVersionInfoSerializer extends Serializer<ProgramVersionInfo> {
    @Override
    public void write(Kryo kryo, Output output, ProgramVersionInfo object) {
        output.writeString(object.programVersion());
        output.writeString(object.javaVersion());
        output.writeString(object.osName());
        output.writeString(object.osVersion());
        output.writeString(object.osArch());
    }

    @Override
    public ProgramVersionInfo read(Kryo kryo, Input input, Class<? extends ProgramVersionInfo> type) {
        String programVersion = input.readString();
        String javaVersion = input.readString();
        String osName = input.readString();
        String osVersion = input.readString();
        String osArch = input.readString();

        return new ProgramVersionInfo(programVersion, javaVersion, osName, osVersion, osArch);
    }
}
