package com.mukri.help.file;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import com.mukri.help.Help;


/**
 * CopyRighted by DoomGary / Mukri
 * Please do not edit or copy without permissions.
 * Made on: 4:17:35 PM 
 */

public class SettingsData {
	
	File file;
	FileConfiguration config;
	
	public SettingsData() {
		file = new File(Help.getInstance().getDataFolder(), "settings.yml");
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
	
	public boolean containsPage(String page) {
		List<String> key = new ArrayList<>();
		boolean b = false;
		key.addAll(config.getKeys(false));
		
		for(int i = 0; i < key.size(); i++) {
			if(key.get(i).equalsIgnoreCase(page)) {
				b = true;
			}
		}
		
		key.clear();
		
		if(b) {
			return true;
		}
		return false;
	}
	
	public String getPageName(String page) {
		List<String> key = new ArrayList<>();
		key.addAll(config.getKeys(false));
		
		for(int i = 0; i < key.size(); i++) {
			if(key.get(i).equalsIgnoreCase(page)) {
				page = key.get(i);
			}
		}
		
		return page;
	}
	
	public String getPermissions(String page) {
		return config.getString(page + ".perm");
	}
	
	public List<String> getTextFromList(String page) {
		if(containsPage(page)) {
			return config.getStringList(page + ".Text");
		}
		return null;
	}
	
	public boolean usePermissions(String page) {
		return config.getBoolean(page + ".Use-Permissions");
	}
	
	public void createNewFile() {
		try {
			if(!file.getParentFile().exists()) {
				file.getParentFile().mkdirs();
			}
			
			List<String> p1 = new ArrayList<>();
			List<String> p2 = new ArrayList<>();
			
			p1.add("This is the page one!");
			p1.add("&cThis also have color supports!");
			p1.add("And Multi line!");
			
			p2.add("&cALSO unlimited page!");
			p2.add("Hello %player%! /help 2 for more info etc...");
			
			file.createNewFile();
			
			config.set("1.Text", p1);
			config.set("1.perm", "lol.perm");
			config.set("1.Use-Permissions", true);
			config.set("2.Text", p2);
			config.set("2.perm", "lol.perm");
			config.set("2.Use-Permissions", false);
			
			save();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
