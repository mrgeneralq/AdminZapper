package com.pseudonova.adminzapper.commands;

import com.pseudonova.adminzapper.abstracts.AbstractCommand;
import com.pseudonova.adminzapper.interfaces.IConfigService;
import com.pseudonova.adminzapper.interfaces.IMessageService;
import com.pseudonova.adminzapper.interfaces.ITeleportService;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReloadCommand extends AbstractCommand {


    private final IConfigService configService;
    private final IMessageService messageService;

    public ReloadCommand(IConfigService configService, IMessageService messageService) {
        super("reload","adminzapper.reload", false, "/az reload");
        this.configService = configService;
        this.messageService = messageService;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

        this.configService.reloadConfig();
        this.messageService.sendConfigReloadedMessage(sender);
        return true;
    }
}
