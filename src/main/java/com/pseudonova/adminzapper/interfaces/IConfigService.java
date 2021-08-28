package com.pseudonova.adminzapper.interfaces;

import org.bukkit.Sound;

public interface IConfigService {

    Sound getTeleportSound();
    boolean playSoundEnabled();
    void reloadConfig();

    String getPrefix();



    //messages
    String getConfigReloadedMessage();
    String getNoPermissionMessage();
    String getOnlyPlayersMessage();
    String getCmdNotExistMessage();
}
