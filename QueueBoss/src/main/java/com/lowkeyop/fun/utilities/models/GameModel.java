package com.lowkeyop.fun.utilities.models;

abstract class GameModel {
	private int innings, p1TO, p2TO, defShotP1, defShotP2;
	private Player winner, player1, player2;
	private boolean breakNRun;
	

	public GameModel() {
		super();
		this.innings = 0;
		p1TO = 2;
		p2TO = 2;
		this.defShotP1 = 0;
		this.defShotP2 = 0;
		this.winner = null;
		this.player1 = new Player();
		this.player2 = new Player();
		this.breakNRun = false;
		// TODO Auto-generated constructor stub
	}

	public GameModel(int innings, int p1to, int p2to, int defShotP1, int defShotP2, Player winner, Player player1,
			Player player2, boolean bnr) {
		super();
		this.innings = innings;
		p1TO = p1to;
		p2TO = p2to;
		this.defShotP1 = defShotP1;
		this.defShotP2 = defShotP2;
		this.winner = winner;
		this.player1 = player1;
		this.player2 = player2;
		this.breakNRun = bnr;
	}
	public void incrementInnings() {
		this.setInnings(this.innings++);
	}
	public int getInnings() {
		return innings;
	}

	public void setInnings(int innings) {
		this.innings = innings;
	}

	public int getP1TO() {
		return p1TO;
	}

	public void setP1TO(int p1to) {
		p1TO = p1to;
	}

	public int getP2TO() {
		return p2TO;
	}

	public void setP2TO(int p2to) {
		p2TO = p2to;
	}

	public int getDefShotP1() {
		return defShotP1;
	}

	public void setDefShotP1(int defShotP1) {
		this.defShotP1 = defShotP1;
	}

	public int getDefShotP2() {
		return defShotP2;
	}

	public void setDefShotP2(int defShotP2) {
		this.defShotP2 = defShotP2;
	}

	public Player getWinner() {
		return winner;
	}

	public void setWinner(Player winner) {
		this.winner = winner;
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

	public boolean isBreakNRun() {
		return breakNRun;
	}

	public void setBreakNRun(boolean breakNRun) {
		this.breakNRun = breakNRun;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
