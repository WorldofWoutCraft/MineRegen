package com.woutwoot.mrg;

import com.woutwoot.mrg.mine.Mine;
import com.woutwoot.mrg.mine.BlocksMine;
import org.bukkit.Location;
import org.bukkit.block.Block;

import java.util.HashMap;
import java.util.Map;

public class Mines {

	private static Map<String, Mine> mines = new HashMap<>();

	public static Mine getMine(String name) {
		return mines.get(name);
	}

	public static Mine getMine(Location l) {
		for (Mine m : mines.values()) {
			if (m.isBlock(l)) {
				return m;
			}
		}
		return null;
	}

	public static Mine getMine(Block b) {
		return getMine(b.getLocation());
	}

	public static void addMine(BlocksMine m) {
		mines.put(m.getName(), m);
	}

	public static boolean blockIsInMine(Block b) {
		return blockIsInMine(b.getLocation());
	}

	public static boolean blockIsInMine(Location l) {
		for (Mine m : mines.values()) {
			if (m.isBlock(l)) {
				return true;
			}
		}
		return false;
	}

	public static void regenMines() {
		for (Mine m : mines.values()) {
			m.regen();
		}
	}

}
