package com.pseudonova.adminzapper;

import com.pseudonova.adminzapper.commands.AdminZapperCommand;
import com.pseudonova.adminzapper.interfaces.ITeleportService;
import com.pseudonova.adminzapper.statics.Bootstrapper;
import org.bukkit.plugin.java.JavaPlugin;

public class AdminZapper extends JavaPlugin {


    private Bootstrapper bootstrapper;
    private ITeleportService teleportService;

    @Override
    public void onEnable(){

        saveDefaultConfig();

        bootstrapper = Bootstrapper.getBootstrapper();
        bootstrapper.initialize(this);

        registerServices();
        registerCommands();

    }

    private void registerServices(){
        this.teleportService = bootstrapper.getTeleportService();

    }


    private void registerCommands(){

        getCommand("az").setExecutor(new AdminZapperCommand(this.teleportService));

    }

}
