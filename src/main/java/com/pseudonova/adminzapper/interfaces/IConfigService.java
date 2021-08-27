package com.pseudonova.adminzapper.interfaces;

import org.bukkit.Sound;

public interface IConfigService {

    Sound getTeleportSound();
    boolean playSoundEnabled();
    void reloadConfig();

}
