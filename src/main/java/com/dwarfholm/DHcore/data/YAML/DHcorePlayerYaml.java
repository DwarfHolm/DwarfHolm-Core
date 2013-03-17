package com.dwarfholm.DHcore.data.YAML;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

public class DHcorePlayerYaml {
	private String configBase;
	private YamlConfiguration yaml;
	private File file;
	
	
	public DHcorePlayerYaml(File playerdata, YamlConfiguration yaml) {
		this.configBase = "players";
		this.yaml = yaml;
		this.file = file;
	}

	

	public synchronized void load() throws IOException, InvalidConfigurationException {
		if( yaml == null ) {
			this.yaml = new YamlConfiguration();
		}
		if( file.exists() ) {
			yaml.load(file);
		}
	}
	public void save() throws IOException {
		if( yaml != null )
			yaml.save(file);
	}
}
