package com.woutwoot.mrg;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	public static Plugin plugin;
	public static File folder;
	public static List<Creator> creators = new ArrayList<Creator>();

	@Override
	public void onEnable() {
		plugin = this;
		folder = this.getDataFolder();
		folder.mkdirs();

		// Create and add default mine.
		Mines.addMine(new Mine("default"));

		this.getCommand("mrg").setExecutor(new CommandHandler());
		this.getServer().getPluginManager().registerEvents(new BlockBreakHandler(), this);
		this.getServer().getPluginManager().registerEvents(new BlockFallHandler(), this);
		this.getServer().getPluginManager().registerEvents(new BlockExplodeHandler(), this);
	}

	@Override
	public void onDisable() {
		Mines.regenMines();
	}

	public static Creator getCreator(Player player) {
		for (Creator c : creators) {
			if (c.equals(player)) {
				return c;
			}
		}
		return null;
	}

}
