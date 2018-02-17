package com.lowkeyop.fun.utilities.models;

import java.time.LocalTime;

public interface LeagueMatch {
	int calculateTeam1RunningTotal();
	int calculateTeam2RunningTotal();
	LocalTime retrievedCurrentTime();
}
