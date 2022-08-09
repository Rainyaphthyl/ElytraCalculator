package org.naftalluvia.model;

public abstract class AEntity {
    protected World world;
    protected double posX, posY, posZ;
    protected double motionX, motionY, motionZ;
    private boolean dying;

    public AEntity(World world) {
        this.world = world;
        this.dying = false;
    }

    public boolean isDying() {
        return this.dying;
    }

    public void setDying() {
        this.dying = true;
        System.out.printf("Fireworks stop. %s\n", this);
    }

    public void onUpdate() {

    }
}
