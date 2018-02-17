package com.lowkeyop.fun.utilities.models;

public interface Match {
	int calculatePointsEarned(Player p);
	int calculateTotalDefensiveShots(Player p);
	int calculateTotalWins(Player p);
	int calculateTotalTimeOutsUsed(Player p);
	int calculateTotalInnings();
	int calculateGoal(Player targetPlayer, Player opp);
	boolean isMatchOver();
	void addNewGame();
	void removeLastGame();
	void totalUpEverything();
	void addInning(GameModel g);
	void subtractInning(GameModel g);
	void printPrematchStats();
	void grantForfeitGameWin(Player winRecipient, int gamesToForfeit);
//	void forfeitAllGames(Player winsRecipient);
	
}
