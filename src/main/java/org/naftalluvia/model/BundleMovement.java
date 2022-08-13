package org.naftalluvia.model;

import org.jetbrains.annotations.NotNull;
import org.naftalluvia.mathutil.Vec3d;

import java.util.Objects;

/**
 * A bundle describing the movement of a player, not including pitch or yaw.
 *
 * @param position Vec3d
 * @param momentum Vec3d
 */
public record BundleMovement(Vec3d position, Vec3d momentum) implements Comparable<BundleMovement> {
    public BundleMovement(double posX, double posY, double posZ, double motionX, double motionY, double motionZ) {
        this(new Vec3d(posX, posY, posZ), new Vec3d(motionX, motionY, motionZ));
    }

    @Override
    public int compareTo(@NotNull BundleMovement o) {
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof BundleMovement) {
            return Objects.equals(((BundleMovement) obj).momentum, this.momentum) && Objects.equals(((BundleMovement) obj).position, this.position);
        } else {
            return false;
        }
    }
}
