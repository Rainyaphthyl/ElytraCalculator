package org.naftalluvia.mathutil;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public record VecSight(float pitch, float yaw) {
    @Contract(" -> new")
    public @NotNull Vec3d toVec3d() {
        return Vec3d.normalFromPitchYaw(this.pitch, this.yaw);
    }
}
