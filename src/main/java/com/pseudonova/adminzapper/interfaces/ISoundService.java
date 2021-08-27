package com.pseudonova.adminzapper.interfaces;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.List;

public interface ISoundService {

    void playTeleportSound(Player player);
    void playTeleportSound(List<Player> playerList);
    void playTeleportSound(Location location);

}
