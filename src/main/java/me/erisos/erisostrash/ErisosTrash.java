package me.erisos.erisostrash;

import me.erisos.erisostrash.command.trashCommand;
import org.bukkit.plugin.java.JavaPlugin;


public final class ErisosTrash extends JavaPlugin {

    @Override
    public void onEnable() {

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        getCommand("trash").setExecutor(new trashCommand(this));
        getCommand("çöp").setExecutor(new trashCommand(this));

    }

}

