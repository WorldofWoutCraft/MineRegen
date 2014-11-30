package com.woutwoot.mrg.commands;

import org.bukkit.command.CommandSender;

import com.woutwoot.MineRegen.Mines;

public class RegenAllCommand implements BasicCommand{

	@Override
	public void process(CommandSender sender, String[] args) {
		Mines.regenMines();
		sender.sendMessage("All mines have been regenerated!");
	}

}
