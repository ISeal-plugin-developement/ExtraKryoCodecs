package dev.iseal.ExtraKryoCodecs.Holders.Effekts;

import dev.iseal.ExtraKryoCodecs.Enums.Effekts.Lodestone.ParticleEffect;
import team.lodestar.lodestone.systems.particle.SimpleParticleOptions;
import team.lodestar.lodestone.systems.particle.data.GenericParticleData;
import team.lodestar.lodestone.systems.particle.data.color.ColorParticleData;
import team.lodestar.lodestone.systems.particle.data.spin.SpinParticleData;

import java.util.Arrays;
import java.util.BitSet;

public class  WorldParticleBuilderHolder {

    private final int type;
    private boolean noClip = false;
    private boolean forcedSpawn = false;
    private boolean shouldCull = false;
    private double xLocation = 1;
    private double yLocation = 1;
    private double zLocation = 1;
    private double maxXSpeed = 1;
    private double maxYSpeed = 1;
    private double maxZSpeed = 1;
    private double xMotion = 1;
    private double yMotion = 1;
    private double zMotion = 1;
    private double maxXOffset = 1;
    private double maxYOffset = 1;
    private double maxZOffset = 1;

    private double startingXLocation = 1;
    private double startingYLocation = 1;
    private double startingZLocation = 1;
    private double endingXLocation = 1;
    private double endingYLocation = 1;
    private double endingZLocation = 1;

    private ColorParticleData colorData = ColorParticleData.create(0, 0, 0).build();
    private GenericParticleData scaleData = GenericParticleData.create(1, 0).build();
    private GenericParticleData transparencyData = GenericParticleData.create(1, 0).build();
    private SpinParticleData spinData = SpinParticleData.create(3).build();
    private float gravityStrength = 1;
    private float frictionStrength = 1;
    private int lifetime = 20;
    private int lifeDelay = 2;
    private SimpleParticleOptions.ParticleDiscardFunctionType discardFunctionType = SimpleParticleOptions.ParticleDiscardFunctionType.NONE;
    private ParticleEffect particleEffect = ParticleEffect.SPAWN;
    private int repeatCount = 1;
    private int[] directions = new int[6];

    public WorldParticleBuilderHolder(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public WorldParticleBuilderHolder enableNoClip() {
        setNoClip(true);
        return this;
    }

    public WorldParticleBuilderHolder disableNoClip() {
        setNoClip(false);
        return this;
    }

    public WorldParticleBuilderHolder setNoClip(boolean noClip) {
        this.noClip = noClip;
        return this;
    }

    public WorldParticleBuilderHolder enableForcedSpawn() {
        return setForcedSpawn(true);
    }

    public WorldParticleBuilderHolder disableForcedSpawn() {
        return setForcedSpawn(false);
    }

    public WorldParticleBuilderHolder setForcedSpawn(boolean forcedSpawn) {
        this.forcedSpawn = forcedSpawn;
        return this;
    }

    public WorldParticleBuilderHolder enableCull() {
        return setCull(true);
    }

    public WorldParticleBuilderHolder disableCull() {
        return setCull(false);
    }

    public WorldParticleBuilderHolder setCull(boolean cull) {
        this.shouldCull = cull;
        return this;
    }

    public WorldParticleBuilderHolder setRandomMotion(double maxSpeed) {
        return setRandomMotion(maxSpeed, maxSpeed, maxSpeed);
    }

    public WorldParticleBuilderHolder setRandomMotion(double maxHSpeed, double maxVSpeed) {
        return setRandomMotion(maxHSpeed, maxVSpeed, maxHSpeed);
    }

    public WorldParticleBuilderHolder setRandomMotion(double maxXSpeed, double maxYSpeed, double maxZSpeed) {
        this.maxXSpeed = maxXSpeed;
        this.maxYSpeed = maxYSpeed;
        this.maxZSpeed = maxZSpeed;
        return this;
    }

    public WorldParticleBuilderHolder setMotion(double xMotion, double yMotion, double zMotion) {
        this.xMotion = xMotion;
        this.yMotion = yMotion;
        this.zMotion = zMotion;
        return this;
    }

    public WorldParticleBuilderHolder addMotion(double xMotion, double yMotion, double zMotion) {
        this.xMotion += xMotion;
        this.yMotion += yMotion;
        this.zMotion += zMotion;
        return this;
    }

    public WorldParticleBuilderHolder setRandomOffset(double maxOffset) {
        return setRandomOffset(maxOffset, maxOffset, maxOffset);
    }

    public WorldParticleBuilderHolder setRandomOffset(double maxXOffset, double maxYOffset) {
        return setRandomOffset(maxXOffset, maxYOffset, maxYOffset);
    }

    public WorldParticleBuilderHolder setRandomOffset(double maxXOffset, double maxYOffset, double maxZOffset) {
        this.maxXOffset = maxXOffset;
        this.maxYOffset = maxYOffset;
        this.maxZOffset = maxZOffset;
        return this;
    }

    public WorldParticleBuilderHolder setColorData(ColorParticleData colorData) {
        this.colorData = colorData;
        return this;
    }

    public WorldParticleBuilderHolder setScaleData(GenericParticleData scaleData) {
        this.scaleData = scaleData;
        return this;
    }

    public WorldParticleBuilderHolder setTransparencyData(GenericParticleData transparencyData) {
        this.transparencyData = transparencyData;
        return this;
    }

    public WorldParticleBuilderHolder setSpinData(SpinParticleData spinData) {
        this.spinData = spinData;
        return this;
    }

    public WorldParticleBuilderHolder setGravityStrength(float gravityStrength) {
        this.gravityStrength = gravityStrength;
        return this;
    }

    public WorldParticleBuilderHolder setFrictionStrength(float frictionStrength) {
        this.frictionStrength = frictionStrength;
        return this;
    }

    public WorldParticleBuilderHolder setLifetime(int lifetime) {
        this.lifetime = lifetime;
        return this;
    }

    public WorldParticleBuilderHolder setLifeDelay(int lifeDelay) {
        this.lifeDelay = lifeDelay;
        return this;
    }

    public WorldParticleBuilderHolder setDiscardFunction(SimpleParticleOptions.ParticleDiscardFunctionType discardFunctionType) {
        this.discardFunctionType = discardFunctionType;
        return this;
    }

    public WorldParticleBuilderHolder setParticleEffect(ParticleEffect particleEffect) {
        this.particleEffect = particleEffect;
        return this;
    }

    public WorldParticleBuilderHolder setLocation(double x, double y, double z) {
        this.xLocation = x;
        this.yLocation = y;
        this.zLocation = z;
        return this;
    }

    public WorldParticleBuilderHolder setStartingLocation(double x, double y, double z) {
        this.startingXLocation = x;
        this.startingYLocation = y;
        this.startingZLocation = z;
        return this;
    }

    public WorldParticleBuilderHolder setEndingLocation(double x, double y, double z) {
        this.endingXLocation = x;
        this.endingYLocation = y;
        this.endingZLocation = z;
        return this;
    }

    public WorldParticleBuilderHolder setRepeatCount(int repeatCount) {
        this.repeatCount = repeatCount;
        return this;
    }

    public WorldParticleBuilderHolder addDirections(int... newDirections) {
        BitSet directionSet = new BitSet(6);
        for (int direction : directions) {
            directionSet.set(direction);
        }

        for (int newDirection : newDirections) {
            if (newDirection < 0 || newDirection > 5) {
                throw new IllegalArgumentException("Directions must be between 0 and 5");
            }
            directionSet.set(newDirection);
        }

        directions = directionSet.stream().toArray();
        return this;
    }

    public WorldParticleBuilderHolder setDirections(int... directions) {
        // remove anything not between 0 and 5
        if (!Arrays.stream(directions).allMatch(i -> i >= 0 && i <= 5))
            throw new IllegalArgumentException("Directions must be between 0 and 5");
        this.directions = directions;
        return this;
    }

    // getters

    public boolean isNoClip() {
        return noClip;
    }

    public boolean isForcedSpawn() {
        return forcedSpawn;
    }

    public boolean isShouldCull() {
        return shouldCull;
    }

    public double getMaxXSpeed() {
        return maxXSpeed;
    }

    public double getMaxYSpeed() {
        return maxYSpeed;
    }

    public double getMaxZSpeed() {
        return maxZSpeed;
    }

    public double getXMotion() {
        return xMotion;
    }

    public double getYMotion() {
        return yMotion;
    }

    public double getZMotion() {
        return zMotion;
    }

    public double getMaxXOffset() {
        return maxXOffset;
    }

    public double getMaxYOffset() {
        return maxYOffset;
    }

    public double getMaxZOffset() {
        return maxZOffset;
    }

    public ColorParticleData getColorData() {
        return colorData;
    }

    public GenericParticleData getScaleData() {
        return scaleData;
    }

    public GenericParticleData getTransparencyData() {
        return transparencyData;
    }

    public SpinParticleData getSpinData() {
        return spinData;
    }

    public float getGravityStrength() {
        return gravityStrength;
    }

    public float getFrictionStrength() {
        return frictionStrength;
    }

    public int getLifetime() {
        return lifetime;
    }

    public int getLifeDelay() {
        return lifeDelay;
    }

    public SimpleParticleOptions.ParticleDiscardFunctionType getDiscardFunctionType() {
        return discardFunctionType;
    }

    public ParticleEffect getParticleEffect() {
        return particleEffect;
    }

    public double getXLocation() {
        return xLocation;
    }

    public double getYLocation() {
        return yLocation;
    }

    public double getZLocation() {
        return zLocation;
    }

    public double getxLocation() {
        return xLocation;
    }

    public double getyLocation() {
        return yLocation;
    }

    public double getzLocation() {
        return zLocation;
    }

    public double getxMotion() {
        return xMotion;
    }

    public double getyMotion() {
        return yMotion;
    }

    public double getzMotion() {
        return zMotion;
    }

    public double getStartingXLocation() {
        return startingXLocation;
    }

    public double getStartingYLocation() {
        return startingYLocation;
    }

    public double getStartingZLocation() {
        return startingZLocation;
    }

    public double getEndingXLocation() {
        return endingXLocation;
    }

    public double getEndingYLocation() {
        return endingYLocation;
    }

    public double getEndingZLocation() {
        return endingZLocation;
    }

    public int getRepeatCount() {
        return repeatCount;
    }

    public int[] getDirections() {
        return directions;
    }
}
