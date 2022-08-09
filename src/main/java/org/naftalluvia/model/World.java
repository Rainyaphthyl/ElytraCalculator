package org.naftalluvia.model;

import java.util.Iterator;
import java.util.LinkedList;

public class World {
    private final LinkedList<AEntity> listEntities = new LinkedList<>();

    public World() {
        System.out.println("Create World: " + this);
    }

    public void tick() {
        this.updateEntities();
    }

    public void addEntity(AEntity entity){
        this.listEntities.add(entity);
    }

    public void updateEntities() {
        for (Iterator<AEntity> iterator = this.listEntities.iterator(); iterator.hasNext(); ) {
            AEntity entity = iterator.next();
            if (entity != null && !(entity instanceof EntityPlayer)) {
                if (entity.isDying()) {
                    iterator.remove();
                } else {
                    entity.onUpdate();
                }
            }
        }
    }
}
