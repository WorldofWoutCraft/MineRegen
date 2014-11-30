package com.woutwoot.mrg.generators;

import org.bukkit.Material;
import org.bukkit.material.MaterialData;

public class GeneratorRich extends MineGenerator {
	
	public GeneratorRich(){
		super();
		materials.put(new MaterialData(Material.STONE), 50);
		materials.put(new MaterialData(Material.IRON_BLOCK), 10);
		materials.put(new MaterialData(Material.COAL_BLOCK), 10);
		materials.put(new MaterialData(Material.GOLD_BLOCK), 8);
		materials.put(new MaterialData(Material.QUARTZ_BLOCK), 8);
		materials.put(new MaterialData(Material.DIAMOND_BLOCK), 7);
		materials.put(new MaterialData(Material.EMERALD_BLOCK), 7);
	}

}
