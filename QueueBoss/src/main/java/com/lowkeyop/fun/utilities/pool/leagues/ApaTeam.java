package com.lowkeyop.fun.utilities.pool.leagues;

import java.util.ArrayList;
import java.util.Iterator;

import com.lowkeyop.fun.utilities.pool.models.Player;

public class ApaTeam implements Team {
	private ArrayList<Player> team;
	private static int APA_MAX_SUM_SKILL_LEVEL = 23, APA_MAX_TEAM_SIZE = 8;
	private ArrayList<Player> alreadyPlayedMembers;
	private Player captain, coCaptain;
	private String teamName;
	private String locationAddress;

	public ApaTeam() {
		super();
		// TODO Auto-generated constructor stub
		this.team = new ArrayList<Player>();
		this.alreadyPlayedMembers = new ArrayList<Player>();
		this.captain = null;
		this.coCaptain = null;
		this.setTeamName(null);
		this.setLocationAddress(null);
	}

	public ArrayList<Player> getAlreadyPlayedMembers() {
		return alreadyPlayedMembers;
	}

	public void setAlreadyPlayedMembers(ArrayList<Player> alreadyPlayedMembers) {
		this.alreadyPlayedMembers = alreadyPlayedMembers;
	}

	public Player getCaptain() {
		return captain;
	}

	public void setCaptain(Player captain) {
		this.captain = captain;
	}

	public Player getCoCaptain() {
		return coCaptain;
	}

	public void setCoCaptain(Player coCaptain) {
		this.coCaptain = coCaptain;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getLocationAddress() {
		return locationAddress;
	}

	public void setLocationAddress(String locationAddress) {
		this.locationAddress = locationAddress;
	}

	public boolean isSkillLevelLimitReached(int limit) {
		// TODO Auto-generated method stub
		int sumSkillLevel = 0;
		for (int i = 0; i < alreadyPlayedMembers.size(); i++) {
			sumSkillLevel += alreadyPlayedMembers.get(i).getSkillLevel();
		}
		return sumSkillLevel >= APA_MAX_SUM_SKILL_LEVEL;
	}

	public void addPlayerToTeam(Player p) {
		// TODO Auto-generated method stub
		if (!isAlreadyOnTeam(p) && !isMaxTeamSizeReached()) {
			team.add(p);
			System.out.println("Added " + p.getFullName());
		} else
			System.out.println("Cannot add " + p.getFullName() + ". "
					+ (isAlreadyOnTeam(p) ? p.getFullName() + " is already on the team" : "Team is full"));
	}

	public boolean isAlreadyOnTeam(Player p) {
		// TODO Auto-generated method stub
		boolean isOnTeam = false;
		Iterator<Player> teamIterator = team.iterator();
		while (teamIterator.hasNext() && !isOnTeam) {
			Player player = (Player) teamIterator.next();
			if (player.getUid().equals(p.getUid())) {
				isOnTeam = true;
			}
		}
		return isOnTeam;
	}

	public void simulatePotentialTeamComps() {
		ArrayList<Player> simList = new ArrayList<Player>();
		ArrayList<ArrayList<Player>> combinationLists = new ArrayList<ArrayList<Player>>();
		int skillSumCount = 0;
		for (Player initialPlayer : team) {
			skillSumCount += initialPlayer.getSkillLevel();
			simList.add(initialPlayer);
			for (int i = 0; i < team.size(); i++) {
				Player potentialPlayer = team.get(i);
				if (!initialPlayer.getFullName().contentEquals(potentialPlayer.getFullName())
						&& skillSumCount + potentialPlayer.getSkillLevel() < APA_MAX_SUM_SKILL_LEVEL
						&& simList.size() < 5) {
					skillSumCount += potentialPlayer.getSkillLevel();
					simList.add(potentialPlayer);
				}
			}

			ArrayList<String> tempNameList = new ArrayList<String>();
			for (Player pNames : simList) {
				tempNameList.add(pNames.getFullName());// list of names
			}
			if (!isDuplicateList(tempNameList, combinationLists)) {
				combinationLists.add(simList);
			}
			simList = new ArrayList<Player>();
			skillSumCount = 0;
		}

		for (int i = 0; i < combinationLists.size(); i++) {
			ArrayList<Player> potentialTeamList = combinationLists.get(i);
			skillSumCount = 0;
			if (combinationLists.size() == 1) {
				System.out.println("Only 1 potential team composition");
			} else if (combinationLists.size() == 0) {
				System.out.println(
						"There's no team compositions to allow this team to play at all.  Please acquire new players.");
			} else {
				System.out.println("There's " + combinationLists.size() + " potential team configurations");
			}
			System.out.println("Potential team# " + i);
			System.out.println("----------------------------------------------");
			for (Player player : potentialTeamList) {
				int pSkillLevel = player.getSkillLevel();
				System.out.println(player.getFullName() + " skill level: " + pSkillLevel);
				skillSumCount += pSkillLevel;
			}
			System.out.println("Number of players " + potentialTeamList.size() + " Group Skill Level " + skillSumCount);
			System.out.println("----------------------------------------------\n");
		}

	}

	public boolean isDuplicateList(ArrayList<String> listToCheck, ArrayList<ArrayList<Player>> listOfCombinations) {
		boolean isduplicateList = false;
		Iterator<ArrayList<Player>> listIterator = listOfCombinations.iterator();
		while (listIterator.hasNext() && isduplicateList == false) {
			int containsSamePlayersCount = 0;
			ArrayList<Player> playerList = (ArrayList<Player>) listIterator.next();
			for (Player player : playerList) {
				boolean wasPlayerFound = listToCheck.contains(player.getFullName());
				if (wasPlayerFound) {
					containsSamePlayersCount++;
				}
				else 
					System.out.println("Player " + player.getFullName() +  " was not found in list: " + listToCheck.toString());
			}
			isduplicateList = containsSamePlayersCount == listToCheck.size();
		}
		return isduplicateList;
	}

	public int sumSkillLevelToPlay() {
		// TODO Auto-generated method stub
		int currentSkillCount = 0;
		for (Player player : alreadyPlayedMembers) {
			currentSkillCount += player.getSkillLevel();
		}
		currentSkillCount = APA_MAX_SUM_SKILL_LEVEL - currentSkillCount;
		return currentSkillCount;
	}

	public boolean isMaxTeamSizeReached() {
		// TODO Auto-generated method stub
		if (team.size() >= APA_MAX_TEAM_SIZE) {
			System.out.println("Max team size reached");
		} else {
			System.out.println("You still have " + (APA_MAX_TEAM_SIZE - team.size()) + " slots left.");
		}
		return team.size() >= APA_MAX_TEAM_SIZE;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApaTeam test = new ApaTeam();
		Player p1 = new Player("Cordell", "Kennerly", 3);
		Player p2 = new Player("David", "Banner", 4);
		Player p3 = new Player("Tony", "Starks", 5);
		Player p4 = new Player("T'Challa", "Udaku", 6);
		Player p5 = new Player("Bruce", "Wayne", 7);
		Player p6 = new Player("Hero", "Yui", 4);
		Player p7 = new Player("Trowa", "Nemor", 3);
		Player p8 = new Player("Ted", "Barillo", 4);
		Player p9 = new Player("Extra", "Mann", 6);

		test.addPlayerToTeam(p1);
		test.addPlayerToTeam(p2);
		test.addPlayerToTeam(p3);
		test.addPlayerToTeam(p4);
		test.addPlayerToTeam(p5);
		test.addPlayerToTeam(p6);
		test.addPlayerToTeam(p7);
		test.addPlayerToTeam(p8);
		test.addPlayerToTeam(p9);
		test.addPlayerToTeam(p9);
		test.simulatePotentialTeamComps();

	}
}
