package com.lowkeyop.fun.utilities.models;

public class EightBallGame extends GameModel {
	private boolean eightOnBreak, earlyEight;

	public EightBallGame() {
		super();
		// TODO Auto-generated constructor stub
		this.eightOnBreak = false;
		this.earlyEight = false;
	}

	public EightBallGame(int innings, int p1to, int p2to, int defShotP1, int defShotP2, Player winner, Player player1,
			Player player2, boolean eightOnBreak, boolean breakNRun, boolean earlyEight) {
		super(innings, p1to, p2to, defShotP1, defShotP2, winner, player1, player2, breakNRun);
		this.eightOnBreak = eightOnBreak;
		this.earlyEight = earlyEight;
	}

	public boolean isEightOnBreak() {
		return eightOnBreak;
	}

	public void setEightOnBreak(boolean eightOnBreak) {
		this.eightOnBreak = eightOnBreak;
	}

	public boolean isEarlyEight() {
		return earlyEight;
	}

	public void setEarlyEight(boolean earlyEight) {
		this.earlyEight = earlyEight;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EightBallGame dConstruct = new EightBallGame();
		System.out.println(dConstruct.getDefShotP1());

		Player winningPlayer = null;
		Player player1 = new Player("Player 1", "Team 1", 5);
		Player player2 = new Player("Player 2", "Team 2", 5);
		boolean eOB = false;
		boolean bNR = true;
		boolean eE = false;
		EightBallGame oConstruct = new EightBallGame(8, 2, 2, 4, 6, winningPlayer, player1, player2, eOB, bNR, eE);
		System.out.println(oConstruct.getPlayer1().getFirstName());
		System.out.println(oConstruct.getPlayer2().getFirstName());
		System.out.println(
				oConstruct.getWinner() == null ? "No winner determined yet" : oConstruct.getWinner().getFirstName());
		System.out.println(oConstruct.isBreakNRun());
	}

}
