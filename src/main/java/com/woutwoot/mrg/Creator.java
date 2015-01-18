package com.woutwoot.mrg;

import org.bukkit.entity.Player;

public class Creator {

	private Player p;
	private String currentMineName = "default";
	
	public Creator(Player p){
		this.setPlayer(p);
	}
	
	/**
	 * @return the p
	 */
	public Player getPlayer() {
		return p;
	}

	/**
	 * @param p the p to set
	 */
	public void setPlayer(Player p) {
		this.p = p;
	}

	/**
	 * @return the currentMineName
	 */
	public String getCurrentMineName() {
		return currentMineName;
	}

	/**
	 * @param currentMineName the currentMineName to set
	 */
	public void setCurrentMineName(String currentMineName) {
		this.currentMineName = currentMineName;
	}
	
	@Override
	public boolean equals(Object o){
		if(o instanceof Player){
			return ((Player)o).getUniqueId().equals(p.getUniqueId());
		}else if (o instanceof Creator){
			return ((Creator)o).getPlayer().getUniqueId().equals(p.getUniqueId());
		}
		return this.getPlayer().equals(o);
	}
	
}
