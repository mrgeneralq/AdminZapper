package com.pseudonova.adminzapper.commands;

import com.pseudonova.adminzapper.abstracts.AbstractCommand;
import com.pseudonova.adminzapper.interfaces.ITeleportService;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BringCommand extends AbstractCommand {


    private final ITeleportService teleportService;

    public BringCommand(ITeleportService teleportService) {
        super("goto","adminzapper.bring", true, "bring a player to you");
        this.teleportService = teleportService;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

        Player player = (Player) sender;

        if(args.length == 0){
            player.sendMessage(ChatColor.RED + "Please specify a player to teleport to you");
            return true;
        }

        Player targetPlayer = Bukkit.getPlayer(args[0]);

        if(targetPlayer == null){
            player.sendMessage(ChatColor.RED + "This player is not online!");
            return true;
        }

        this.teleportService.teleportPlayerToPlayer(targetPlayer, player);
        player.sendMessage(String.format("Teleported %s to you", targetPlayer.getName()));
        return true;
    }
}
