package com.woutwoot.mrg.events;

import com.woutwoot.mrg.Mines;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;

public class BlockFallHandler implements Listener{
	
	@EventHandler(ignoreCancelled = true)
	public void onBlockFall(EntityChangeBlockEvent event){
		if(Mines.blockIsInMine(event.getBlock())){
			Mines.getMine(event.getBlock()).scheduleNewResetTask(event.getBlock());
		}
	}

}
