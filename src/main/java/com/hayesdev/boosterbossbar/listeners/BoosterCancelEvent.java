package com.hayesdev.boosterbossbar.listeners;

import com.hayesdev.boosterbossbar.BoosterBossbar;
import com.hayesdev.boosterbossbar.bossbars.Boostbar;
import com.hayesdev.boosterbossbar.bossbars.RegisterBoosters;
import org.bukkit.Bukkit;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;

public class BoosterCancelEvent implements Listener {

    @EventHandler
    public void onBoosterCancel(me.swanis.boosters.events.BoosterCancelEvent event) {
        Boostbar.getBar().removeAll();
        new BukkitRunnable() {
            @Override
            public void run() {
                boolean[] updatedList = RegisterBoosters.updateBoosters();
                BossBar updatedBar = Boostbar.updateBar(updatedList);
                Boostbar.setBar(updatedBar);
                Boostbar.getRainbowEffect().cancel();
                Boostbar.startRainbowEffect();
                for (Player player : Bukkit.getOnlinePlayers()) {
                    Boostbar.addPlayer(player);
                }
            }
        }.runTaskLater(BoosterBossbar.getInstance(), 1L);
    }
}
