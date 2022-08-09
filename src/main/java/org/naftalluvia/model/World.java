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

    public void addEntity(AEntity entity) {
        if (entity != null && !(entity instanceof EntityPlayer)) {
            this.listEntities.add(entity);
        }
    }

    public void addPlayer(EntityPlayer player) {
        if (player != null) {
            this.listPlayers.add(player);
        }
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

    public void updatePlayers() {
        for (Iterator<EntityPlayer> iterator = this.listPlayers.iterator(); iterator.hasNext(); ) {
            EntityPlayer player = iterator.next();
            if (player != null) {
                if (player.isDying()) {
                    iterator.remove();
                } else {
                    player.onUpdate();
                }
            }
        }
    }
}
