package com.pseudonova.adminzapper.commands;

import com.pseudonova.adminzapper.abstracts.AbstractCommand;
import com.pseudonova.adminzapper.interfaces.ITeleportService;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReturnAllCommand extends AbstractCommand {


    private final ITeleportService teleportService;

    public ReturnAllCommand(ITeleportService teleportService) {
        super("returnall","adminzapper.returnall", true, "/az returnall");
        this.teleportService = teleportService;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

        Player player = (Player) sender;

        Bukkit.getOnlinePlayers().forEach(target ->{
            teleportService.teleportPlayerToLastLocation(player);
            target.sendMessage(ChatColor.GOLD + "A staffmember returned you to ur previous location");
        });

        player.sendMessage(String.format("Teleported %s all players to you"));
        return true;
    }
}
