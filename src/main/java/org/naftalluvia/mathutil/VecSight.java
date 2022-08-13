package org.naftalluvia.mathutil;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

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
            } else if (this.pitch == ((VecSight) obj).pitch && this.yaw == ((VecSight) obj).yaw) {
                return true;
            } else {
                return Objects.equals(this.toVec3d(), ((VecSight) obj).toVec3d());
            }
        } else if (obj instanceof Vec3d) {
            return Objects.equals(this.toVec3d(), obj);
        } else {
            return false;
        }
    }
}
