package com.woutwoot.mrg.events;

import com.woutwoot.mrg.Main;
import com.woutwoot.mrg.Mines;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakHandler implements Listener{
	
	@EventHandler(ignoreCancelled = true)
	public void onBlockBreak(BlockBreakEvent event){
		if(Mines.blockIsInMine(event.getBlock())){
			Mines.getMine(event.getBlock()).scheduleNewResetTask(event.getBlock());
		} else {
			if(Main.creators.contains(event.getPlayer())){
				Mines.getMine(Main.getCreator(event.getPlayer()).getCurrentMineName()).addBlockLocation(event.getBlock().getLocation());
				event.getPlayer().sendMessage("Block added!");
			}
		}
	}

}
