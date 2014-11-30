package com.woutwoot.mrg.commands;

import org.bukkit.command.CommandSender;

import com.woutwoot.MineRegen.Mines;

public class RegenCommand implements BasicCommand {

	@Override
	public void process(CommandSender sender, String[] args) {
		Mines.getMine("default").regen();
		sender.sendMessage("Default mine has been regenerated!");
	}

}
