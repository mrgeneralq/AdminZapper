package com.pseudonova.adminzapper.commands;

import com.pseudonova.adminzapper.abstracts.AbstractCommand;
import com.pseudonova.adminzapper.interfaces.ITeleportService;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReturnCommand extends AbstractCommand {


    private final ITeleportService teleportService;

    public ReturnCommand(ITeleportService teleportService) {
        super("return","adminzapper.return", true, "/az return <player>");
        this.teleportService = teleportService;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

        Player player = (Player) sender;

        if(args.length == 0){
            player.sendMessage(ChatColor.RED + "Please specify a player to teleport to return");
            return true;
        }

        Player targetPlayer = Bukkit.getPlayer(args[0]);

        if(targetPlayer == null){
            player.sendMessage(ChatColor.RED + "This player is not online!");
            return true;
        }


        player.sendMessage("You have been returned to your previous location");
        targetPlayer.sendMessage(ChatColor.GREEN + "");

        this.teleportService.teleportPlayerToLastLocation(targetPlayer);
        return true;
    }
}
