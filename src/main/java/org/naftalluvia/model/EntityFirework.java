package org.naftalluvia.model;

import org.naftalluvia.mathutil.Vec3d;

import java.util.Random;

public class EntityFirework extends AEntity {
    private final int lifeTime;
    private final EntityPlayer user;
    private int age;

    public EntityFirework(World world, Vec3d position, int level, EntityPlayer user) {
        super(world);
        this.user = user;
        if (position != null) {
            this.posX = position.x();
            this.posY = position.y();
            this.posZ = position.z();
        }
        Random random = new Random();
        this.motionX = random.nextGaussian() * 0.001;
        this.motionZ = random.nextGaussian() * 0.001;
        this.motionY = 0.05;
        this.lifeTime = 10 * (level + 1) + random.nextInt(6) + random.nextInt(7);
        this.age = 0;
        System.out.printf("Firework! lifetime = %d ticks. %s\n", this.lifeTime, this);
    }

    public void onUpdate() {
        Vec3d vecSight = this.user.getVecSight();
        this.user.motionX += vecSight.x() * 0.1 + (vecSight.x() * 1.5 - this.user.motionX) * 0.5;
        this.user.motionY += vecSight.y() * 0.1 + (vecSight.y() * 1.5 - this.user.motionY) * 0.5;
        this.user.motionZ += vecSight.z() * 0.1 + (vecSight.z() * 1.5 - this.user.motionZ) * 0.5;
        this.posX = this.user.posX;
        this.posY = this.user.posY;
        this.posZ = this.user.posZ;
        this.motionX = this.user.motionX;
        this.motionY = this.user.motionY;
        this.motionZ = this.user.motionZ;
        ++this.age;
        if (this.age > this.lifeTime) {
            this.setDying();
        }
    }
}
