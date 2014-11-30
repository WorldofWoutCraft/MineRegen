package com.woutwoot.mrg.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.woutwoot.MineRegen.Creator;
import com.woutwoot.MineRegen.Main;

public class AddBlocksCommand implements BasicCommand{

	@Override
	public void process(CommandSender sender, String[] args) {
		if (Main.creators.contains((Player) sender)) {
			Main.creators.remove((Player) sender);
			sender.sendMessage("You can no longer create mine blocks.");
		} else {
			Main.creators.add(new Creator((Player) sender));
			sender.sendMessage("You can now create mine blocks by destroying them.");
		}
	}

}
