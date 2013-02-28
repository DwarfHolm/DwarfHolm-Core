package com.dwarfholm.DHcore.data;

import org.bukkit.entity.Player;

import com.dwarfholm.DHcore.DHcore;

public class DHcoreFlatFile implements DHDataStore {
	@SuppressWarnings("unused")
	private DHcore plugin;
	
	public DHcoreFlatFile(DHcore parent)	{
		plugin = parent;
	}
	
	@Override
	public void initialize() throws DHDataException{
		// TODO Auto-generated method stub
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
