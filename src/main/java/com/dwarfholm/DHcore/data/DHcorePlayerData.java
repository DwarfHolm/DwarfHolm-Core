package com.dwarfholm.DHcore.data;

import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "DHc_Players")
public class DHcorePlayerData {
	@Id private int DHID;
	@Column(name = "name", columnDefinition = "VARCHAR(16)") private String playerName;
	@Column(name = "joined", columnDefinition = "DATETIME") private Timestamp joinTime;
	@Column(name = "lastOn", columnDefinition = "DATETIME") private Timestamp lastOnline;

	public int getDHID()	{	return DHID;	}
	public String getPlayerName()	{	return playerName;	}
	public Date getJoined()	{	return joinTime;	}
	public Date getLastOnline()	{	return lastOnline;	}
	
	public void setDHID(int DHid)	{	DHID = DHid;	}
	public void setPlayerName(String who)	{	playerName = who;	}
	public void setJoined(Date joined)	{	joinTime = (Timestamp) joined;	}
	public void setLastOnline(Date lastOn)	{	lastOnline = (Timestamp) lastOn;	}
}
