package com.pseudonova.adminzapper.interfaces;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public interface ICommand {
    String getName();
    String getPermission();
    String getUsage();
    boolean isPlayersOnly();
    boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args);
}
