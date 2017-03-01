package com.mukri.help;

import org.bukkit.plugin.java.JavaPlugin;

import com.mukri.help.commands.HelpCmd;
import com.mukri.help.file.MessageData;
import com.mukri.help.file.SettingsData;


/**
 * CopyRighted by DoomGary / Mukri
 * Please do not edit or copy without permissions.
 * Made on: 4:14:36 PM 
 */

public class Help extends JavaPlugin {
	
	public static Help instance;
	public SettingsData settings;
	public MessageData msgsettings;
	
	public void onEnable() {
		getLogger().info("[CustomHelp] Made by Mukri v2.0");
		instance = this;
		
		settings = new SettingsData();
		msgsettings = new MessageData();
		
		if(!msgsettings.isExists()) {
			msgsettings.createNewFile();
		}
		
		if(!settings.isExists()) {
			settings.createNewFile();
		}
		
		commands();
	}
	
	public void onDisable() {
		
	}
	
	public void commands() {
		getCommand("help").setExecutor(new HelpCmd());
	}
	
	public static Help getInstance() {
		return instance;
	}

}
