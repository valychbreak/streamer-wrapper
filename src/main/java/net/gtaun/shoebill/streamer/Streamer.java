package net.gtaun.shoebill.streamer;

import net.gtaun.shoebill.data.Location;
import net.gtaun.shoebill.data.Vector3D;
import net.gtaun.shoebill.object.Player;
import net.gtaun.shoebill.resource.Plugin;
import net.gtaun.util.event.EventManager;


/**
 * Created by marvin on 23.07.15 in project streamer-wrapper.
 * Copyright (c) 2015 Marvin Haschker. All rights reserved.
 */
public class Streamer extends Plugin {

    @Override
    protected void onEnable() throws Throwable {
        EventManager eventManager = getEventManager();
        Functions.registerHandlers(eventManager);
        Callbacks.registerHandlers(eventManager);
    }

    @Override
    protected void onDisable() throws Throwable {
        Functions.unregisterHandlers();
        Callbacks.unregisterHandlers();
    }

    public void update(Player player) {
        Functions.update(player);
    }

    public void updateEx(Player player, Vector3D position) {
        updateEx(player, new Location(position.x, position.y, position.z, -1, -1));
    }

    public void updateEx(Player player, Location location) {
        Functions.updateEx(player, location.x, location.y, location.z, location.worldId, location.interiorId);
    }

}