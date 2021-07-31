package jp.minecraft.hibi_10000.plugins;

import java.text.NumberFormat;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class TabHealth extends JavaPlugin {
	
	BukkitTask task = null;
	private static NumberFormat numb = NumberFormat.getInstance();
	
	static {
		numb.setMaximumFractionDigits(1);
	}
    
	public void onEnable() {
		super.onEnable();
		task = new BukkitRunnable() {
			public void run() {
				for(Player player : Bukkit.getOnlinePlayers()) {
					String health = numb.format(player.getHealth());
					String color;
					String p = player.getName();
					if(player.getHealth() <= 6) {
						color = "§C§L";
					} else if(player.getHealth() <= 12) {
						color = "§E§L";
					} else {
						color = "§A§L";
					}
					String name = color + p + " :" + health;
					player.setPlayerListName(name);
				}
			}
		}.runTaskTimer(this,0L, 20L);
	}
	
	public void onDisable() {
		super.onDisable();
	}
}
