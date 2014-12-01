package com.woutwoot.mrg.commands;

import com.woutwoot.mrg.Creator;
import com.woutwoot.mrg.Main;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AddBlocksCommand implements BasicCommand{

	@Override
	public void process(CommandSender sender, String[] args) {

		Player player;
		if (sender instanceof Player) {
			player = (Player) sender;
		} else {
			sender.sendMessage("This is a player only command.");
			return;
		}

		if (Main.creators.contains(player)) {
			Main.creators.remove(player);
			sender.sendMessage("You can no longer create mine blocks.");
		} else {
			Main.creators.add(new Creator(player));
			sender.sendMessage("You can now create mine blocks by destroying them.");
		}
	}

}
