package com.woutwoot.mrg.commands;

import org.bukkit.command.CommandSender;

public interface BasicCommand {
	
	public void process(CommandSender sender, String[] args);
	
}
