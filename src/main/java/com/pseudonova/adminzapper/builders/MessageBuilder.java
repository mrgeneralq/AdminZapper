package com.pseudonova.adminzapper.builders;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class MessageBuilder {

    private String message = "";
    private String prefix = "";
    private boolean usePrefix = false;
    private boolean useColor = false;

    public MessageBuilder(String rawMessage, String prefix) {
        this.message = rawMessage;
    }

    public MessageBuilder setPlayer(Player player){
        this.message.replace("%player%", player.getName());
        return this;
    }

    public MessageBuilder setTarget(Player player){
        this.message = this.message.replace("%target%", player.getName());
        return this;
    }

    public MessageBuilder setWorld(World world){
        this.message = this.message.replace("%world%", world.getName());
        return this;
    }

    public MessageBuilder usePrefix(boolean usePrefix){
        this.usePrefix = usePrefix;
        return this;
    }

    public MessageBuilder colorize(){
       this.useColor = true;
       return this;
    }

    public MessageBuilder setMessage(String message){
        this.message = message;
        return this;
    }


    public String build(){
        String finalMessage = this.message.trim();

        if(finalMessage.isEmpty()) {
            return "";
        }

        if(usePrefix)
            finalMessage = String.format("%s %s", this.prefix, finalMessage).trim();

        if(this.useColor)
            finalMessage = ChatColor.translateAlternateColorCodes('&', finalMessage);

        return finalMessage;
    }


}
