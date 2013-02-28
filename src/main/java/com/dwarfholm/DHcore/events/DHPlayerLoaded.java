package com.dwarfholm.DHcore.events;

import org.bukkit.entity.Player;

public class DHPlayerLoaded extends DHEvent{
	private String playerName;
	private int playerID;
	
	public DHPlayerLoaded(String who, int dhid) {
		playerName = who;
		playerID = dhid;
	}
	public DHPlayerLoaded(Player who, int dhid) {
		playerName = who.getName();
		playerID = dhid;
	}
	
	public String getPlayerName()	{	return playerName;	}
	public int getDHID()	{	return playerID;	}
}
