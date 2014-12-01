package com.woutwoot.mrg.commands;

import com.woutwoot.mrg.Mines;
import org.bukkit.command.CommandSender;

public class RegenCommand implements BasicCommand {

	@Override
	public void process(CommandSender sender, String[] args) {
		Mines.getMine("default").regen();
		sender.sendMessage("Default mine has been regenerated!");
	}

}
