package dev.iseal.ExtraKryoCodecs.Codecs.Lodestone;

import com.esotericsoftware.kryo.kryo5.Kryo;
import com.esotericsoftware.kryo.kryo5.Serializer;
import com.esotericsoftware.kryo.kryo5.io.Input;
import com.esotericsoftware.kryo.kryo5.io.Output;
import dev.iseal.ExtraKryoCodecs.Enums.Lodestone.ParticleEffect;
import dev.iseal.ExtraKryoCodecs.Holders.WorldParticleBuilderHolder;
import team.lodestar.lodestone.systems.particle.SimpleParticleOptions;
import team.lodestar.lodestone.systems.particle.data.GenericParticleData;
import team.lodestar.lodestone.systems.particle.data.color.ColorParticleData;
import team.lodestar.lodestone.systems.particle.data.spin.SpinParticleData;

import static dev.iseal.ExtraKryoCodecs.ExtraKryoCodecs.debug;

public class WorldParticleBuilderHolderSerializer extends Serializer<WorldParticleBuilderHolder> {
    public WorldParticleBuilderHolderSerializer() {
        super(false, true);
    }

    @Override
    public void write(Kryo kryo, Output output, WorldParticleBuilderHolder worldParticleBuilderHolder) {
        if (debug) {
            System.out.println("Serializing WorldParticleBuilderHolder:");
            System.out.println("Type: " + worldParticleBuilderHolder.getType());
            System.out.println("NoClip: " + worldParticleBuilderHolder.isNoClip());
            System.out.println("ForcedSpawn: " + worldParticleBuilderHolder.isForcedSpawn());
            System.out.println("ShouldCull: " + worldParticleBuilderHolder.isShouldCull());
            System.out.println("XLocation: " + worldParticleBuilderHolder.getXLocation());
            System.out.println("YLocation: " + worldParticleBuilderHolder.getYLocation());
            System.out.println("ZLocation: " + worldParticleBuilderHolder.getZLocation());
            System.out.println("MaxXSpeed: " + worldParticleBuilderHolder.getMaxXSpeed());
            System.out.println("MaxYSpeed: " + worldParticleBuilderHolder.getMaxYSpeed());
            System.out.println("MaxZSpeed: " + worldParticleBuilderHolder.getMaxZSpeed());
            System.out.println("XMotion: " + worldParticleBuilderHolder.getXMotion());
            System.out.println("YMotion: " + worldParticleBuilderHolder.getYMotion());
            System.out.println("ZMotion: " + worldParticleBuilderHolder.getZMotion());
            System.out.println("MaxXOffset: " + worldParticleBuilderHolder.getMaxXOffset());
            System.out.println("MaxYOffset: " + worldParticleBuilderHolder.getMaxYOffset());
            System.out.println("MaxZOffset: " + worldParticleBuilderHolder.getMaxZOffset());
            System.out.println("GravityStrength: " + worldParticleBuilderHolder.getGravityStrength());
            System.out.println("FrictionStrength: " + worldParticleBuilderHolder.getFrictionStrength());
            System.out.println("Lifetime: " + worldParticleBuilderHolder.getLifetime());
            System.out.println("LifeDelay: " + worldParticleBuilderHolder.getLifeDelay());
            System.out.println("ParticleEffect: " + worldParticleBuilderHolder.getParticleEffect().ordinal());
            System.out.println("DiscardFunctionType: " + worldParticleBuilderHolder.getDiscardFunctionType().ordinal());
            System.out.println("ColorData: " + worldParticleBuilderHolder.getColorData());
            System.out.println("ScaleData: " + worldParticleBuilderHolder.getScaleData());
            System.out.println("TransparencyData: " + worldParticleBuilderHolder.getTransparencyData());
            System.out.println("SpinData: " + worldParticleBuilderHolder.getSpinData());
        }

        output.writeInt(worldParticleBuilderHolder.getType());
        output.writeBoolean(worldParticleBuilderHolder.isNoClip());
        output.writeBoolean(worldParticleBuilderHolder.isForcedSpawn());
        output.writeBoolean(worldParticleBuilderHolder.isShouldCull());
        output.writeDouble(worldParticleBuilderHolder.getXLocation());
        output.writeDouble(worldParticleBuilderHolder.getYLocation());
        output.writeDouble(worldParticleBuilderHolder.getZLocation());
        output.writeDouble(worldParticleBuilderHolder.getMaxXSpeed());
        output.writeDouble(worldParticleBuilderHolder.getMaxYSpeed());
        output.writeDouble(worldParticleBuilderHolder.getMaxZSpeed());
        output.writeDouble(worldParticleBuilderHolder.getXMotion());
        output.writeDouble(worldParticleBuilderHolder.getYMotion());
        output.writeDouble(worldParticleBuilderHolder.getZMotion());
        output.writeDouble(worldParticleBuilderHolder.getMaxXOffset());
        output.writeDouble(worldParticleBuilderHolder.getMaxYOffset());
        output.writeDouble(worldParticleBuilderHolder.getMaxZOffset());
        output.writeFloat(worldParticleBuilderHolder.getGravityStrength());
        output.writeFloat(worldParticleBuilderHolder.getFrictionStrength());
        output.writeInt(worldParticleBuilderHolder.getLifetime());
        output.writeInt(worldParticleBuilderHolder.getLifeDelay());
        output.writeInt(worldParticleBuilderHolder.getParticleEffect().ordinal());
        output.writeInt(worldParticleBuilderHolder.getDiscardFunctionType().ordinal());
        kryo.writeObject(output, worldParticleBuilderHolder.getColorData());
        kryo.writeObject(output, worldParticleBuilderHolder.getScaleData());
        kryo.writeObject(output, worldParticleBuilderHolder.getTransparencyData());
        kryo.writeObject(output, worldParticleBuilderHolder.getSpinData());
    }

    @Override
    public WorldParticleBuilderHolder read(Kryo kryo, Input input, Class<? extends WorldParticleBuilderHolder> aClass) {
        int id = input.readInt();
        WorldParticleBuilderHolder holder = new WorldParticleBuilderHolder(id);
        boolean noClip = input.readBoolean();
        boolean forcedSpawn = input.readBoolean();
        boolean shouldCull = input.readBoolean();
        double xLocation = input.readDouble();
        double yLocation = input.readDouble();
        double zLocation = input.readDouble();
        double maxXSpeed = input.readDouble();
        double maxYSpeed = input.readDouble();
        double maxZSpeed = input.readDouble();
        double xMotion = input.readDouble();
        double yMotion = input.readDouble();
        double zMotion = input.readDouble();
        double maxXOffset = input.readDouble();
        double maxYOffset = input.readDouble();
        double maxZOffset = input.readDouble();
        float gravityStrength = input.readFloat();
        float frictionStrength = input.readFloat();
        int lifetime = input.readInt();
        int lifeDelay = input.readInt();
        int particleEffectOrdinal = input.readInt();
        int discardFunctionTypeOrdinal = input.readInt();
        ColorParticleData colorData = kryo.readObject(input, ColorParticleData.class);
        GenericParticleData scaleData = kryo.readObject(input, GenericParticleData.class);
        GenericParticleData transparencyData = kryo.readObject(input, GenericParticleData.class);
        SpinParticleData spinData = kryo.readObject(input, SpinParticleData.class);

        if (debug) {
            System.out.println("Deserializing WorldParticleBuilderHolder:");
            System.out.println("Type: " + id);
            System.out.println("NoClip: " + noClip);
            System.out.println("ForcedSpawn: " + forcedSpawn);
            System.out.println("ShouldCull: " + shouldCull);
            System.out.println("XLocation: " + xLocation);
            System.out.println("YLocation: " + yLocation);
            System.out.println("ZLocation: " + zLocation);
            System.out.println("MaxXSpeed: " + maxXSpeed);
            System.out.println("MaxYSpeed: " + maxYSpeed);
            System.out.println("MaxZSpeed: " + maxZSpeed);
            System.out.println("XMotion: " + xMotion);
            System.out.println("YMotion: " + yMotion);
            System.out.println("ZMotion: " + zMotion);
            System.out.println("MaxXOffset: " + maxXOffset);
            System.out.println("MaxYOffset: " + maxYOffset);
            System.out.println("MaxZOffset: " + maxZOffset);
            System.out.println("GravityStrength: " + gravityStrength);
            System.out.println("FrictionStrength: " + frictionStrength);
            System.out.println("Lifetime: " + lifetime);
            System.out.println("LifeDelay: " + lifeDelay);
            System.out.println("ParticleEffect: " + particleEffectOrdinal);
            System.out.println("DiscardFunctionType: " + discardFunctionTypeOrdinal);
            System.out.println("ColorData: " + colorData);
            System.out.println("ScaleData: " + scaleData);
            System.out.println("TransparencyData: " + transparencyData);
            System.out.println("SpinData: " + spinData);
        }

        holder.setNoClip(noClip)
                .setForcedSpawn(forcedSpawn)
                .setCull(shouldCull)
                .setLocation(xLocation, yLocation, zLocation)
                .setRandomMotion(maxXSpeed, maxYSpeed, maxZSpeed)
                .setMotion(xMotion, yMotion, zMotion)
                .setRandomOffset(maxXOffset, maxYOffset, maxZOffset)
                .setGravityStrength(gravityStrength)
                .setFrictionStrength(frictionStrength)
                .setLifetime(lifetime)
                .setLifeDelay(lifeDelay)
                .setParticleEffect(ParticleEffect.values()[particleEffectOrdinal])
                .setDiscardFunction(SimpleParticleOptions.ParticleDiscardFunctionType.values()[discardFunctionTypeOrdinal])
                .setColorData(colorData)
                .setScaleData(scaleData)
                .setTransparencyData(transparencyData)
                .setSpinData(spinData);

        return holder;
    }
}