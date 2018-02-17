package com.lowkeyop.fun.utilities.pool.models;

public interface List {
	void addPlayerToList(Player p);
	void sendPlayerToTable(Player p, int tableNumber);
	void holdPlayerPosition(Player p, int position);
	//TODO: Skip player if currently in match
}
