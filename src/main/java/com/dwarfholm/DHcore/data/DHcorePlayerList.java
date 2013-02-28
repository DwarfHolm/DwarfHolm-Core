package com.dwarfholm.DHcore.data;

import java.util.HashMap;

public class DHcorePlayerList extends HashMap<Integer, DHcorePlayer>{
	private static final long serialVersionUID = 1812917743685899984L;

	public void put(DHcorePlayer player)	{
		super.put(player.getDHID(), player);
	}

}
