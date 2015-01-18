package com.woutwoot.mrg.events;

import com.woutwoot.mrg.Main;
import com.woutwoot.mrg.Mines;
import com.woutwoot.mrg.mine.Mine;
import com.woutwoot.mrg.mine.BlocksMine;
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
				Mine m = Mines.getMine(Main.getCreator(event.getPlayer()).getCurrentMineName());
				if(m instanceof BlocksMine){
					((BlocksMine)m).addBlock(event.getBlock());
					event.getPlayer().sendMessage("Block added!");
				}else{
					event.getPlayer().sendMessage("You can't add block to a non-block based mine!");
				}
			}
		}
	}

}
