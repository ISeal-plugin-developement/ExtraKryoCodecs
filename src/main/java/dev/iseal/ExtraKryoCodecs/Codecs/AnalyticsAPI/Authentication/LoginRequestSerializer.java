package dev.iseal.ExtraKryoCodecs.Codecs.AnalyticsAPI.Authentication;

import com.esotericsoftware.kryo.kryo5.Kryo;
import com.esotericsoftware.kryo.kryo5.Serializer;
import com.esotericsoftware.kryo.kryo5.io.Input;
import com.esotericsoftware.kryo.kryo5.io.Output;
import dev.iseal.ExtraKryoCodecs.Holders.AnalyticsAPI.Authorisation.LoginRequest;

public class LoginRequestSerializer extends Serializer<LoginRequest> {
    @Override
    public void write(Kryo kryo, Output output, LoginRequest object) {
        output.writeString(object.username());
        output.writeString(object.password());
    }

    @Override
    public LoginRequest read(Kryo kryo, Input input, Class<? extends LoginRequest> type) {
        String username = input.readString();
        String password = input.readString();
        return new LoginRequest(username, password);
    }
}
