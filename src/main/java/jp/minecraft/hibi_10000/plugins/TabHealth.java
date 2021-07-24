package jp.minecraft.hibi_10000.plugins;


//import java.util.ArrayList;
//import java.util.List;

import java.text.NumberFormat;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
//import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
//import org.bukkit.scoreboard.Objective;
//import org.bukkit.scoreboard.Score;
//import org.bukkit.scoreboard.Scoreboard;
//import org.bukkit.scoreboard.ScoreboardManager;

public class TabHealth extends JavaPlugin {

//	ScoreboardManager manager = Bukkit.getScoreboardManager();
//	Scoreboard board = manager.getNewScoreboard();
	BukkitTask task = null;
//	Score score;
//	List<String> players = new ArrayList<String>();
//	boolean enable = true;
//	private static NumberFormat numb = NumberFormat.getInstance();
	
	@SuppressWarnings("unused")
	private static int CharLimit;
	private static NumberFormat numb = NumberFormat.getInstance();
	  
	  static {
	    numb.setMaximumFractionDigits(1);
	    CharLimit = 16;
	  }
	
	public void onEnable() {
		super.onEnable();
		task = new BukkitRunnable() {
			@Override
			public void run() {
				for (Player player : Bukkit.getOnlinePlayers()) {
//					player = event.getPlayer();
//					Collection<? extends Player> player1 = Bukkit.getOnlinePlayers();
					String playername = player.getName();
					String playerhealth = numb.format(player.getHealth());
//					String number;
//					String playername = ((Objective) Bukkit.getOnlinePlayers()).getName();
//					player.setScoreboard(board);
//					Objective obj = board.registerNewObjective(player.getName(),"dummy");
//			  		try {
						if (player.getHealth() <= 6) {
							player.setPlayerListName("§C" + "§L" + playername + " :" + playerhealth);
//							score = obj.getScore(ChatColor.RED + ": ");
						} else if (player.getHealth() <= 12) {
							player.setPlayerListName("§E" + "§L" + playername + " :" + playerhealth);
//							score = obj.getScore(ChatColor.YELLOW + ": ");
						} else {
							player.setPlayerListName("§A" + "§L" + playername + " :" + playerhealth);
//							score = obj.getScore(ChatColor.GREEN + ": ");
						}
//					} catch (IllegalArgumentException e) {
//						player1.setPlayerListName(playername);
//						score = obj.getScore("");
//					}
//					obj.setDisplaySlot(DisplaySlot.PLAYER_LIST);
//					obj.setDisplayName(/*ChatColor.YELLOW + */"Health");
//					score = obj.getScore(": ");
//					score.setScore((int) player.getHealth());
//					player.setScoreboard(board);
//					players.add(player.getName());
//					if (players.contains(player.getName())) {
//						if(enable == true) {
//							Score score1 = obj.getScore(player);
//							score1.setScore((int) player.getHealth());
//							player.setScoreboard(board);
//						}
//						else {
//							board.resetScores(player.getName());
//						}
//					}
				} 
			}
		}.runTaskTimer(this,0L, 20L);
	}
	
	public void onDisable() {
		super.onDisable();
	}
}