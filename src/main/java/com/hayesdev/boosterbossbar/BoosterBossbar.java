package com.hayesdev.boosterbossbar;

import com.hayesdev.boosterbossbar.listeners.BoosterActivateEvent;
import com.hayesdev.boosterbossbar.listeners.BoosterCancelEvent;
import com.hayesdev.boosterbossbar.listeners.PlayerJoinEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class BoosterBossbar extends JavaPlugin {

    private static BoosterBossbar myPlugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getPluginManager().registerEvents(new PlayerJoinEvent(), this);
        Bukkit.getPluginManager().registerEvents(new BoosterActivateEvent(), this);
        Bukkit.getPluginManager().registerEvents(new BoosterCancelEvent(), this);
        myPlugin = this;

        System.out.println("BoosterBossbar initialized");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("BoosterBossbar uninitialized");
    }

    public static BoosterBossbar getInstance() {
        return myPlugin;
    }


}
