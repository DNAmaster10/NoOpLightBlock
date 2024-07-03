package org.dnamaster10.nooplightblock;

import org.bstats.bukkit.Metrics;

import org.bukkit.plugin.java.JavaPlugin;

public final class NoOpLightBlock extends JavaPlugin {
    private static NoOpLightBlock plugin;

    public static NoOpLightBlock getPlugin() {
        return plugin;
    }

    @Override
    public void onEnable() {
        plugin = this;
        int pluginId = 22382;
        Metrics metrics = new Metrics(this, pluginId);

        //Load config
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        //Register listeners
        getServer().getPluginManager().registerEvents(new BlockClickEvent(), plugin);

        getLogger().info("NoOpLightBlock has finished loading!");
    }
}
