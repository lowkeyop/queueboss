package com.lowkeyop.fun.utilities.pool.leagues;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class EightBallLeagueMatch implements LeagueMatch {

	private ApaTeam homeTeam, awayTeam;
	private EightBallLeagueMatch[] matches;
	LocalTime startTime, endTime;
	int homeTeamPoints, awayTeamPoints;

	private static int TOTAL_LEAGUE_MATCHES = 5;
	
	public EightBallLeagueMatch() {
		super();
		// TODO Auto-generated constructor stub
		this.homeTeam = null;
		this.awayTeam = null;
		this.matches = new EightBallLeagueMatch[TOTAL_LEAGUE_MATCHES];
		this.startTime = null;
		this.endTime = null;
		this.homeTeamPoints = 0;
		this.awayTeamPoints = 0;
	}

	public EightBallLeagueMatch(ApaTeam homeTeam, ApaTeam awayTeam, EightBallLeagueMatch[] matches, LocalTime startTime,
			LocalTime endTime, int homeTeamPoints, int awayTeamPoints) {
		super();
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.matches = matches;
		this.startTime = startTime;
		this.endTime = endTime;
		this.homeTeamPoints = homeTeamPoints;
		this.awayTeamPoints = awayTeamPoints;
	}

	public ApaTeam getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(ApaTeam homeTeam) {
		this.homeTeam = homeTeam;
	}

	public ApaTeam getAwayTeam() {
		return awayTeam;
	}

	public void setAwayTeam(ApaTeam awayTeam) {
		this.awayTeam = awayTeam;
	}

	public EightBallLeagueMatch[] getMatches() {
		return matches;
	}

	public void setMatches(EightBallLeagueMatch[] matches) {
		this.matches = matches;
	}

	
	public int calculateTeam1RunningTotal() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public int calculateTeam2RunningTotal() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public LocalTime retrievedCurrentTime() {
		// TODO Auto-generated method stub
		return LocalDateTime.now().toLocalTime();
	}

	public static void main(String[] args) {
	}
}
