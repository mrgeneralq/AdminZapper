package com.pseudonova.adminzapper.services;

import com.pseudonova.adminzapper.interfaces.IConfigService;
import com.pseudonova.adminzapper.interfaces.ISoundService;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.List;

public class SoundService implements ISoundService {

    private final IConfigService configService;

    public SoundService(IConfigService configService) {
        this.configService = configService;
    }

    @Override
    public void playTeleportSound(Player player) {
        player.playSound(player.getLocation(),this.configService.getTeleportSound(),1,1);
    }

    @Override
    public void playTeleportSound(List<Player> playerList) {
        playerList.forEach(this::playTeleportSound);
    }

    @Override
    public void playTeleportSound(Location location) {
        location.getWorld().playSound(location ,this.configService.getTeleportSound(), 1,1);
    }
}
