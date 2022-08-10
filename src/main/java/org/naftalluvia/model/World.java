package org.naftalluvia.model;

import java.util.Iterator;
import java.util.LinkedList;

public class World {
    private final LinkedList<AEntity> listEntities = new LinkedList<>();
    private final LinkedList<EntityPlayer> listPlayers = new LinkedList<>();

    public World() {
        System.out.println("Create World: " + this);
    }

    public void tick() {
        this.updateEntities();
        this.updatePlayers();
    }

    public void spawnEntity(AEntity entity) {
        if (entity != null) {
            this.listEntities.add(entity);
            if (entity instanceof EntityPlayer) {
                this.listPlayers.add((EntityPlayer) entity);
            }
            entity.setSpawned();
        }
    }

    public void updateEntities() {
        for (Iterator<AEntity> iterator = this.listEntities.iterator(); iterator.hasNext(); ) {
            AEntity entity = iterator.next();
            if (entity != null && entity.isSpawned()) {
                if (entity.isDying()) {
                    iterator.remove();
                } else if (!(entity instanceof EntityPlayer)) {
                    entity.onUpdate();
                }
            }
        }
    }

    public void updatePlayers() {
        for (Iterator<EntityPlayer> iterator = this.listPlayers.iterator(); iterator.hasNext(); ) {
            EntityPlayer player = iterator.next();
            if (player != null && player.isSpawned()) {
                if (player.isDying()) {
                    iterator.remove();
                } else {
                    player.onUpdate();
                }
            }
        }
    }
}
