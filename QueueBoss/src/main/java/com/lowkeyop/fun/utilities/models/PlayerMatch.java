package com.lowkeyop.fun.utilities.models;

import java.util.ArrayList;

abstract class PlayerMatch implements Match {
	private int totalInnings, totalP1TOTaken, totalP2TOTaken, totalP1DefShots, totalP2DefShots, totalP1Wins,
			totalP2Wins, p1Goal, p2Goal, p1BreakNRuns, p2BreakNRuns;
	private ArrayList<GameModel> games;
	private Player player1, player2;

	public PlayerMatch() {
		super();
		this.totalInnings = 0;
		this.totalP1TOTaken = 0;
		this.totalP2TOTaken = 0;
		this.totalP1DefShots = 0;
		this.totalP2DefShots = 0;
		this.totalP1Wins = 0;
		this.totalP2Wins = 0;
		this.p1Goal = 0;
		this.p2Goal = 0;
		this.games = null;
		this.player1 = null;
		this.player2 = null;
		this.p1BreakNRuns = 0;
		this.p2BreakNRuns = 0;
		// TODO Auto-generated constructor stub
	}

	public PlayerMatch(int totalInnings, int totalP1TOTaken, int totalP2TOTaken, int totalP1DefShots,
			int totalP2DefShots, int totalP1Wins, int totalP2Wins, int p1Goal, int p2Goal, int p1BNRs, int p2BNRs,
			ArrayList<GameModel> games, Player player1, Player player2) {
		super();
		this.totalInnings = totalInnings;
		this.totalP1TOTaken = totalP1TOTaken;
		this.totalP2TOTaken = totalP2TOTaken;
		this.totalP1DefShots = totalP1DefShots;
		this.totalP2DefShots = totalP2DefShots;
		this.totalP1Wins = totalP1Wins;
		this.totalP2Wins = totalP2Wins;
		this.p1Goal = p1Goal;
		this.p2Goal = p2Goal;
		this.p1BreakNRuns = p1BNRs;
		this.p2BreakNRuns = p2BNRs;
		this.games = games;
		this.player1 = player1;
		this.player2 = player2;
	}

	public int getTotalInnings() {
		return totalInnings;
	}

	public void setTotalInnings(int totalInnings) {
		this.totalInnings = totalInnings;
	}

	public int getTotalP1TOTaken() {
		return totalP1TOTaken;
	}

	public void setTotalP1TOTaken(int totalP1TOTaken) {
		this.totalP1TOTaken = totalP1TOTaken;
	}

	public int getTotalP2TOTaken() {
		return totalP2TOTaken;
	}

	public void setTotalP2TOTaken(int totalP2TOTaken) {
		this.totalP2TOTaken = totalP2TOTaken;
	}

	public int getTotalP1DefShots() {
		return totalP1DefShots;
	}

	public void setTotalP1DefShots(int totalP1DefShots) {
		this.totalP1DefShots = totalP1DefShots;
	}

	public int getTotalP2DefShots() {
		return totalP2DefShots;
	}

	public void setTotalP2DefShots(int totalP2DefShots) {
		this.totalP2DefShots = totalP2DefShots;
	}

	public int getTotalP1Wins() {
		return totalP1Wins;
	}

	public void setTotalP1Wins(int totalP1Wins) {
		this.totalP1Wins = totalP1Wins;
	}

	public int getTotalP2Wins() {
		return totalP2Wins;
	}

	public void setTotalP2Wins(int totalP2Wins) {
		this.totalP2Wins = totalP2Wins;
	}

	public int getP1Goal() {
		return p1Goal;
	}

	public void setP1Goal(int p1Goal) {
		this.p1Goal = p1Goal;
	}

	public int getP2Goal() {
		return p2Goal;
	}

	public void setP2Goal(int p2Goal) {
		this.p2Goal = p2Goal;
	}

	public int getP1BreakNRuns() {
		return p1BreakNRuns;
	}

	public void setP1BreakNRuns(int p1BreakNRuns) {
		this.p1BreakNRuns = p1BreakNRuns;
	}

	public int getP2BreakNRuns() {
		return p2BreakNRuns;
	}

	public void setP2BreakNRuns(int p2BreakNRuns) {
		this.p2BreakNRuns = p2BreakNRuns;
	}

	public ArrayList<GameModel> getGames() {
		return games;
	}

	public void setGames(ArrayList<GameModel> games) {
		this.games = games;
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

	public int calculatePointsEarned(Player p) {
		return -1;
	}

	public int calculateTotalDefensiveShots(Player p) {
		// TODO Auto-generated method stub
		int gameCount = this.getGames().size();
		int defensiveShots = 0;
		for (int i = 0; i <= gameCount; i++) {
			GameModel game = this.getGames().get(i);

			if (p.getFirstName().equals(game.getPlayer1().getFirstName()))
				defensiveShots += game.getDefShotP1();
			else
				defensiveShots += game.getDefShotP2();
		}
		return defensiveShots;
	}

	public int calculateTotalWins(Player p) {
		int gameCount = this.getGames().size();
		int wins = 0;
		for (int i = 0; i <= gameCount; i++) {
			GameModel game = this.getGames().get(i);
			if (game.getWinner().getFirstName().equals(p.getFirstName())) {
				wins++;
			}

		}
		return wins;
	}

	public int calculateTotalTimeOutsUsed(Player p) {
		// TODO Auto-generated method stub
		int gameCount = this.getGames().size();
		int timeoutsUsed = 0;
		for (int i = 0; i <= gameCount; i++) {
			GameModel game = this.getGames().get(i);

			if (p.getFirstName().equals(game.getPlayer1().getFirstName()))
				timeoutsUsed += game.getP1TO();
			else
				timeoutsUsed += game.getP2TO();
		}
		return timeoutsUsed;
	}

	public int calculateTotalInnings() {
		// TODO Auto-generated method stub
		int gameCount = this.getGames().size();
		int inningTotal = 0;
		for (int i = 0; i <= gameCount; i++) {
			GameModel game = this.getGames().get(i);
			inningTotal += game.getInnings();
		}
		return inningTotal;
	}

	public int calculateGoal(Player targetPlayer, Player opp) {
		// TODO Auto-generated method stub
		int tSkillLevel = targetPlayer.getSkillLevel();
		int oSkillLevel = opp.getSkillLevel();
		int winGoal = 0;
		if (this.getClass().isInstance(EightBallPlayerMatch.class)) {
			if (tSkillLevel == 2) {
				winGoal = 2;
			}
			if (tSkillLevel > 2 && (oSkillLevel >= tSkillLevel)) {
				winGoal = tSkillLevel - 1;
			}
			if (tSkillLevel == 7 && (oSkillLevel < 3)) {
				winGoal = tSkillLevel - 2;
			}
			if (tSkillLevel == 7 && oSkillLevel == 2) {
				winGoal = tSkillLevel;
			}
		} else if (this.getClass().isInstance(NineBallPlayerMatch.class)) {
			switch (tSkillLevel) {
			case 1:
				winGoal = 14;
				break;
			case 2:
				winGoal = 19;
				break;
			case 3:
				winGoal = 25;
				break;
			case 4:
				winGoal = 31;
				break;
			case 5:
				winGoal = 38;
				break;
			case 6:
				winGoal = 46;
				break;
			case 7:
				winGoal = 55;
				break;
			case 8:
				winGoal = 65;
				break;
			case 9:
				winGoal = 75;
				break;
			default:
				System.out.println("Unknown skill level");
				break;
			}
		}

		return winGoal;
	}

	public void addNewGame(String format) {
		GameModel newGame;
		boolean isEightBallGame = this.getClass().isInstance(EightBallPlayerMatch.class);
		if (isEightBallGame) {
			newGame = new EightBallGame();
		} else {
			newGame = new NineBallGame();
		}
		newGame.setPlayer1(this.getPlayer1());
		newGame.setPlayer2(this.getPlayer2());
		this.games.add(newGame);
	}

}
