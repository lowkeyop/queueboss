package com.lowkeyop.fun.utilities.pool.leagues;

import com.lowkeyop.fun.utilities.models.Player;

public interface Team {
	boolean isSkillLevelLimitReached(int limit);
	void addPlayerToTeam(Player p);
	void simulatePotentialTeamComps();
	int sumSkillLevelToPlay();
	boolean isMaxTeamSizeReached();
	boolean isAlreadyOnTeam(Player p);

}
