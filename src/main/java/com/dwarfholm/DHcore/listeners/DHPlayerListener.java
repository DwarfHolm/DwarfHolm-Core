package com.dwarfholm.DHcore.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import com.dwarfholm.DHcore.DHcore;

public class DHPlayerListener implements Listener {
	@SuppressWarnings("unused")
	private final DHcore plugin;
	
	public DHPlayerListener(final DHcore parent)	{
		plugin = parent;
	}
	
	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerJoined(final PlayerJoinEvent event)	{
		
	}
	
	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerJoined(final PlayerQuitEvent event)	{
		
	}
}