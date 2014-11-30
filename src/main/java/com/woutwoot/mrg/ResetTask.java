package com.woutwoot.mrg;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class ResetTask extends BukkitRunnable {

	private Block b;
	private Mine m;

	ResetTask(Block b, Mine m) {
		this.b = b;
		this.m = m;
	}

	@Override
	public void run() {
		if (!playerNearBlock()) {
			b.setType(m.getGen().getRandomisedMaterial());
		} else {
			m.scheduleNewResetTask(b);
		}
	}

	private boolean playerNearBlock() {
		for (Player p : b.getWorld().getPlayers()) {
			if (!Double.isNaN(p.getLocation().distanceSquared(b.getLocation()))) {
				if (p.getLocation().distanceSquared(b.getLocation()) < 5) {
					return true;
				}
			}
		}
		return false;
	}

}
