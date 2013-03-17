package com.dwarfholm.DHcore.data;

import org.bukkit.entity.Player;

public interface DHDataStore {
	void initialize() throws DHDataException;
	DHcorePlayer loadPlayer(int DHID);
	DHcorePlayer loadPlayer(String name);
	DHcorePlayer loadPlayer(Player who);
	void savePlayer(DHcorePlayer who);
	// notify implementations, that the plugin goes down
	// time to store any pending changes
	void shutdown();
}