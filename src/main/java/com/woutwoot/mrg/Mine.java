package com.woutwoot.mrg;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;

import com.woutwoot.MineRegen.generators.GeneratorDefault;
import com.woutwoot.MineRegen.generators.GeneratorOresOnly;
import com.woutwoot.MineRegen.generators.MineGenerator;

public class Mine {

	private String name = "default";
	private List<Location> blocks = new ArrayList<Location>();
	private MineGenerator gen = new GeneratorDefault();

	public Mine(String name) {
		this.setName(name);
		this.setGen(new GeneratorOresOnly());
	}

	public Mine(String name, MineGenerator generator) {
		this.setName(name);
		this.setGen(generator);
	}

	public MineGenerator getGen() {
		return gen;
	}

	public void setGen(MineGenerator gen) {
		this.gen = gen;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addBlock(Block b) {
		this.addBlockLocation(b.getLocation());
	}

	public void removeBlock(Block b) {
		this.removeBlockLocation(b.getLocation());
	}

	public void addBlockLocation(Location l) {
		this.blocks.add(l);
	}

	public void removeBlockLocation(Location l) {
		this.blocks.remove(l);
	}

	public void regen() {
		if (!blocks.isEmpty()) {
			for (Location l : blocks) {
				l.getBlock().setType(gen.getRandomisedMaterial());
			}
		}
	}

	public boolean isBlock(Block b) {
		return isBlock(b.getLocation());
	}

	public boolean isBlock(Location l) {
		return this.blocks.contains(l);
	}

	public void scheduleNewResetTask(Block b) {
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new ResetTask(b, this), 100L);
	}

	public void addBlocks(Collection<Block> blocks) {
		for (Block b : blocks) {
			this.addBlock(b);
		}
	}

	public void removeBlocks(List<Block> blocks) {
		for (Block b : blocks) {
			this.removeBlock(b);
		}
	}

}
