package com.woutwoot.mrg;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.woutwoot.MineRegen.commands.AddBlocksCommand;
import com.woutwoot.MineRegen.commands.AddSelectionCommand;
import com.woutwoot.MineRegen.commands.ConvertCommand;
import com.woutwoot.MineRegen.commands.CreateCommand;
import com.woutwoot.MineRegen.commands.HelpCommand;
import com.woutwoot.MineRegen.commands.RegenAllCommand;
import com.woutwoot.MineRegen.commands.RegenCommand;
import com.woutwoot.MineRegen.commands.RemoveSelectionCommand;

public class CommandHandler implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("mrg")) {
			if (args.length >= 1) {
				switch (args[0]) {
				case "create":
					new CreateCommand().process(sender, args);
					return true;
				case "regen":
					new RegenCommand().process(sender, args);
					return true;
				case "regenall":
					new RegenAllCommand().process(sender, args);
					return true;
				case "addblocks":
					new AddBlocksCommand().process(sender, args);
					return true;
				case "addselection":
					new AddSelectionCommand().process(sender, args);
					return true;
				case "removeselection":
					new RemoveSelectionCommand().process(sender, args);
					return true;
				case "convert":
					new ConvertCommand().process(sender, args);
					return true;
				default:
					new HelpCommand().process(sender, args);
					return true;
				}
			}
		}
		return false;
	}

}
