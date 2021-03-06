package com.pseudonova.adminzapper.services;

import com.pseudonova.adminzapper.interfaces.IConfigService;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.plugin.Plugin;

public class ConfigService implements IConfigService {

    private final Plugin plugin;

    public ConfigService(Plugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public Sound getTeleportSound() {

        String soundPath = "sound.teleport-sound";

        try {
            Sound sound = Sound.valueOf(this.plugin.getConfig().getString(soundPath));
            return sound;
        }catch (Exception ex){

            String warningMessage= String.format("Admin Zapper: Something went wrong parsing sound name '%s'. Using default enderman teleport sound", this.plugin.getConfig().getString(soundPath));
            Bukkit.getLogger().warning(warningMessage);
            return Sound.ENTITY_ENDERMAN_TELEPORT;
        }

    }

    @Override
    public boolean playSoundEnabled() {
        return this.plugin.getConfig().getBoolean("sound.enabled");
    }

    @Override
    public void reloadConfig() {
        this.plugin.reloadConfig();;
    }

}
