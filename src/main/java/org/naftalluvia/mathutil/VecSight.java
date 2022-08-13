package org.naftalluvia.mathutil;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public record VecSight(float pitch, float yaw) {
    @Contract(" -> new")
    public @NotNull Vec3d toVec3d() {
        return Vec3d.normalFromPitchYaw(this.pitch, this.yaw);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof VecSight) {
            if (obj == this) {
                return true;
            } else {
                return Float.compare(this.pitch, ((VecSight) obj).pitch) == 0 && Float.compare(this.yaw, ((VecSight) obj).yaw) == 0;
            }
        } else {
            return false;
        }
    }
}
