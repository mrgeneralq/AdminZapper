package com.pseudonova.adminzapper.statics;

import com.pseudonova.adminzapper.interfaces.IConfigService;
import com.pseudonova.adminzapper.interfaces.ILocationHistoryService;
import com.pseudonova.adminzapper.interfaces.ISoundService;
import com.pseudonova.adminzapper.interfaces.ITeleportService;
import com.pseudonova.adminzapper.repositories.LocationHistoryRepository;
import com.pseudonova.adminzapper.services.ConfigService;
import com.pseudonova.adminzapper.services.LocationHistoryService;
import com.pseudonova.adminzapper.services.SoundService;
import com.pseudonova.adminzapper.services.TeleportService;
import org.bukkit.plugin.Plugin;

public class Bootstrapper {

    private static Bootstrapper instance;
    private Plugin plugin;
    private ILocationHistoryService locationHistoryService;
    private  IConfigService configService;
    private  ISoundService soundService;
    private  ITeleportService teleportService;

    private Bootstrapper(){}

    public static Bootstrapper getBootstrapper(){
        if(instance == null)
            instance = new Bootstrapper();
        return instance;
    }

    public void initialize(Plugin plugin){
        this.plugin = plugin;
        this.registerServices();
    }


    private void registerServices(){

        this.locationHistoryService = new LocationHistoryService(new LocationHistoryRepository());
        this.configService = new ConfigService(this.plugin);
        this.soundService = new SoundService(configService);
        this.teleportService = new TeleportService(this.locationHistoryService,this.configService, this.soundService);
    }

    public ILocationHistoryService getLocationHistoryService() {
        return locationHistoryService;
    }

    public IConfigService getConfigService() {
        return configService;
    }

    public ISoundService getSoundService() {
        return soundService;
    }

    public ITeleportService getTeleportService() {
        return teleportService;
    }
}
