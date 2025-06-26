package dev.iseal.ExtraKryoCodecs.Enums.SerializersEnums.AnalyticsAPI;

import com.esotericsoftware.kryo.kryo5.Serializer;
import dev.iseal.ExtraKryoCodecs.Codecs.AnalyticsAPI.Authentication.LoginRequestSerializer;
import dev.iseal.ExtraKryoCodecs.Codecs.AnalyticsAPI.Authentication.RegisterRequestSerializer;
import dev.iseal.ExtraKryoCodecs.Holders.AnalyticsAPI.Authorisation.LoginRequest;
import dev.iseal.ExtraKryoCodecs.Holders.AnalyticsAPI.Authorisation.RegisterRequest;
import dev.iseal.ExtraKryoCodecs.Utils.SerializerEnum;

public enum AuthenticationAnalyticsSerializers implements SerializerEnum {

    LOGIN_REQUEST(1201, LoginRequest.class, new LoginRequestSerializer(), "login"),
    REGISTER_REQUEST(1202, RegisterRequest.class, new RegisterRequestSerializer(), "register_request");

    private final int serializerID;
    private final Class<?> effectClass;
    private final Serializer<?> serializer;
    private final String packetName;

    AuthenticationAnalyticsSerializers(int serializerID, Class<?> serializedClass, Serializer<?> serializer, String packetName) {
        this.serializerID = serializerID;
        this.effectClass = serializedClass;
        this.serializer = serializer;
        this.packetName = packetName;
    }

    @Override
    public int getID() {
        return serializerID;
    }

    @Override
    public Class<?> getEffectClass() {
        return effectClass;
    }

    @Override
    public Serializer<?> getSerializer() {
        return serializer;
    }

    @Override
    public String getPacketName() {
        return packetName;
    }
}
