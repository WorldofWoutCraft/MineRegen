package com.woutwoot.mrg.mine;

import com.woutwoot.mrg.Main;
import com.woutwoot.mrg.Vars;
import com.woutwoot.mrg.generators.GeneratorDefault;
import com.woutwoot.mrg.generators.GeneratorOresOnly;
import com.woutwoot.mrg.generators.MineGenerator;
import com.woutwoot.mrg.tasks.ResetTask;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BlocksMine implements Mine {

	private String name = "default";
	private List<Location> blocks = new ArrayList<>();
	private MineGenerator gen = new GeneratorDefault();

	public BlocksMine(String name) {
		this.setName(name);
		this.setGen(new GeneratorOresOnly());
	}

	public BlocksMine(String name, MineGenerator generator) {
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

	public boolean isBlock(Location l) {
		return this.blocks.contains(l);
	}

	public void scheduleNewResetTask(Block b) {
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new ResetTask(b, this), Vars.delay);
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
