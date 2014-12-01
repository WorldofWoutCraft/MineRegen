package com.woutwoot.mrg.events;

import com.woutwoot.mrg.Mines;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

public class BlockExplodeHandler implements Listener {

	@EventHandler(ignoreCancelled = true)
	public void onEntityExplode(EntityExplodeEvent event) {
		for (Block b : event.blockList()) {
			if (Mines.blockIsInMine(b)) {
				Mines.getMine(b).scheduleNewResetTask(b);
			}
		}
	}

}
