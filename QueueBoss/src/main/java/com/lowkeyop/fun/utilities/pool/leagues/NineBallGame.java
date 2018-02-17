package com.lowkeyop.fun.utilities.pool.leagues;

import com.lowkeyop.fun.utilities.models.Player;

public class NineBallGame extends GameModel {
	private boolean nineSnap;
	private int deadBalls, p1Balls, p2Balls;
	
	public NineBallGame() {
		super();
		this.nineSnap = false;
		this.deadBalls = 0;
		// TODO Auto-generated constructor stub
	}

	public NineBallGame( boolean nS, int dBalls) {
		super();
		this.nineSnap = nS;
		this.deadBalls = dBalls;
		// TODO Auto-generated constructor stub
	}

	public boolean isNineSnap() {
		return nineSnap;
	}

	public void setNineSnap(boolean nineSnap) {
		this.nineSnap = nineSnap;
	}

	public int getDeadBalls() {
		return deadBalls;
	}

	public void setDeadBalls(int deadBalls) {
		this.deadBalls = deadBalls;
	}

	public int getP1Balls() {
		return p1Balls;
	}

	public void setP1Balls(int p1Balls) {
		this.p1Balls = p1Balls;
	}

	public int getP2Balls() {
		return p2Balls;
	}

	public void setP2Balls(int p2Balls) {
		this.p2Balls = p2Balls;
	}
	
	public boolean isAllBallsAccountedFor() {
		return (this.p1Balls + this.p2Balls + this.deadBalls) == 10;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NineBallGame dConstruct = new NineBallGame();
		Player player1 = new Player("Player 1", "Team 1", 5);
		Player player2 = new Player("Player 2", "Team 2", 6);
		boolean nS = false;
		NineBallGame oConstruct = new NineBallGame( nS, 0);
		oConstruct.setPlayer1(player1);
		oConstruct.setPlayer2(player2);
		
		System.out.println(dConstruct.getPlayer1().getSkillLevel());
		System.out.println(dConstruct.getPlayer2().getSkillLevel());
		System.out.println(dConstruct.isNineSnap());
		
		System.out.println(oConstruct.getPlayer1().getSkillLevel());
		System.out.println(oConstruct.getPlayer2().getSkillLevel());
		oConstruct.setNineSnap(true);
		System.out.println(oConstruct.isNineSnap());
		
	}

}
