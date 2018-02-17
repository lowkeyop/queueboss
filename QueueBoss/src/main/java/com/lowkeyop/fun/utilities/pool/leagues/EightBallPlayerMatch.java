package com.lowkeyop.fun.utilities.pool.leagues;

import com.lowkeyop.fun.utilities.models.Player;

public class EightBallPlayerMatch extends PlayerMatch {
	private int p1EightOnBreakTotal, p2EightOnBreakTotal, p1MatchPointsEarned, p2MatchPointsEarned;
	private Player matchWinner;

	public EightBallPlayerMatch() {
		super();
		this.p1EightOnBreakTotal = 0;
		this.p2EightOnBreakTotal = 0;
		this.p1MatchPointsEarned = 0;
		this.p2MatchPointsEarned = 0;
		this.matchWinner = null;
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

	public boolean isMatchOver() {
		int p1Goal = this.getP1Goal();
		int p2Goal = this.getP2Goal();
		Player p1 = this.getPlayer1();
		Player p2 = this.getPlayer2();

		int p1GamesWon = this.getTotalP1Wins();
		int p2GamesWon = this.getTotalP2Wins();

		boolean isP1Win = p1Goal == p1GamesWon;
		boolean isP2Win = p2GamesWon == p2Goal;
		boolean isWinnerDetermined = isP1Win || isP2Win;
		if (isWinnerDetermined) {
			System.out.println("The Match is over!");
			if (isP1Win) {
				this.setMatchWinner(p1);
			} else {
				this.setMatchWinner(p2);
			}
			this.totalUpEverything();
		}
		return isWinnerDetermined;
	}

	public void totalUpEverything() {
		// total innings
		int inningTotal = this.getTotalInnings();
		this.setTotalInnings(inningTotal);

		// 8 break n runs
		int p1BNRTotal = this.getP1BreakNRuns();
		int p2BNRTotal = this.getP2BreakNRuns();
		this.setP1BreakNRuns(p1BNRTotal);
		this.setP2BreakNRuns(p2BNRTotal);

		// 8 on breaks
		int p1EOBTotal = this.getP1EightOnBreakTotal();
		int p2EOBTotal = this.getP2EightOnBreakTotal();
		this.setP1EightOnBreakTotal(p1EOBTotal);
		this.setP2EightOnBreakTotal(p2EOBTotal);

		// defensive shots
		int p1DefShotToal = this.getTotalP1DefShots();
		int p2DefShotToal = this.getTotalP2DefShots();
		this.setTotalP1DefShots(p1DefShotToal);
		this.setTotalP2DefShots(p2DefShotToal);

		// games won
		int p1GamesWon = this.getTotalP1Wins();
		int p2GamesWon = this.getTotalP2Wins();
		this.setTotalP1Wins(p1GamesWon);
		this.setTotalP2Wins(p2GamesWon);

		// match points earned
		int p1MatchPointsEarned = this.getP1MatchPointsEarned();
		int p2matchPointsEarned = this.getP2MatchPointsEarned();
		this.setP1MatchPointsEarned(p1MatchPointsEarned);
		this.setP2MatchPointsEarned(p2matchPointsEarned);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Player p1 = new Player("Cordell", "Kennerly", 6);
		Player p2 = new Player("Nick","Slate", 4);
		EightBallPlayerMatch match1 = new EightBallPlayerMatch();
		match1.setPlayer1(p1);
		match1.setPlayer2(p2);
		
		match1.printPrematchStats();
		
		match1.addNewGame();
		System.out.println("Number of Games Played: " + match1.getGames().size());
		System.out.println("Game class type " + match1.getGames().get(0).getClass());
	}

}
