package com.pseudonova.adminzapper.interfaces;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public interface ILocationHistoryService {

    void setLastLocation(Player player, Location location);
    Location getLastLocation(Player player);
    void removeLastLocation(Player player);

}
