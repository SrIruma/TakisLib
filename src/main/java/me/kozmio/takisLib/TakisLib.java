package me.kozmio.takisLib;

import org.bukkit.plugin.java.JavaPlugin;

public final class TakisLib extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("has been disabled!");
    }
}
