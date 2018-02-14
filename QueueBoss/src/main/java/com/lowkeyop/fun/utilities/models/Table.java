package com.lowkeyop.fun.utilities.models;

public class Table {

	private String format;
	private Player player1, player2, winner;
	private boolean isPlayer1SpotAvailable, isPlayer2SpotAvailable, isMatchComplete;

	public Table(String format, Player player1, Player player2) {
		super();
		this.format = format;
		this.player1 = player1;
		this.player2 = player2;
		this.isPlayer1SpotAvailable = false;
		this.isPlayer2SpotAvailable = false;
	}

	public Table() {
		super();
		// TODO Auto-generated constructor stub
		this.format = "8-Ball";
		this.player1 = new Player();
		this.player2 = new Player();
		this.isPlayer1SpotAvailable = true;
		this.isPlayer2SpotAvailable = true;
	}

	public void addToTable(Player p, int tNumber) {
		if (this.isPlayer1SpotAvailable() || this.isFreeTable()) {
			this.setPlayer1(p);
			this.setPlayer1SpotAvailable(false);
			System.out.println(p.getFullName() + " has been sent to table " + tNumber + " as player 1");
		} else if (this.isPlayer2SpotAvailable()) {
			this.setPlayer2(p);
			this.setPlayer2SpotAvailable(false);
			System.out.println(p.getFullName() + " has been sent to table " + tNumber + " as player 2");
		}
	}

	public void matchResults() {
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public Player getPlayer1() {
		return player1;
	}

	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}

	public Player getWinner() {
		return winner;
	}

	public void setWinner(Player winner) {
		this.winner = winner;
	}

	public boolean isPlayer1SpotAvailable() {
		return isPlayer1SpotAvailable;
	}

	public void setPlayer1SpotAvailable(boolean isPlayer1SpotAvailable) {
		this.isPlayer1SpotAvailable = isPlayer1SpotAvailable;
	}

	public boolean isPlayer2SpotAvailable() {
		return isPlayer2SpotAvailable;
	}

	public void setPlayer2SpotAvailable(boolean isPlayer2SpotAvailable) {
		this.isPlayer2SpotAvailable = isPlayer2SpotAvailable;
	}

	public boolean isMatchComplete() {
		return isMatchComplete;
	}

	public void setMatchComplete(boolean isMatchComplete) {
		this.isMatchComplete = isMatchComplete;
	}

	public boolean isOpenTable() {
		return this.isPlayer1SpotAvailable || this.isPlayer2SpotAvailable;
	}

	public boolean isFreeTable() {
		return this.isPlayer1SpotAvailable && this.isPlayer2SpotAvailable;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Player p1 = new Player("Cordell", "Kennerly",4);
		Player p2 = new Player("Jon", "Smith", 4);
		Player p3 = new Player("Al", "Jones",4);
		Table table1 = new Table();
		table1.addToTable(p1, 1);
		table1.addToTable(p2, 1);
		table1.addToTable(p3, 1);
	}

}
