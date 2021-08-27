package com.pseudonova.adminzapper.commands;
import com.pseudonova.adminzapper.interfaces.ICommand;
import com.pseudonova.adminzapper.interfaces.ILocationHistoryService;
import com.pseudonova.adminzapper.interfaces.ITeleportService;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AdminZapperCommand implements CommandExecutor {

    private final ITeleportService teleportService;

    private final Map<String, ICommand> subCommands = new HashMap<>();


    public AdminZapperCommand(ITeleportService teleportService) {
        this.teleportService = teleportService;

        subCommands.put("goto", new GotoCommand(this.teleportService));
        subCommands.put("bring", new BringCommand(this.teleportService));
        subCommands.put("bringall", new BringAllCommand(this.teleportService));
        subCommands.put("return", new ReturnCommand(this.teleportService));
        subCommands.put("returnall", new ReturnAllCommand(this.teleportService));
        //TODO move command, moveall command, reload command

    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

        if(!sender.hasPermission("adminzapper")){
            sender.sendMessage(ChatColor.RED + "You don't have permission");
            return true;
        }

        if(args.length == 0){
            showHelpMenu(sender);
            return true;
        }

        String cmdName = args[0].toLowerCase();

        if(!subCommands.containsKey(cmdName)){
            sender.sendMessage(ChatColor.RED + "This command does not exist!");
            return true;
        }

        ICommand subCmd = this.subCommands.get(cmdName);

        if(!sender.hasPermission(subCmd.getPermission())){
            sender.sendMessage(ChatColor.RED + "You don't have permission to that command!");
            return true;
        }

        if(subCmd.isPlayersOnly() && !(sender instanceof Player)){
            sender.sendMessage("This command can only be executed by players!");
            return true;
        }

        return subCmd.onCommand(sender,cmd,commandLabel, Arrays.copyOfRange(args, 1,args.length));
    }

    private void showHelpMenu(CommandSender sender){
        sender.sendMessage("Help menu test test");
    }
}
