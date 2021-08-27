package com.pseudonova.adminzapper.abstracts;

import com.pseudonova.adminzapper.interfaces.ICommand;

public abstract class AbstractCommand implements ICommand {

    private final String permission;
    private final String name;
    private final String usage;
    private final boolean isPlayersOnly;

    public AbstractCommand(String name,String permission,boolean isPlayersOnly , String usage) {
        this.permission = permission;
        this.name = name;
        this.usage = usage;
        this.isPlayersOnly = isPlayersOnly;
    }

    public String getPermission() {
        return permission;
    }

    public String getName() {
        return name;
    }

    public String getUsage() {
        return usage;
    }

    public boolean isPlayersOnly() {
        return isPlayersOnly;
    }

}
