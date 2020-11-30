package com.hayesdev.boosterbossbar.bossbars;

import com.hayesdev.boosterbossbar.BoosterBossbar;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class Boostbar {

    private static BossBar bossBar;

    private static BukkitTask taskID;

    public static BossBar updateBar(boolean[] currentBoosters) {

        boolean xPBoost = currentBoosters[0];
        boolean moneyBoost = currentBoosters[1];
        boolean mobCoins = currentBoosters[2];
        BossBar bossBar;

        if (xPBoost && !moneyBoost && !mobCoins) {
            bossBar = Bukkit.createBossBar(ChatColor.GOLD + "" + ChatColor.BOLD + "2x EXP", BarColor.YELLOW, BarStyle.SOLID);
        } else if (xPBoost && moneyBoost && !mobCoins) {
            bossBar = Bukkit.createBossBar(ChatColor.GOLD + "" + ChatColor.BOLD + "2x EXP and Money", BarColor.YELLOW, BarStyle.SOLID);
        } else if (xPBoost && moneyBoost && mobCoins) {
            bossBar = Bukkit.createBossBar(ChatColor.GOLD + "" + ChatColor.BOLD + "2x EXP, Money, and Mobcoins", BarColor.YELLOW, BarStyle.SOLID);
        } else if (!xPBoost && moneyBoost && mobCoins) {
            bossBar = Bukkit.createBossBar(ChatColor.GOLD + "" + ChatColor.BOLD + "2x Money and Mobcoins", BarColor.YELLOW, BarStyle.SOLID);
        } else if (!xPBoost && !moneyBoost && mobCoins) {
            bossBar = Bukkit.createBossBar(ChatColor.GOLD + "" + ChatColor.BOLD + "2x Mobcoins", BarColor.YELLOW, BarStyle.SOLID);
        } else if (!xPBoost && moneyBoost && !mobCoins) {
            bossBar = Bukkit.createBossBar(ChatColor.GOLD + "" + ChatColor.BOLD + "2x Money", BarColor.YELLOW, BarStyle.SOLID);
        } else if (xPBoost && !moneyBoost && mobCoins) {
            bossBar = Bukkit.createBossBar(ChatColor.GOLD + "" + ChatColor.BOLD + "2x EXP and Mobcoins", BarColor.YELLOW, BarStyle.SOLID);
        } else if (!xPBoost && !moneyBoost && !mobCoins) {
            bossBar = Bukkit.createBossBar(ChatColor.GOLD + "" + ChatColor.BOLD + "No current boosters", BarColor.YELLOW, BarStyle.SOLID);
        } else {
            bossBar = Bukkit.createBossBar(ChatColor.GOLD + "" + ChatColor.BOLD + "No current boosters", BarColor.YELLOW, BarStyle.SOLID);
        }

        return bossBar;
    }

    public static void startRainbowEffect() {
        taskID = new BukkitRunnable() {
            BarColor[] c = BarColor.values();
            int i = 0;
            @Override
            public void run() {
                if (i >= c.length) {
                    i = 0;
                }
                bossBar.setColor(c[i]);
                i++;
            }
        }.runTaskTimer(BoosterBossbar.getInstance(), 0, 20);
    }

    public static BukkitTask getRainbowEffect() {
        return taskID;
    }

    public static BossBar getBar() {
        if (bossBar != null) {
            return bossBar;
        } else {
            return null;
        }
    }

    public static boolean setBar(BossBar newBossBar) {
        bossBar = newBossBar;
        return true;
    }

    public static boolean addPlayer(Player player) {
        bossBar.addPlayer(player);
        return true;
    }

}
