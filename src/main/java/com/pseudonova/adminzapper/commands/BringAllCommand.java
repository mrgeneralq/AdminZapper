package com.pseudonova.adminzapper.commands;

import com.pseudonova.adminzapper.abstracts.AbstractCommand;
import com.pseudonova.adminzapper.interfaces.ITeleportService;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BringAllCommand extends AbstractCommand {


    private final ITeleportService teleportService;

    public BringAllCommand(ITeleportService teleportService) {
        super("goto","adminzapper.bringall", true, "/az bringall");
        this.teleportService = teleportService;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

        Player player = (Player) sender;

        Bukkit.getOnlinePlayers().forEach(target ->{
            teleportService.teleportPlayerToPlayer(target, player);
            target.sendMessage(ChatColor.GOLD + "A staffmember teleported you to his/her location");
        });

        player.sendMessage(String.format("Teleported %s all players to you"));
        return true;
    }
}
