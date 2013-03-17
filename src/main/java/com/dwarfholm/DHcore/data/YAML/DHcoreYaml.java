package com.dwarfholm.DHcore.data.YAML;

import java.io.File;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import com.dwarfholm.DHcore.DHcore;
import com.dwarfholm.DHcore.data.DHDataException;
import com.dwarfholm.DHcore.data.DHDataStore;
import com.dwarfholm.DHcore.data.DHcorePlayer;

public class DHcoreYaml implements DHDataStore {
	@SuppressWarnings("unused")
	private DHcore plugin;
	private String filename = "playerdata.yml";
	private YamlConfiguration yamlconfig;
	private File playerdata;
	private DHcorePlayerYaml playerYaml;
	
	public DHcoreYaml(DHcore parent)	{
		plugin = parent;
		playerdata = new File(plugin.getDataFolder(), filename);
	}
	
	@Override
	public void initialize() throws DHDataException{
		YamlConfiguration yaml = new YamlConfiguration();
		playerYaml = new DHcorePlayerYaml(playerdata, yaml);
	}
	
	@Override
	public DHcorePlayer loadPlayer(int DHID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DHcorePlayer loadPlayer(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DHcorePlayer loadPlayer(Player who) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void savePlayer(DHcorePlayer who) {
		// TODO Auto-generated method stub
	}

	@Override
	public void shutdown() {

	}
}
