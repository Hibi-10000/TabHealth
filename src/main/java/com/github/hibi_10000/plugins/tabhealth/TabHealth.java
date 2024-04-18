package com.github.hibi_10000.plugins.tabhealth;

import java.text.NumberFormat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

public class TabHealth extends JavaPlugin {
    BukkitTask task = null;

    @Override
    public void onEnable() {
        super.onEnable();
        final NumberFormat numb = NumberFormat.getInstance();
        numb.setMaximumFractionDigits(1);
        task = getServer().getScheduler().runTaskTimer(this, () -> {
            for (Player p : Bukkit.getOnlinePlayers()) {
                String health = numb.format(p.getHealth());
                ChatColor color;
                if (p.getHealth() <= 6) {
                    color = ChatColor.RED;
                } else if (p.getHealth() <= 12) {
                    color = ChatColor.YELLOW;
                } else {
                    color = ChatColor.GREEN;
                }
                String name = color.toString() + ChatColor.BOLD + p.getName() + " :" + health;
                p.setPlayerListName(name);
            }
        }, 0L, 20L);
    }
}
