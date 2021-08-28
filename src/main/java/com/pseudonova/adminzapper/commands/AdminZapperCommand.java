package com.pseudonova.adminzapper.commands;
import com.pseudonova.adminzapper.interfaces.*;
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
    private final IConfigService configService;
    private final IMessageService messageService;


    private final Map<String, ICommand> subCommands = new HashMap<>();


    public AdminZapperCommand(ITeleportService teleportService, IConfigService configService, IMessageService messageService) {
        this.teleportService = teleportService;
        this.configService = configService;
        this.messageService = messageService;

        subCommands.put("goto", new GotoCommand(this.teleportService));
        subCommands.put("bring", new BringCommand(this.teleportService));
        subCommands.put("bringall", new BringAllCommand(this.teleportService));
        subCommands.put("return", new ReturnCommand(this.teleportService));
        subCommands.put("returnall", new ReturnAllCommand(this.teleportService));
        subCommands.put("reload", new ReloadCommand(this.configService, this.messageService));
        //TODO move command, moveall command, reload command

    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

        if(!sender.hasPermission("adminzapper")){
            messageService.sendNoPermissionMessage(sender);
            return true;
        }

        if(args.length == 0){
            showHelpMenu(sender);
            return true;
        }

        String cmdName = args[0].toLowerCase();

        if(!subCommands.containsKey(cmdName)){
            messageService.sendCmdNotExistMessage(sender);
            return true;
        }

        ICommand subCmd = this.subCommands.get(cmdName);

        if(!sender.hasPermission(subCmd.getPermission())){
            this.messageService.sendNoPermissionMessage(sender);
            return true;
        }

        if(subCmd.isPlayersOnly() && !(sender instanceof Player)){
            messageService.sendOnlyPlayersMessage(sender);
            return true;
        }

        return subCmd.onCommand(sender,cmd,commandLabel, Arrays.copyOfRange(args, 1,args.length));
    }

    private void showHelpMenu(CommandSender sender){
        sender.sendMessage("Help menu test test");
    }
}
