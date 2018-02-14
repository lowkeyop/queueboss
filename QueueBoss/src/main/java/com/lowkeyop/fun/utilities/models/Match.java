package com.lowkeyop.fun.utilities.models;

public interface Match {
	int calculatePointsEarned(Player p);
	int calculateTotalDefensiveShots(Player p);
	int calculateTotalWins(Player p);
	int calculateTotalTimeOutsUsed(Player p);
	int calculateTotalInnings();
	int calculateGoal(Player targetPlayer, Player opp);
	void addNewGame(String format);
	
	
}
