package com.lowkeyop.fun.utilities.models;

public interface Team {
	boolean isSkillLevelLimitReached(int limit);
	void addPlayerToTeam(Player p);
	void simulatePotentialTeamComps();
	int sumSkillLevelToPlay();
	boolean isMaxTeamSizeReached();
	boolean isAlreadyOnTeam(Player p);

}
