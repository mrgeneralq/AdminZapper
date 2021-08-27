package com.pseudonova.adminzapper.services;

import com.pseudonova.adminzapper.interfaces.IConfigService;
import com.pseudonova.adminzapper.interfaces.ILocationHistoryService;
import com.pseudonova.adminzapper.interfaces.ISoundService;
import com.pseudonova.adminzapper.interfaces.ITeleportService;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class TeleportService implements ITeleportService {


    private final ILocationHistoryService locationHistoryService;
    private final IConfigService configService;
    private final ISoundService soundService;


    public TeleportService(ILocationHistoryService locationHistoryService, IConfigService configService, ISoundService soundService) {
        this.locationHistoryService = locationHistoryService;
        this.configService = configService;
        this.soundService = soundService;
    }

    @Override
    public void teleportPlayerToPlayer(Player player, Player target) {

        if(this.configService.playSoundEnabled()){
            this.soundService.playTeleportSound(player);
            this.soundService.playTeleportSound(target);
        }

        this.locationHistoryService.setLastLocation(player, player.getLocation());
        player.teleport(target.getLocation());

    }

    @Override
    public void teleportPlayerToLocation(Player player, Location location) {


        this.locationHistoryService.setLastLocation(player, player.getLocation());
        player.teleport(location);
        playSound(player);


    }

    @Override
    public void teleportPlayerToLastLocation(Player player) {

        Location location = this.locationHistoryService.getLastLocation(player);

        if(location != null)
        player.teleport(location);
        playSound(player);

    }

    private void playSound(Player player){
        if(this.configService.playSoundEnabled()){
            this.soundService.playTeleportSound(player.getLocation());
        }
    }
}
