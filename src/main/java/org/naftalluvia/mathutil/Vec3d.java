package org.naftalluvia.mathutil;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public record Vec3d(double x, double y, double z) {
    public Vec3d(double x, double y, double z) {
        this.x = x == -0.0 ? 0.0 : x;
        this.y = y == -0.0 ? 0.0 : y;
        this.z = z == -0.0 ? 0.0 : z;
    }

    public Vec3d add(Vec3d adder) {
        if (adder == null) {
            return null;
        }
        return new Vec3d(this.x() + adder.x(), this.y() + adder.y(), this.z() + adder.z());
    }

    @Contract(pure = true)
    @Override
    public @NotNull String toString() {
        return "[" + this.x() + ", " + this.y() + ", " + this.z() + "]";
    }

}
