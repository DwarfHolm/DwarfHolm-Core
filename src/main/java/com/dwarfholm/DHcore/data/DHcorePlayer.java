package com.dwarfholm.DHcore.data;

import java.util.Date;


public class DHcorePlayer {
	private int DHID;
	private String name;
	private Date joinTime;
	private Date lastOnline;
	
	public int getDHID() {
		return DHID;
	}
	public void setDHID(int dHID) {
		DHID = dHID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getJoinTime() {
		return joinTime;
	}
	public void setJoinTime(Date joinTime) {
		this.joinTime = joinTime;
	}
	public Date getLastOn() {
		return lastOnline;
	}
	public void setLastOn(Date lastOn) {
		this.lastOnline = lastOn;
	}
	
}
