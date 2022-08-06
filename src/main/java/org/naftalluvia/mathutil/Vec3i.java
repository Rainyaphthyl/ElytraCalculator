package org.naftalluvia.mathutil;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public record Vec3i(int x, int y, int z) {

    public Vec3i add(Vec3i adder) {
        if (adder == null) {
            return null;
        }
        return new Vec3i(this.x() + adder.x(), this.y() + adder.y(), this.z() + adder.z());
    }

    @Contract(" -> new")
    public @NotNull Vec3d toVec3d() {
        return new Vec3d(this.x(), this.y(), this.z());
    }

    @Contract(pure = true)
    @Override
    public @NotNull String toString() {
        return "[" + this.x() + ", " + this.y() + ", " + this.z() + "]";
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Vec3i) && ((Vec3i) obj).x() == this.x() && ((Vec3i) obj).y() == this.y() && ((Vec3i) obj).z() == this.z();
    }
}
