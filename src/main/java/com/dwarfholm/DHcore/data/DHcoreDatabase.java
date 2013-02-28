package com.dwarfholm.DHcore.data;

import java.util.List;

import javax.persistence.PersistenceException;

import org.bukkit.entity.Player;

import com.avaje.ebean.Query;
import com.dwarfholm.DHcore.DHcore;

public class DHcoreDatabase implements DHDataStore {
	private final DHcore plugin;
	
	public DHcoreDatabase(DHcore parent){
		plugin = parent;
		checkDDL();
	}
	
	@Override
	public void initialize() throws DHDataException {
		// TODO Auto-generated method stub
	}	
	
	private void checkDDL() {
		try{
			// check access to table
			plugin.getDatabase().find(DHcorePlayerData.class).findRowCount();
		} catch(PersistenceException e) {
			// error means tables does not exis$t, create it
			plugin.installDDL();
		}
	}

	@Override
	public void shutdown() {
		// TODO Auto-generated method stub

	}

	@Override
	public DHcorePlayer loadPlayer(int DHID) {
		Query<DHcorePlayerData> query = plugin.getDatabase().find(DHcorePlayerData.class);
		query.where().eq("ID", DHID);
		query.setMaxRows(1);
		//execute query
		List<DHcorePlayerData> row = query.findList();
		if (row == null || row.size() == 0)
			return null;
		else	{
			DHcorePlayer player = new DHcorePlayer();
			player.setDHID( row.get(0).getDHID() );
			player.setName( row.get(0).getPlayerName() );
			player.setJoinTime( row.get(0).getJoined() );
			player.setLastOn( row.get(0).getLastOnline() );
			return player;
		}
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
}
