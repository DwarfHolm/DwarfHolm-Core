package com.dwarfholm.DHcore;

import org.bukkit.scheduler.BukkitTask;

import com.dwarfholm.DHcore.events.DHCalculateEvent;
import com.dwarfholm.DHcore.events.DHPeriodBeginEvent;
import com.dwarfholm.DHcore.events.DHPeriodEndEvent;

public class DHEventTimer implements Runnable{
	private DHcore plugin;
	private long intervalInTicks;
	private int calcsPerPeriod;
	private int calcsSincePeriod;
	private BukkitTask task;
	
	public DHEventTimer(DHcore parent)	{
		plugin = parent;
		intervalInTicks = 20 * 60; //Ticks per Second * Seconds Per minute
		calcsPerPeriod = 15;
	}
	public void start()	{
		calcsSincePeriod = 0;
		DHPeriodBeginEvent periodBeginEvent = new DHPeriodBeginEvent();
		plugin.getServer().getPluginManager().callEvent(periodBeginEvent);
		task = plugin.getServer().getScheduler().runTaskTimer(plugin, this, intervalInTicks, intervalInTicks);
	}
	
	public void stop()	{
		DHPeriodEndEvent periodEndEvent = new DHPeriodEndEvent();
		plugin.getServer().getPluginManager().callEvent(periodEndEvent);
		calcsSincePeriod = 0;
		task.cancel();
	}
	
	public void run() {
		DHCalculateEvent calcEvent = new DHCalculateEvent();
		plugin.getServer().getPluginManager().callEvent(calcEvent);
		if(calcsSincePeriod++ >= calcsPerPeriod) {
			DHPeriodEndEvent periodEndEvent = new DHPeriodEndEvent();
			plugin.getServer().getPluginManager().callEvent(periodEndEvent);
			calcsSincePeriod = 0;
			DHPeriodBeginEvent periodBeginEvent = new DHPeriodBeginEvent();
			plugin.getServer().getPluginManager().callEvent(periodBeginEvent);
		}
	}
}
