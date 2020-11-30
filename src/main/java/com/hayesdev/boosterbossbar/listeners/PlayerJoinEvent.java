package com.hayesdev.boosterbossbar.listeners;

import com.hayesdev.boosterbossbar.bossbars.Boostbar;
import com.hayesdev.boosterbossbar.bossbars.RegisterBoosters;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerJoinEvent implements Listener {

    @EventHandler
    public void onPlayerJoin(org.bukkit.event.player.PlayerJoinEvent e) {
        Player player = e.getPlayer();
        if (Boostbar.getBar() == null) {
            boolean[] updatedList = RegisterBoosters.updateBoosters();
            BossBar updatedBar = Boostbar.updateBar(updatedList);
            Boostbar.setBar(updatedBar);
            Boostbar.startRainbowEffect();
        }
        Boostbar.addPlayer(player);
    }
}
