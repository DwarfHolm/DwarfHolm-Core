package com.dwarfholm.DHcore;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.dwarfholm.DHcore.data.DHDataStore;
import com.dwarfholm.DHcore.data.DHcoreLookupList;
import com.dwarfholm.DHcore.data.DHcorePlayerList;
import com.dwarfholm.DHcore.data.DHcorePlayer;
import com.dwarfholm.DHcore.data.YAML.DHcoreYaml;
import com.dwarfholm.DHcore.data.database.DHcoreDatabase;
import com.dwarfholm.DHcore.listeners.DHPlayerListener;

public class DHcore extends JavaPlugin {
	private static final Logger log = Logger.getLogger("DHcore");
	private VaultHandler vault;
	private DHEventTimer eventTimer = new DHEventTimer(this);
	private DHPlayerListener playerListener;
	private DHDataStore dataStorage;
	@SuppressWarnings("unused")
	private DHcoreLookupList playerLookup;
	@SuppressWarnings("unused")
	private DHcorePlayerList onlinePlayers;
	
	public void onLoad()	{
	}
	public void onEnable()	{
		vault.connect();
		
		//load config
		FileConfiguration config = getConfig();
		config.options().copyDefaults(true);
		saveConfig();

		//create data storage
		if("flatfile".equalsIgnoreCase(config.getString("datastore"))) {
			// flat-file persistence
			dataStorage = new DHcoreYaml(this);
		}else{
			// database persistence
			dataStorage = new DHcoreDatabase(this);
		}// listeners;
		
		
		
		// create listeners
		playerListener = new DHPlayerListener(this);
		//register listeners
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(playerListener,this);
		//start event timer
		eventTimer.start();
	}
	
	public void onDisable()	{
		eventTimer.stop();
		
		
		playerListener = null;
				
		dataStorage.shutdown();
		dataStorage = null;
		
		vault.disconnect();
	}
	
	public static void info(String msg)	{	log(Level.INFO, msg);	}
	public static void warning(String msg)	{	log(Level.WARNING, msg);	}
	public static void severe(String msg)	{	log(Level.SEVERE, msg);	}
	public static void log(Level level, String msg)	{	log.log(level, msg);	}
	
	@Override
	public List<Class<?>> getDatabaseClasses() {
		// register database beans/pojos
		List<Class<?>> classes = new LinkedList<Class<?>>();
		
		// add all beans here
		classes.add(DHcorePlayer.class);
		// ... add other beans
		// return the complete list
		return classes;
	}
	
	public void installDDL()	{
		super.installDDL();
	}
}
