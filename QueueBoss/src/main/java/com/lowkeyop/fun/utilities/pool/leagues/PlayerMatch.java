package com.lowkeyop.fun.utilities.pool.leagues;

import java.util.ArrayList;

import com.lowkeyop.fun.utilities.pool.models.Player;

abstract class PlayerMatch implements Match {
	private int totalInnings, totalP1TOTaken, totalP2TOTaken, totalP1DefShots, totalP2DefShots, totalP1Wins,
			totalP2Wins, p1Goal, p2Goal, p1BreakNRuns, p2BreakNRuns;
	private ArrayList<GameModel> games;
	private Player player1, player2;
	boolean isForfeit;

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
		this.games = new ArrayList<GameModel>();
		this.player1 = null;
		this.player2 = null;
		this.p1BreakNRuns = 0;
		this.p2BreakNRuns = 0;
		this.isForfeit = false;
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
		this.isForfeit = false;
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

	public boolean isForfeit() {
		return isForfeit;
	}

	public void setForfeit(boolean isForfeit) {
		this.isForfeit = isForfeit;
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
		if (this.getClass().equals(EightBallPlayerMatch.class)) {
			System.out.println("Calculating 8-ball goals");
			if (tSkillLevel == 2 || oSkillLevel == 2) {
				winGoal = tSkillLevel;
			} else if (tSkillLevel > 2) {
				winGoal = tSkillLevel - 1;
			} else if (tSkillLevel == 7 && (oSkillLevel > 3)) {
				winGoal = tSkillLevel - 2;
			} else if (tSkillLevel == 7 && oSkillLevel == 2) {
				winGoal = tSkillLevel;
			}
		} else if (this.getClass().equals(NineBallPlayerMatch.class)) {
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

	public void printPrematchStats() {
		Player player1 = this.getPlayer1();
		Player player2 = this.getPlayer2();
		int p1Goal = this.calculateGoal(player1, player2);
		int p2Goal = this.calculateGoal(player2, player1);
		System.out.println("Player1 Goal: " + p1Goal + "\nPlayer2 Goal: " + p2Goal);
		this.setP1Goal(p1Goal);
		this.setP2Goal(p2Goal);

		System.out.println("Player 1: " + player1.getFullName());
		System.out.println("Player 2: " + player2.getFullName());

		System.out.println(player1.getFullName() + "- Skill Level:" + player1.getSkillLevel());
		System.out.println(player2.getFullName() + "- Skill Level:" + player2.getSkillLevel());

		System.out.println(player1.getFullName() + "- Goal:" + this.getP1Goal());
		System.out.println(player2.getFullName() + "- Goal:" + this.getP2Goal());

		System.out.println(player1.getFullName() + " - Timeouts per Game: " + player1.getTimeouts());
		System.out.println(player2.getFullName() + " - Tiemouts per Game: " + player2.getTimeouts());
	}

	public void removeLastGame() {
		// TODO Auto-generated method stub
		int gameCount = this.getGames().size();
		if (gameCount > 0) {
			this.getGames().remove(gameCount - 1);
		}
	}


	public void addInning(GameModel g) {
		// TODO Auto-generated method stub
		int inningsCount = g.getInnings();
		g.setInnings(inningsCount++);
	}

	public void subtractInning(GameModel g) {
		// TODO Auto-generated method stub
		int inningsCount = g.getInnings();
		g.setInnings(inningsCount--);
	}

	public void addNewGame() {
		GameModel newGame;
		boolean isEightBallGame = this.getClass().equals(EightBallPlayerMatch.class);
		if (isEightBallGame) {
			newGame = new EightBallGame();
		} else {
			System.out.println("It's a 9 ball game");
			newGame = new NineBallGame();
		}
		newGame.setPlayer1(this.getPlayer1());
		newGame.setPlayer2(this.getPlayer2());
		this.games.add(newGame);
	}

	public void grantForfeitGameWin(Player p, int numberOfForfeits) {
		this.setForfeit(true);
		for (int i = 0; i < numberOfForfeits; i++) {
			addNewGame();
		}
		int gameTotal = this.getGames().size();
		for (int i = gameTotal - numberOfForfeits; i < gameTotal; i++) {
			int currentIndex = gameTotal - i;
			GameModel forfeitGame = this.getGames().get(currentIndex);
			forfeitGame.setWinner(p);
			forfeitGame.setInnings(0);
			boolean isEightBallGame = this.getClass().equals(EightBallPlayerMatch.class);
			if (isEightBallGame) {

			} else {
				NineBallGame givenNineBallGame = (NineBallGame) forfeitGame;
				if (p.getUid() == this.getPlayer1().getUid()) {
					givenNineBallGame.setP1Balls(10);
				} else {
					givenNineBallGame.setP2Balls(10);
				}
				this.getGames().set(currentIndex, givenNineBallGame);
			}
		}
	}

}
