package org.naftalluvia.model;

import org.naftalluvia.mathutil.Vec3d;

/**
 * A bundle describing the movement of a player, not including pitch or yaw.
 *
 * @param position Vec3d
 * @param momentum Vec3d
 */
public record BundleMovement(Vec3d position, Vec3d momentum) {
    public BundleMovement(double posX, double posY, double posZ, double motionX, double motionY, double motionZ) {
        this(new Vec3d(posX, posY, posZ), new Vec3d(motionX, motionY, motionZ));
    }
}
