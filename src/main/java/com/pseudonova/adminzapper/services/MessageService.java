package com.pseudonova.adminzapper.services;

import com.pseudonova.adminzapper.builders.MessageBuilder;
import com.pseudonova.adminzapper.interfaces.IConfigService;
import com.pseudonova.adminzapper.interfaces.IMessageService;
import org.bukkit.command.CommandSender;

public class MessageService implements IMessageService {

    private final IConfigService configService;
    private final String prefix;

    public MessageService(IConfigService configService) {
        this.configService = configService;
        this.prefix = configService.getPrefix();
    }


    @Override
    public void sendConfigReloadedMessage(CommandSender sender) {

        String configMessage = configService.getConfigReloadedMessage();
        String message = new MessageBuilder(configMessage, this.prefix)
                .usePrefix(true)
                .colorize()
                .build();

        sender.sendMessage(message);
    }

    @Override
    public void sendNoPermissionMessage(CommandSender sender) {
        String configMessage = configService.getNoPermissionMessage();
        String message = new MessageBuilder(configMessage, this.prefix)
                .usePrefix(true)
                .colorize()
                .build();

        sender.sendMessage(message);
    }

    @Override
    public void sendOnlyPlayersMessage(CommandSender sender) {
        String configMessage = configService.getOnlyPlayersMessage();
        String message = new MessageBuilder(configMessage, this.prefix)
                .usePrefix(true)
                .colorize()
                .build();

        sender.sendMessage(message);
    }

    @Override
    public void sendCmdNotExistMessage(CommandSender sender) {
        String configMessage = configService.getCmdNotExistMessage();
        String message = new MessageBuilder(configMessage, this.prefix)
                .usePrefix(true)
                .colorize()
                .build();

        sender.sendMessage(message);
    }
}
