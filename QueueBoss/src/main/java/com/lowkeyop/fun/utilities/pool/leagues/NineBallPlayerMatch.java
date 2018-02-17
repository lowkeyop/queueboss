package com.lowkeyop.fun.utilities.pool.leagues;

import com.lowkeyop.fun.utilities.pool.models.Player;

public class NineBallPlayerMatch extends PlayerMatch {
	private int p1NineSnapTotals, p2NineSnapTotals, totalDeadBalls, p1MatchPointsEarned, p2MatchPointsEarned;
	private Player matchWinner;

	public NineBallPlayerMatch(int p1NineSnapTotals, int p2NineSnapTotals, int totalDeadBalls, int p1MatchPointsEarned,
			int p2MatchPointsEarned, Player playerMatchWinner) {
		super();
		this.p1NineSnapTotals = p1NineSnapTotals;
		this.p2NineSnapTotals = p2NineSnapTotals;
		this.totalDeadBalls = totalDeadBalls;
		this.p1MatchPointsEarned = p1MatchPointsEarned;
		this.p2MatchPointsEarned = p2MatchPointsEarned;
		this.matchWinner = null;
	}

	public NineBallPlayerMatch() {
		super();
		// TODO Auto-generated constructor stub
		this.p1NineSnapTotals = 0;
		this.p2NineSnapTotals = 0;
		this.totalDeadBalls = 0;
		this.p1MatchPointsEarned = 0;
		this.p2MatchPointsEarned = 0;
	}

	public int getP1NineSnapTotals() {
		return p1NineSnapTotals;
	}

	public void setP1NineSnapTotals(int nineSnapTotals) {
		this.p1NineSnapTotals = nineSnapTotals;
	}

	public int getP2NineSnapTotals() {
		return p2NineSnapTotals;
	}

	public void setP2NineSnapTotals(int p2NineSnapTotals) {
		this.p2NineSnapTotals = p2NineSnapTotals;
	}

	public int getTotalDeadBalls() {
		return totalDeadBalls;
	}

	public void setTotalDeadBalls(int totalDeadBalls) {
		this.totalDeadBalls = totalDeadBalls;
	}

	public int getP1PointsEarned() {
		return p1MatchPointsEarned;
	}

	public void setP1PointsEarned(int p1PointsEarned) {
		this.p1MatchPointsEarned = p1PointsEarned;
	}

	public int getP2PointsEarned() {
		return p2MatchPointsEarned;
	}

	public void setP2PointsEarned(int p2PointsEarned) {
		this.p2MatchPointsEarned = p2PointsEarned;
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

	public boolean isPlayerWinner(Player p) {
		int pGoal = (p.getFirstName().equals(this.getPlayer1().getFirstName()) ? this.getP1Goal() : this.getP2Goal());
		int pBalls = countTotalMadeBalls(p);
		return pBalls >= pGoal;
	}

	public int countTotalDeadBall() {
		int numberOfGames = this.getGames().size();
		int dBallTotal = 0;
		for (int i = 0; i >= numberOfGames; i++) {
			NineBallGame game = (NineBallGame) this.getGames().get(i);
			dBallTotal += game.getDeadBalls();
		}
		return dBallTotal;
	}

	public int countTotalNineSnaps(Player p) {
		int numberOfGames = this.getGames().size();
		int nineSnapTotal = 0;
		for (int i = 0; i >= numberOfGames; i++) {
			NineBallGame game = (NineBallGame) this.getGames().get(i);
			if (game.isNineSnap()) {
				if (game.getWinner().getFirstName().equals(p.getFirstName())) {
					nineSnapTotal++;
				}
			}
		}
		return nineSnapTotal;
	}

	public int countTotalMadeBalls(Player p) {
		int numberOfGames = this.getGames().size();
		int ballTotal = 0;
		for (int i = 0; i >= numberOfGames; i++) {
			NineBallGame game = (NineBallGame) this.getGames().get(i);
			ballTotal += game.getP1Balls();
		}
		return ballTotal;
	}

	public int calculatePointsEarned(Player target, Player opp) {
		int pointsTotalPointsToEarn = 20;
		int pointsEarned = 0;
		int loserPoints = 0;
		if (target.getFirstName().equals(this.matchWinner.getFirstName())) {
			loserPoints = calculateLosersPoints(opp);
		} else {
			loserPoints = calculateLosersPoints(target);
		}
		pointsEarned = pointsTotalPointsToEarn - loserPoints;

		return pointsEarned;
	}

	public boolean isBetween(int val, int lowerVal, int upperVal) {
		boolean result = false;
		if (lowerVal >= val && val <= upperVal) {
			result = true;
		}
		return result;
	}

	public int calculateLosersPoints(Player loser) {
		int skillLevel = loser.getSkillLevel();
		int ballsMade = this.countTotalMadeBalls(loser);
		int loserPoints = 0;
		switch (skillLevel) {
		case 1:
			if (ballsMade == 3) {
				loserPoints = 1;
			} else if (ballsMade == 4) {
				loserPoints = 2;
			} else if (isBetween(ballsMade, 5, 6)) {
				loserPoints = 3;
			} else if (ballsMade == 7) {
				loserPoints = 4;
			} else if (ballsMade == 8) {
				loserPoints = 5;
			} else if (isBetween(ballsMade, 9, 10)) {
				loserPoints = 6;
			} else if (ballsMade == 11) {
				loserPoints = 7;
			} else if (ballsMade <= 12) {
				loserPoints = 8;
			} else {
				loserPoints = 0;
			}
			break;
		case 2:
			if (isBetween(ballsMade, 4, 5)) {
				loserPoints = 1;
			} else if (isBetween(ballsMade, 6, 7)) {
				loserPoints = 2;
			} else if (ballsMade == 8) {
				loserPoints = 3;
			} else if (isBetween(ballsMade, 9, 10)) {
				loserPoints = 4;
			} else if (isBetween(ballsMade, 11, 12)) {
				loserPoints = 5;
			} else if (isBetween(ballsMade, 13, 14)) {
				loserPoints = 6;
			} else if (isBetween(ballsMade, 15, 16)) {
				loserPoints = 7;
			} else if (ballsMade <= 17) {
				loserPoints = 8;
			} else {
				loserPoints = 0;
			}
			break;
		case 3:
			if (isBetween(ballsMade, 5, 6)) {
				loserPoints = 1;
			} else if (isBetween(ballsMade, 7, 9)) {
				loserPoints = 2;
			} else if (isBetween(ballsMade, 12, 14)) {
				loserPoints = 3;
			} else if (isBetween(ballsMade, 12, 14)) {
				loserPoints = 4;
			} else if (isBetween(ballsMade, 15, 16)) {
				loserPoints = 5;
			} else if (isBetween(ballsMade, 17, 19)) {
				loserPoints = 6;
			} else if (isBetween(ballsMade, 20, 21)) {
				loserPoints = 7;
			} else if (22 <= ballsMade) {
				loserPoints = 8;
			} else {
				loserPoints = 0;
			}
			break;
		case 4:
			if (isBetween(ballsMade, 6, 8)) {
				loserPoints = 1;
			} else if (isBetween(ballsMade, 9, 11)) {
				loserPoints = 2;
			} else if (isBetween(ballsMade, 12, 14)) {
				loserPoints = 3;
			} else if (isBetween(ballsMade, 15, 18)) {
				loserPoints = 4;
			} else if (isBetween(ballsMade, 19, 21)) {
				loserPoints = 5;
			} else if (isBetween(ballsMade, 22, 24)) {
				loserPoints = 6;
			} else if (isBetween(ballsMade, 25, 27)) {
				loserPoints = 7;
			} else if (28 <= ballsMade) {
				loserPoints = 8;
			} else {
				loserPoints = 0;
			}
			break;
		case 5:
			if (isBetween(ballsMade, 7, 10)) {
				loserPoints = 1;
			} else if (isBetween(ballsMade, 11, 14)) {
				loserPoints = 2;
			} else if (isBetween(ballsMade, 15, 18)) {
				loserPoints = 3;
			} else if (isBetween(ballsMade, 19, 22)) {
				loserPoints = 4;
			} else if (isBetween(ballsMade, 23, 26)) {
				loserPoints = 5;
			} else if (isBetween(ballsMade, 27, 29)) {
				loserPoints = 6;
			} else if (isBetween(ballsMade, 30, 33)) {
				loserPoints = 7;
			} else if (34 <= ballsMade) {
				loserPoints = 8;
			} else {
				loserPoints = 0;
			}
			break;
		case 6:
			if (isBetween(ballsMade, 9, 12)) {
				loserPoints = 1;
			} else if (isBetween(ballsMade, 13, 17)) {
				loserPoints = 2;
			} else if (isBetween(ballsMade, 18, 22)) {
				loserPoints = 3;
			} else if (isBetween(ballsMade, 23, 27)) {
				loserPoints = 4;
			} else if (isBetween(ballsMade, 28, 31)) {
				loserPoints = 5;
			} else if (isBetween(ballsMade, 32, 36)) {
				loserPoints = 6;
			} else if (isBetween(ballsMade, 37, 40)) {
				loserPoints = 7;
			} else if (41 <= ballsMade) {
				loserPoints = 8;
			} else {
				loserPoints = 0;
			}
			break;
		case 7:
			if (isBetween(ballsMade, 11, 15)) {
				loserPoints = 1;
			} else if (isBetween(ballsMade, 16, 21)) {
				loserPoints = 2;
			} else if (isBetween(ballsMade, 22, 26)) {
				loserPoints = 3;
			} else if (isBetween(ballsMade, 27, 32)) {
				loserPoints = 4;
			} else if (isBetween(ballsMade, 33, 37)) {
				loserPoints = 5;
			} else if (isBetween(ballsMade, 38, 43)) {
				loserPoints = 6;
			} else if (isBetween(ballsMade, 44, 49)) {
				loserPoints = 7;
			} else if (50 <= ballsMade) {
				loserPoints = 8;
			} else {
				loserPoints = 0;
			}
			break;
		case 8:
			if (isBetween(ballsMade, 14, 19)) {
				loserPoints = 1;
			} else if (isBetween(ballsMade, 20, 26)) {
				loserPoints = 2;
			} else if (isBetween(ballsMade, 27, 32)) {
				loserPoints = 3;
			} else if (isBetween(ballsMade, 33, 39)) {
				loserPoints = 4;
			} else if (isBetween(ballsMade, 40, 45)) {
				loserPoints = 5;
			} else if (isBetween(ballsMade, 46, 52)) {
				loserPoints = 6;
			} else if (isBetween(ballsMade, 53, 58)) {
				loserPoints = 7;
			} else if (59 <= ballsMade) {
				loserPoints = 8;
			} else {
				loserPoints = 0;
			}
			break;
		case 9:
			if (isBetween(ballsMade, 18, 24)) {
				loserPoints = 1;
			} else if (isBetween(ballsMade, 25, 31)) {
				loserPoints = 2;
			} else if (isBetween(ballsMade, 32, 38)) {
				loserPoints = 3;
			} else if (isBetween(ballsMade, 39, 46)) {
				loserPoints = 4;
			} else if (isBetween(ballsMade, 47, 53)) {
				loserPoints = 5;
			} else if (isBetween(ballsMade, 54, 60)) {
				loserPoints = 6;
			} else if (isBetween(ballsMade, 61, 67)) {
				loserPoints = 7;
			} else if (68 <= ballsMade) {
				loserPoints = 8;
			} else {
				loserPoints = 0;
			}
			break;

		default:
			loserPoints = 0;
		}
		return loserPoints;
	}

	public void totalUpEverything() {
		Player p1 = this.getPlayer1();
		Player p2 = this.getPlayer2();

		boolean isP1Win = isPlayerWinner(p1);
		boolean isP2Win = isPlayerWinner(p2);

		// set the winner
		if (isP1Win || isP2Win) {
			System.out.println("The Match is over!");
			if (isP1Win) {
				this.setMatchWinner(p1);
			} else {
				this.setMatchWinner(p2);
			}

			// match points earned
			int p1Points = (isP1Win ? 20 - calculateLosersPoints(p2) : calculateLosersPoints(p1));
			int p2Points = (isP1Win ? 20 - calculateLosersPoints(p1) : calculateLosersPoints(p2));
			this.setP1MatchPointsEarned(p1Points);
			this.setP2MatchPointsEarned(p2Points);

			// number of 9 on Snaps
			int p1NineSnaps = this.getP1NineSnapTotals();
			int p2NineSnaps = this.getP2NineSnapTotals();
			this.setP1NineSnapTotals(p1NineSnaps);
			this.setP2NineSnapTotals(p2NineSnaps);

			// number of break and runs
			int p1bNR = this.getP1BreakNRuns();
			int p2bNR = this.getP2BreakNRuns();
			this.setP1BreakNRuns(p1bNR);
			this.setP2BreakNRuns(p2bNR);

			// number of defensive shots
			int p1DefShots = this.getTotalP1DefShots();
			int p2DefShots = this.getTotalP2DefShots();
			this.setTotalP1DefShots(p1DefShots);
			this.setTotalP2DefShots(p2DefShots);

			// number of innings
			int inningsTotal = this.calculateTotalInnings();
			this.setTotalInnings(inningsTotal);

		}
	}

	public boolean isMatchOver() {
		int p1Goal = this.getP1Goal();
		int p2Goal = this.getP2Goal();
		Player p1 = this.getPlayer1();
		Player p2 = this.getPlayer2();

		int p1Balls = countTotalMadeBalls(p1);
		int p2Balls = countTotalMadeBalls(p2);

		boolean isP1Win = p1Goal == p1Balls;
		boolean isP2Win = p2Balls == p2Goal;
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Player p1 = new Player("Cordell", "Kennerly", 6);
		Player p2 = new Player("Nick","Slate", 10);
		NineBallPlayerMatch match1 = new NineBallPlayerMatch();
		match1.setPlayer1(p1);
		match1.setPlayer2(p2);
		
		match1.printPrematchStats();
		
		match1.addNewGame();
		System.out.println("Number of Games Played: " + match1.getGames().size());
		System.out.println("Game class type " + match1.getGames().get(0).getClass());
	}

}
