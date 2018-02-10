package com.lowkeyop.fun.utilities;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

import com.lowkeyop.fun.utilities.models.List;
import com.lowkeyop.fun.utilities.models.Player;
import com.lowkeyop.fun.utilities.models.Table;

public class PoolTableList implements List {

	private int currentPosition, tableAmount, unAvailableTables;
	private HashMap<Integer, Player> playerList;
	private HashMap<Integer, Table> tableList;

	public PoolTableList(HashMap<Integer, Player> playerList, HashMap<Integer, Table> tList) {
		super();
		this.playerList = playerList;
		this.tableList = tList;
		this.currentPosition = 0;
		this.setTableAmount(0);
	}

	public PoolTableList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCurrentPosition() {
		return currentPosition;
	}

	public void setCurrentPosition(int currentPosition) {
		this.currentPosition = currentPosition;
	}

	public int getTableAmount() {
		return tableAmount;
	}

	public void setTableAmount(int tableAmount) {
		this.tableAmount = tableAmount;
	}

	public int getAvailableTableCount() {
		return tableAmount - unAvailableTables;
	}
	public int getUnAvailableTables() {
		return unAvailableTables;
	}

	public void setUnAvailableTables(int unAvailableTables) {
		this.unAvailableTables = unAvailableTables;
	}

	public HashMap<Integer, Player> getPlayerList() {
		return playerList;
	}

	public void setPlayerList(HashMap<Integer, Player> playerList) {
		this.playerList = playerList;
	}

	public HashMap<Integer, Table> getTableList() {
		return tableList;
	}

	public void setTableList(HashMap<Integer, Table> tableList) {
		this.tableList = tableList;
	}

	public void addPlayerToList(Player p) {
		boolean playerExistsCheck = false;
		Collection<Player> players = this.playerList.values();
		int tempIndex = 0;
		for (Iterator<Player> iterator = players.iterator(); iterator.hasNext();) {
			tempIndex++;
			Player player = (Player) iterator.next();
			if (player.getId() == p.getId()) {
				System.out.println(p.getFullName() + " is already on the list. " + p.getFullName()
						+ " currently at position: " + tempIndex);
				playerExistsCheck = true;
			}
		}
		if (!playerExistsCheck) {
			this.setCurrentPosition(this.getCurrentPosition() + 1);
			this.playerList.put(this.getCurrentPosition(), p);
		}
	}

	public void addTable(Table t) {
		this.setTableAmount(this.getTableAmount() + 1);
		this.tableList.put(this.getTableAmount(), t);
	}

	public void sendPlayerToTable(Player p, int tableNumber) {
		Table selectedTable = this.tableList.get(tableNumber);
		if (selectedTable.isFreeTable() || selectedTable.isOpenTable()) {
			selectedTable.addToTable(p, tableNumber);
		} else {
			System.out.println("No available spots at table " + tableNumber + " for " + p.getFullName());
		}

	}

	public void sendNextPlayerToMatch() {
		Player playerUpNext = this.getPlayerList().get(1);
		Set<Integer> tableNumbers = this.getTableList().keySet();

		for (Iterator<Integer> iterator = tableNumbers.iterator(); iterator.hasNext();) {
			Integer tableNum = (Integer) iterator.next();
			Table tableToCheck = this.getTableList().get(tableNum);
			if (tableToCheck.isOpenTable()) {
				sendPlayerToTable(playerUpNext, tableNum);
				this.playerList.remove(1);
				int newIndex = 1;
				HashMap<Integer, Player> tempMap = new HashMap<Integer, Player>();
				Iterator<Entry<Integer, Player>> list = this.playerList.entrySet().iterator();
				while (list.hasNext()) {
					Map.Entry<Integer, Player> playerPair = (Entry<Integer, Player>) list.next();
					Player itemPlayer = playerPair.getValue();
					tempMap.put(newIndex, itemPlayer);
					newIndex++;
				}
				this.setPlayerList(tempMap);
				break;
			} else {
				sendPlayerToTable(playerUpNext, tableNum);
				if (!tableToCheck.isOpenTable()) {
					this.unAvailableTables++;
				}
			}
		}
	}

	public void sendMaxPlayersToTable() {
		System.out.println("Sending as many players possible to available tables");
		int playerListSize = this.playerList.size();
		System.out.println("There's " + playerListSize + " people left on the list");
		for (int i = 1; i <= playerListSize; i++) {
			if (this.getAvailableTableCount() > 0) {
				this.sendNextPlayerToMatch();
			}
		}
		playerListSize = this.playerList.size();
		System.out.println("After list purge, there's " + playerListSize + " people left on the list");
	}

	public void viewPlayerList() {
		System.out.println("Displaying all players on the list and their position");
		int playerListSize = this.playerList.size();
		for (int i = 1; i <= playerListSize; i++) {
			System.out.println(this.playerList.get(i).getFullName() + " Position => " + (i == 1 ? "NEXT" : i));
		}
	}

	public void holdPlayerPosition(Player p, int position) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Player p1 = new Player("Cordell", "Kennerly", "8-ball", UUID.randomUUID().toString());
		Player p2 = new Player("Jon", "Smith", "8-ball", UUID.randomUUID().toString());
		Player p3 = new Player("Al", "Jones", "8-ball", UUID.randomUUID().toString());
		Player p4 = new Player("Jeff", "Fredicks", "8-ball", UUID.randomUUID().toString());
		Player p5 = new Player("Jim", "Jones", "8-ball", UUID.randomUUID().toString());
		Player p6 = new Player("Jillian", "Doh", "8-ball", UUID.randomUUID().toString());
		Table table1 = new Table();
		Table table2 = new Table();
		Table table3 = new Table();
		Table table4 = new Table();
		Table table5 = new Table("8-ball", p5, p6);

		HashMap<Integer, Player> pList = new HashMap<Integer, Player>();
		HashMap<Integer, Table> tList = new HashMap<Integer, Table>();

		PoolTableList ptl = new PoolTableList(pList, tList);

		// adding players
		ptl.addPlayerToList(p1);
		ptl.addPlayerToList(p2);
		ptl.addPlayerToList(p3);
		ptl.addPlayerToList(p4);
		ptl.addPlayerToList(p1);
		ptl.addPlayerToList(p3);
		ptl.addPlayerToList(p5);
		ptl.addPlayerToList(p6);

		// adding layers
		ptl.addTable(table1);
		ptl.addTable(table2);
		ptl.addTable(table3);
		ptl.addTable(table4);
		ptl.addTable(table5);

		System.out.println("Amount of tables: " + ptl.getTableList().size());
		System.out.println("Amount of player: " + ptl.getPlayerList().size());

		System.out.println();
		ptl.viewPlayerList();
		System.out.println();
		ptl.sendNextPlayerToMatch();
		ptl.sendNextPlayerToMatch();
		ptl.viewPlayerList();
		ptl.sendMaxPlayersToTable();
		ptl.viewPlayerList();

	}

}
