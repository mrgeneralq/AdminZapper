package com.pseudonova.adminzapper.repositories;

import com.pseudonova.adminzapper.interfaces.IRepository;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class LocationHistoryRepository implements IRepository<Player, Location> {

    private final Map<UUID, Location> playerHistory = new HashMap<>();

    @Override
    public void addOrUpdate(Player player, Location location) {
        this.playerHistory.put(player.getUniqueId(), location);
    }

    @Override
    public void remove(Player player) {
        this.playerHistory.remove(player.getUniqueId());
    }

    @Override
    public Location get(Player player) {
        return this.playerHistory.get(player.getUniqueId());
    }

    @Override
    public boolean exists(Player player) {
        return this.playerHistory.containsKey(player.getUniqueId());
    }
}
