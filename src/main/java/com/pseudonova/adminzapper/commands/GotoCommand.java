package com.pseudonova.adminzapper.commands;

import com.pseudonova.adminzapper.abstracts.AbstractCommand;
import com.pseudonova.adminzapper.interfaces.ITeleportService;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GotoCommand extends AbstractCommand {


    private final ITeleportService teleportService;

    public GotoCommand(ITeleportService teleportService) {
        super("goto","adminzapper.goto", true, "go to admin zapper!");
        this.teleportService = teleportService;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

        Player player = (Player) sender;

        if(args.length == 0){
            player.sendMessage(ChatColor.RED + "Please specify a player to teleport to");
            return true;
        }

        Player targetPlayer = Bukkit.getPlayer(args[0]);

        if(targetPlayer == null){
            player.sendMessage(ChatColor.RED + "This player is not online!");
            return true;
        }

        player.sendMessage(String.format("Teleported to %s", targetPlayer.getName()));
        this.teleportService.teleportPlayerToPlayer(player, targetPlayer);
        return true;
    }
}
