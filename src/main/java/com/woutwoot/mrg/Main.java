package com.woutwoot.mrg;

import com.woutwoot.mrg.events.BlockBreakHandler;
import com.woutwoot.mrg.events.BlockExplodeHandler;
import com.woutwoot.mrg.events.BlockFallHandler;
import com.woutwoot.mrg.mine.BlocksMine;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main extends JavaPlugin {

	public static File folder;
	public static List<Creator> creators = new ArrayList<>();
	private static Main instance;

	public static Creator getCreator(Player player) {
		for (Creator c : creators) {
			if (c.equals(player)) {
				return c;
			}
		}
		return null;
	}

	public static Main getInstance() {
		return instance;
	}

	@Override
	public void onEnable() {
		instance = this;
		folder = this.getDataFolder();
		folder.mkdirs();

		// Create and add default mine.
		Mines.addMine(new BlocksMine("default"));

		this.getCommand("mrg").setExecutor(new CommandHandler());
		this.getServer().getPluginManager().registerEvents(new BlockBreakHandler(), this);
		this.getServer().getPluginManager().registerEvents(new BlockFallHandler(), this);
		this.getServer().getPluginManager().registerEvents(new BlockExplodeHandler(), this);
	}

	@Override
	public void onDisable() {
		Mines.regenMines();
	}

}
