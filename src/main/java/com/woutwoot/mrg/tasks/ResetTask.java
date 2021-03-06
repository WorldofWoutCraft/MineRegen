package com.woutwoot.mrg.tasks;

import com.woutwoot.mrg.mine.Mine;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class ResetTask implements Runnable {

	private Block b;
	private Mine m;

	public ResetTask(Block b, Mine m) {
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
