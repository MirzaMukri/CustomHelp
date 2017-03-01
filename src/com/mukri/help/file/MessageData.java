package com.mukri.help.file;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import com.mukri.help.Help;


/**
 * CopyRighted by DoomGary / Mukri
 * Please do not edit or copy without permissions.
 * Made on: 7:23:33 PM 
 */

public class MessageData {
	
	File file;
	FileConfiguration config;
	
	public MessageData() {
		file = new File(Help.getInstance().getDataFolder(), "message.yml");
		config = YamlConfiguration.loadConfiguration(file);
	}
	
	public boolean isExists() {
		return file.exists();
	}
	
	public void save() {
		try {
			config.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void createNewFile() {
		try {
			if(!file.getParentFile().exists()) {
				file.getParentFile().mkdirs();
			}
			
			file.createNewFile();
			
			config.set("No-Permissions", "&cYou have no permissions to use this commands!");
			config.set("Unkown-Command", "Unkown Command! Type /help for more info");
			
			save();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getMsg(String s) {
		return config.getString(s);
	}

}
