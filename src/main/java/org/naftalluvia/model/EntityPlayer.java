package org.naftalluvia.model;

import org.naftalluvia.mathutil.MathHelper;
import org.naftalluvia.mathutil.Vec3d;
import org.naftalluvia.mathutil.VecSight;

public class EntityPlayer extends AEntity {
    private static final double GRAVITY = 0.08;
    private static final double RESISTANCE_HORIZON = 0.9900000095367432;
    private static final double RESISTANCE_VERTICAL = 0.9800000190734863;
    private float pitch, yaw;

    public EntityPlayer(World world, Vec3d position, VecSight rotation, Vec3d momentum) {
        super(world);
        if (position != null) {
            this.posX = position.x();
            this.posY = position.y();
            this.posZ = position.z();
        }
        if (rotation != null) {
            this.pitch = rotation.pitch();
            this.yaw = rotation.yaw();
        }
        if (momentum != null) {
            this.motionX = momentum.x();
            this.motionY = momentum.y();
            this.motionZ = momentum.z();
        }
        world.addPlayer(this);
    }

    public Vec3d getPosition() {
        return new Vec3d(this.posX, this.posY, this.posZ);
    }

    public Vec3d getVecSight() {
        return Vec3d.normalFromPitchYaw(this.pitch, this.yaw);
    }

    public Vec3d getMomentum() {
        return new Vec3d(this.motionX, this.motionY, this.motionZ);
    }

    public void elytraGlide() {
        Vec3d vecSight = this.getVecSight();
        float pitchRad = this.pitch * MathHelper.PI_DIV_DEG;
        double sightHorizon = Math.sqrt(vecSight.x() * vecSight.x() + vecSight.z() * vecSight.z());
        double motionHorizon = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
        double lengthVecSight = vecSight.length();
        float rateHorizon = MathHelper.cos(pitchRad);
        rateHorizon = (float) ((double) rateHorizon * (double) rateHorizon * Math.min(1.0, lengthVecSight / 0.4));
        // gravity & buoyancy
        this.motionY += -GRAVITY + (double) rateHorizon * 0.06;

        // gliding force
        if (this.motionY < 0.0 && sightHorizon > 0.0) {
            double accGliding = this.motionY * -0.1 * (double) rateHorizon;
            this.motionY += accGliding;
            this.motionX += vecSight.x() * accGliding / sightHorizon;
            this.motionZ += vecSight.z() * accGliding / sightHorizon;
        }

        // lifting force
        if (pitchRad < 0.0F) {
            double rateLift = motionHorizon * (double) (-MathHelper.sin(pitchRad)) * 0.04;
            this.motionY += rateLift * 3.2;
            this.motionX -= vecSight.x() * rateLift / sightHorizon;
            this.motionZ -= vecSight.z() * rateLift / sightHorizon;
        }

        // orientation
        if (sightHorizon > 0.0) {
            this.motionX += (vecSight.x() / sightHorizon * motionHorizon - this.motionX) * 0.1;
            this.motionZ += (vecSight.z() / sightHorizon * motionHorizon - this.motionZ) * 0.1;
        }

        // resistance
        this.motionX *= RESISTANCE_HORIZON;
        this.motionY *= RESISTANCE_VERTICAL;
        this.motionZ *= RESISTANCE_HORIZON;

        // This process ignores a calculation of [(double) bounding box average and the collision check].
        // move the entity
        this.posX += this.motionX;
        this.posY += this.motionY;
        this.posZ += this.motionZ;

    }

    public void launchFirework(int level) {
        this.world.addEntity(new EntityFirework(this.world, this.getPosition(), level, this));
    }

    public void onUpdate() {
        if (Math.abs(this.motionX) < 0.003) {
            this.motionX = 0.0;
        }
        if (Math.abs(this.motionY) < 0.003) {
            this.motionY = 0.0;
        }
        if (Math.abs(this.motionZ) < 0.003) {
            this.motionZ = 0.0;
        }
        this.elytraGlide();
    }
}
