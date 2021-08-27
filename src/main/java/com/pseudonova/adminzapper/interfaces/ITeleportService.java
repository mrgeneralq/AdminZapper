package com.pseudonova.adminzapper.interfaces;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public interface ITeleportService {

    void teleportPlayerToPlayer(Player player, Player target);
    void teleportPlayerToLocation(Player player, Location location);
    void teleportPlayerToLastLocation(Player player);

}
