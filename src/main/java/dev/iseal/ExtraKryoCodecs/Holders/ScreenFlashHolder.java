package dev.iseal.ExtraKryoCodecs.Holders;

public class ScreenFlashHolder {
    private final int duration;
    private final float intensity;
    private final int colorR;
    private final int colorG;
    private final int colorB;

    public ScreenFlashHolder(int duration, float intensity, int colorR, int colorG, int colorB) {
        this.duration = duration;
        this.intensity = intensity;
        this.colorR = colorR;
        this.colorG = colorG;
        this.colorB = colorB;
    }

    public int getDuration() {
        return duration;
    }

    public float getIntensity() {
        return intensity;
    }

    public int getColorR() {
        return colorR;
    }

    public int getColorG() {
        return colorG;
    }

    public int getColorB() {
        return colorB;
    }
}
