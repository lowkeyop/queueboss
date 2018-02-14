package com.lowkeyop.fun.utilities.models;

public class EightBallPlayerMatch extends PlayerMatch {
	private int p1EightOnBreakTotal, p2EightOnBreakTotal, p1MatchPointsEarned, p2MatchPointsEarned;
	private Player matchWinner;

	public EightBallPlayerMatch() {
		super();
		this.p1EightOnBreakTotal = 0;
		this.p2EightOnBreakTotal = 0;
		this.p1MatchPointsEarned=0;
		this.p2MatchPointsEarned=0;
	}

	public EightBallPlayerMatch(int p1EightOnBreakTotal, int p2EightOnBreakTotal, int p1MatchPointsEarned,
			int p2MatchPointsEarned, Player matchWinner) {
		super();
		this.p1EightOnBreakTotal = p1EightOnBreakTotal;
		this.p2EightOnBreakTotal = p2EightOnBreakTotal;
		this.p1MatchPointsEarned = p1MatchPointsEarned;
		this.p2MatchPointsEarned = p2MatchPointsEarned;
		this.matchWinner = matchWinner;
	}



	public int getP1EightOnBreakTotal() {
		return p1EightOnBreakTotal;
	}

	public void setP1EightOnBreakTotal(int p1EightOnBreakTotal) {
		this.p1EightOnBreakTotal = p1EightOnBreakTotal;
	}

	public int getP2EightOnBreakTotal() {
		return p2EightOnBreakTotal;
	}

	public void setP2EightOnBreakTotal(int p2EightOnBreakTotal) {
		this.p2EightOnBreakTotal = p2EightOnBreakTotal;
	}

	public int getP1MatchPointsEarned() {
		return p1MatchPointsEarned;
	}

	public void setP1MatchPointsEarned(int p1MatchPointsEarned) {
		this.p1MatchPointsEarned = p1MatchPointsEarned;
	}

	public int getP2MatchPointsEarned() {
		return p2MatchPointsEarned;
	}

	public void setP2MatchPointsEarned(int p2MatchPointsEarned) {
		this.p2MatchPointsEarned = p2MatchPointsEarned;
	}

	public Player getMatchWinner() {
		return matchWinner;
	}

	public void setMatchWinner(Player matchWinner) {
		this.matchWinner = matchWinner;
	}

	public int calculatePointsEarned(Player target) {
		int winGoal;
		int pointsEarned = 0;
		int totalWins;
		if (target.getFirstName().equals(this.getPlayer1().getFirstName())) {
			winGoal = this.getP1Goal();
			totalWins = this.getTotalP1Wins();
		} else {
			winGoal = this.getP2Goal();
			totalWins = this.getTotalP2Wins();
		}
		if (winGoal - totalWins == 1) {
			pointsEarned = 1;
		}
		if (winGoal - totalWins < 1) {
			pointsEarned = 0;
		} else
			pointsEarned = 3;

		return pointsEarned;
	}

	public int calculate8OnBreaks(Player target) {
		int gameCount = this.getGames().size();
		int eOnBreakCount = 0;
		for (int i = 0; i <= gameCount; i++) {
			if (target.getFirstName().equals(this.getMatchWinner().getFirstName())) {
				EightBallGame game = (EightBallGame) this.getGames().get(i);
				eOnBreakCount = (game.isEightOnBreak() ? eOnBreakCount++ : eOnBreakCount);
			}
			if (target.getFirstName().equals(this.getMatchWinner().getFirstName())) {
				EightBallGame game = (EightBallGame) this.getGames().get(i);
				eOnBreakCount = (game.isEightOnBreak() ? eOnBreakCount++ : eOnBreakCount);
			}
		}
		return eOnBreakCount;
	}
	public int calculateBreakAndRuns(Player target) {
		int gameCount = this.getGames().size();
		int bNRunCount = 0;
		for (int i = 0; i <= gameCount; i++) {
			if (target.getFirstName().equals(this.getMatchWinner().getFirstName())) {
				EightBallGame game = (EightBallGame) this.getGames().get(i);
				bNRunCount = (game.isBreakNRun() ? bNRunCount++ : bNRunCount);
			}
			if (target.getFirstName().equals(this.getMatchWinner().getFirstName())) {
				EightBallGame game = (EightBallGame) this.getGames().get(i);
				bNRunCount = (game.isBreakNRun() ? bNRunCount++ : bNRunCount);
			}
		}
		return bNRunCount;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
