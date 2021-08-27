package com.pseudonova.adminzapper.services;

import com.pseudonova.adminzapper.interfaces.ILocationHistoryService;
import com.pseudonova.adminzapper.repositories.LocationHistoryRepository;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class LocationHistoryService implements ILocationHistoryService {

    private final LocationHistoryRepository locationHistoryRepository;

    public LocationHistoryService(LocationHistoryRepository locationHistoryRepository) {
        this.locationHistoryRepository = locationHistoryRepository;
    }


    @Override
    public void setLastLocation(Player player, Location location) {

    }

    @Override
    public Location getLastLocation(Player player) {
        return null;
    }

    @Override
    public void removeLastLocation(Player player) {

    }
}
