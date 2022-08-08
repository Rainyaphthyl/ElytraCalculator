package org.naftalluvia.mathutil;

public class MathHelper {
    public static final float PI_DIV_DEG = 0.017453292F;
    public static final float PI = (float) Math.PI;
    private static final float[] SIN_TABLE = new float[65536];

    static {
        for (int i = 0; i < 65536; ++i) {
            SIN_TABLE[i] = (float) Math.sin((double) i * Math.PI * 2.0D / 65536.0D);
        }
    }

    public static float sin(float variable) {
        return SIN_TABLE[(int) (variable * 10430.378F) & 65535];
    }

    public static float cos(float variable) {
        return SIN_TABLE[(int) (variable * 10430.378F + 16384.0F) & 65535];
    }

    public static float sqrt(double squared) {
        return (float) Math.sqrt(squared);
    }

    public static double roundTo(double value, int depth) {
        double rate = Math.pow(10, depth);
        value *= rate;
        long product = Math.round(value);
        return (double) product / rate;
    }
}
