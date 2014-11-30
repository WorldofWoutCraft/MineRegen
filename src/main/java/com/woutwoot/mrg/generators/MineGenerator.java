package com.woutwoot.mrg.generators;

import java.util.LinkedHashMap;
import java.util.Map;

import org.bukkit.Material;
import org.bukkit.material.MaterialData;

public abstract class MineGenerator {

	protected Map<MaterialData, Integer> materials;
	
	MineGenerator(){
		materials = new LinkedHashMap<MaterialData, Integer>();
	}
	
	public Material getRandomisedMaterial(){		
		double r = Math.random() * 100;
		
		int totalChance = 0;
		for(MaterialData md : materials.keySet()){
			Material m = md.getItemType();
			int chance = materials.get(md);
			if(r < totalChance + chance){
				return m;
			} else {
				totalChance += chance;
			}
		}
		return Material.AIR;
	}
	
}
