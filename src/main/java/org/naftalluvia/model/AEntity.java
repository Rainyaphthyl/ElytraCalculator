package org.naftalluvia.model;

public abstract class AEntity {
    protected World world;
    protected double posX, posY, posZ;
    protected double motionX, motionY, motionZ;
    private boolean dying;
    private boolean spawned;

    public AEntity(World world) {
        this.world = world;
        this.dying = false;
        this.spawned = false;
    }

    public boolean isDying() {
        return this.dying;
    }

    public void setDying() {
        this.dying = true;
        System.out.printf("Fireworks stop. %s\n", this);
    }

    public abstract void onUpdate();

    public boolean isSpawned() {
        return this.spawned;
    }

    public void setSpawned() {
        this.spawned = true;
    }
}
