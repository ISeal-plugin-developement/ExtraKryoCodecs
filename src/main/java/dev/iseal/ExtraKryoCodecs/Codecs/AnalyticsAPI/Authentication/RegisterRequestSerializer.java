package dev.iseal.ExtraKryoCodecs.Codecs.AnalyticsAPI.Authentication;

import com.esotericsoftware.kryo.kryo5.Kryo;
import com.esotericsoftware.kryo.kryo5.Serializer;
import com.esotericsoftware.kryo.kryo5.io.Input;
import com.esotericsoftware.kryo.kryo5.io.Output;
import dev.iseal.ExtraKryoCodecs.Holders.AnalyticsAPI.Authorisation.RegisterRequest;

public class RegisterRequestSerializer extends Serializer<RegisterRequest> {
    @Override
    public void write(Kryo kryo, Output output, RegisterRequest object) {
        output.writeString(object.username());
        output.writeString(object.password());
        output.writeString(object.email());
        kryo.writeClassAndObject(output, object.requestedScopes());
    }

    @Override
    public RegisterRequest read(Kryo kryo, Input input, Class<? extends RegisterRequest> type) {
        String username = input.readString();
        String password = input.readString();
        String email = input.readString();
        String[] requestedScopes = (String[]) kryo.readClassAndObject(input);

        return new RegisterRequest(username, password, email, requestedScopes);
    }
}
