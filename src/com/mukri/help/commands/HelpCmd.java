package com.mukri.help.commands;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.mukri.help.Help;
import com.mukri.help.file.SettingsData;


/**
 * CopyRighted by DoomGary / Mukri
 * Please do not edit or copy without permissions.
 * Made on: 4:16:23 PM 
 */

public class HelpCmd implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {

		if(!(sender instanceof Player)) {
			return true;
		}

		Player p = (Player) sender;

		if(cmd.getName().equalsIgnoreCase("help")) {
			if(args.length < 1) {
				if(Help.getInstance().settings.containsPage("1")) {
					if(Help.getInstance().settings.usePermissions("1")) {
						if(p.hasPermission(Help.getInstance().settings.getPermissions("1"))) {
							for(String line : Help.getInstance().settings.getTextFromList("1")) {
								p.sendMessage(ChatColor.translateAlternateColorCodes('&', line));
							}
						} else {
							p.sendMessage(Help.getInstance().msgsettings.getMsg("No-Permissions").replaceAll("&", "¤"));
						}
					} else {
						for(String line : Help.getInstance().settings.getTextFromList("1")) {
							p.sendMessage(ChatColor.translateAlternateColorCodes('&', line).replaceAll("%player%", p.getName()));
						}
					}
				} else {
					p.sendMessage("¤cCustom Help was not configured correctly! No.1 is the default Help sections! Make sure to have set it up properly.");
				}
			}

			else if(args[0].equalsIgnoreCase("reload")) {
				if(p.hasPermission("customhelp.reload")) {
					Help.getInstance().settings =  new SettingsData();
					p.sendMessage("¤7[CustomHelp] Successfully reloaded!");
				}
			}

			else if(args.length == 1) {
				String page = args[0];

				if(Help.getInstance().settings.containsPage(page)) {
					page = Help.getInstance().settings.getPageName(page);
					if(Help.getInstance().settings.usePermissions(page)) {
						if(p.hasPermission(Help.getInstance().settings.getPermissions(page))) {
							for(String line : Help.getInstance().settings.getTextFromList(page)) {
								p.sendMessage(ChatColor.translateAlternateColorCodes('&', line));
							}
						} else {
							p.sendMessage(Help.getInstance().msgsettings.getMsg("No-Permissions").replaceAll("&", "¤"));
						}
					} else {
						for(String line : Help.getInstance().settings.getTextFromList(page)) {
							p.sendMessage(ChatColor.translateAlternateColorCodes('&', line).replaceAll("%player%", p.getName()));
						}
					}
				} else {
					p.sendMessage(Help.getInstance().msgsettings.getMsg("Unkown-Command").replaceAll("&", "¤"));
				}
			}

			else {
				if(Help.getInstance().settings.containsPage("1")) {
					if(Help.getInstance().settings.usePermissions("1")) {
						if(p.hasPermission(Help.getInstance().settings.getPermissions("1"))) {
							for(String line : Help.getInstance().settings.getTextFromList("1")) {
								p.sendMessage(ChatColor.translateAlternateColorCodes('&', line));
							}
						} else {
							p.sendMessage(Help.getInstance().msgsettings.getMsg("No-Permissions").replaceAll("&", "¤"));
						}
					} else {
						for(String line : Help.getInstance().settings.getTextFromList("1")) {
							p.sendMessage(ChatColor.translateAlternateColorCodes('&', line).replaceAll("%player%", p.getName()));
						}
					}
				} else {
					p.sendMessage("¤cCustom Help was not configured correctly! No.1 is the default Help sections! Make sure to have set it up properly.");
				}
			}
		}

		return false;
	}

}
