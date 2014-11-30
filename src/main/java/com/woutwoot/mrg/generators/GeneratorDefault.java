package com.woutwoot.mrg.generators;

import org.bukkit.Material;
import org.bukkit.material.MaterialData;

public class GeneratorDefault extends MineGenerator {
	
	public GeneratorDefault(){
		super();
		materials.put(new MaterialData(Material.STONE), 80);
		materials.put(new MaterialData(Material.GRAVEL), 6);
		materials.put(new MaterialData(Material.DIRT), 4);
		materials.put(new MaterialData(Material.COAL_ORE), 3);
		materials.put(new MaterialData(Material.IRON_ORE), 3);
		materials.put(new MaterialData(Material.GOLD_ORE), 2);
		materials.put(new MaterialData(Material.DIAMOND_ORE), 1);
		materials.put(new MaterialData(Material.EMERALD_ORE), 1);
	}

}
