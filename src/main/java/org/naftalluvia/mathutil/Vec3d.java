package org.naftalluvia.mathutil;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public record Vec3d(double x, double y, double z) {
    @Contract("_, _ -> new")
    public static @NotNull Vec3d normalFromPitchYaw(float pitch, float yaw) {
        float[] v = new float[4];
        float rad0 = -yaw * MathHelper.PI_DIV_DEG - MathHelper.PI;
        float rad1 = -pitch * MathHelper.PI_DIV_DEG;
        v[0] = MathHelper.cos(rad0);
        v[1] = MathHelper.sin(rad0);
        v[2] = -MathHelper.cos(rad1);
        v[3] = MathHelper.sin(rad1);
        return new Vec3d(v[1] * v[2], v[3], v[0] * v[2]);
    }

    public Vec3d add(Vec3d adder) {
        if (adder == null) {
            return this;
        }
        return new Vec3d(this.x + adder.x, this.y + adder.y, this.z + adder.z);
    }

    @Contract(" -> new")
    public @NotNull Vec3d normalize() {
        return this.scale(this.length());
    }

    public double length() {
        return MathHelper.sqrt(this.lengthSquare());
    }

    public double lengthSquare() {
        return this.x * this.x + this.y * this.y + this.z * this.z;
    }

    @Contract("_ -> new")
    public @NotNull Vec3d scale(double rate) {
        return new Vec3d(this.x * rate, this.y * rate, this.z * rate);
    }

    public Vec3d productDot(Vec3d multiplier) {
        if (multiplier == null) {
            return this;
        }
        return new Vec3d(this.x * multiplier.x, this.y * multiplier.y, this.z * multiplier.z);
    }

    public Vec3d productCross(Vec3d multiplier) {
        if (multiplier == null) {
            return this;
        }
        return new Vec3d(this.x * multiplier.x, this.y * multiplier.y, this.z * multiplier.z);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Vec3d) {
            if (obj == this) {
                return true;
            } else {
                return Double.compare(this.x, ((Vec3d) obj).x) == 0 && Double.compare(this.y, ((Vec3d) obj).y) == 0 && Double.compare(this.z, ((Vec3d) obj).z) == 0;
            }
        } else {
            return false;
        }
    }

    @Contract(pure = true)
    @Override
    public @NotNull String toString() {
        return "[" + this.x + ", " + this.y + ", " + this.z + "]";
    }

}
