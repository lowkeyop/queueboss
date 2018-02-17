package com.lowkeyop.fun.utilities.pool.leagues;

import java.time.LocalTime;

public interface LeagueMatch {
	int calculateTeam1RunningTotal();
	int calculateTeam2RunningTotal();
	LocalTime retrievedCurrentTime();
}
