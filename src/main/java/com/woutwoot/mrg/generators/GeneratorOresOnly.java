package com.woutwoot.mrg.generators;

import org.bukkit.Material;
import org.bukkit.material.MaterialData;

public class GeneratorOresOnly extends MineGenerator {

	public GeneratorOresOnly(){
		super();
		materials.put(new MaterialData(Material.COAL_ORE), 65);
		materials.put(new MaterialData(Material.IRON_ORE), 15);
		materials.put(new MaterialData(Material.GOLD_ORE), 10);
		materials.put(new MaterialData(Material.REDSTONE_ORE), 5);
		materials.put(new MaterialData(Material.DIAMOND_ORE), 3);
		materials.put(new MaterialData(Material.EMERALD_ORE), 2);
	}
}
