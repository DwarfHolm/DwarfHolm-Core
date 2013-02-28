package com.dwarfholm.DHcore.data;

import java.util.HashMap;

import org.bukkit.entity.Player;

public class DHcoreLookupList extends HashMap<String, Integer>	{

	private static final long serialVersionUID = 6098808939140527155L;

	public void put(DHcorePlayer player)	{
		super.put(player.getName(), player.getDHID());
	}
	
	public int get(Player player)	{
		return super.get(player.getName());
	}

}
