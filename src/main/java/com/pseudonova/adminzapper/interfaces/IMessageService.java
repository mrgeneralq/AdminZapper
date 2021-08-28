package com.pseudonova.adminzapper.interfaces;

import org.bukkit.command.CommandSender;

public interface IMessageService {
    //TODO create methods to send all kind of messages

    void sendConfigReloadedMessage(CommandSender sender);
    void sendNoPermissionMessage(CommandSender sender);
    void sendOnlyPlayersMessage(CommandSender sender);
    void sendCmdNotExistMessage(CommandSender sender);
}
