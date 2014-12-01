package com.woutwoot.mrg.commands;

import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import com.sk89q.worldedit.bukkit.selections.Selection;
import com.woutwoot.mrg.Mines;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class RemoveSelectionCommand implements BasicCommand{

	@Override
	public void process(CommandSender sender, String[] args) {
		List<Block> blocks = getBlocksInSlection((Player) sender);
		if(!blocks.isEmpty()){
			Mines.getMine("default").removeBlocks(blocks);
			sender.sendMessage("The blocks in your selection have been removed.");
		}else{
			sender.sendMessage("Please make a slection first.");
		}
	}
	
	private List<Block> getBlocksInSlection(Player p){
		WorldEditPlugin worldEdit = (WorldEditPlugin) Bukkit.getServer().getPluginManager().getPlugin("WorldEdit");
		Selection selection = worldEdit.getSelection(p);

		if (selection != null) {
			Location loc1 = selection.getMinimumPoint();
			Location loc2 = selection.getMaximumPoint();
			int xMin = loc1.getBlockX();
			int yMin = loc1.getBlockY();
			int zMin = loc1.getBlockZ();
			int xMax = loc2.getBlockX();
			int yMax = loc2.getBlockY();
			int zMax = loc2.getBlockZ();

			ArrayList<Block> blocks = new ArrayList<Block>();
			World w = selection.getWorld();

			for (int i = xMin; i <= xMax; i++) {
				for (int j = yMin; j <= yMax; j++) {
					for (int k = zMin; k <= zMax; k++) {
						blocks.add(w.getBlockAt(i, j, k));
					}
				}
			}
			return blocks;
		} else {
			return new ArrayList<Block>();
		}
	}

}
