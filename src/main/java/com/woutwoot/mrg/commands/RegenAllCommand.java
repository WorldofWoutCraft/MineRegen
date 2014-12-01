package com.woutwoot.mrg.commands;

import com.woutwoot.mrg.Mines;
import org.bukkit.command.CommandSender;

public class RegenAllCommand implements BasicCommand{

	@Override
	public void process(CommandSender sender, String[] args) {
		Mines.regenMines();
		sender.sendMessage("All mines have been regenerated!");
	}

}
