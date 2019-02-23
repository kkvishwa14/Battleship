package com.kk.battleship.models;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kk.battleship.enums.HitResult;
import com.kk.battleship.exceptions.InitializationException;
import com.kk.battleship.models.BattleArea;
import com.kk.battleship.models.Dimension;
import com.kk.battleship.models.IPlayer;
import com.kk.battleship.models.NormalPlayer;
import com.kk.battleship.models.Ship;


public class Game {
	
	private IPlayer player1;
	public IPlayer getPlayer1() {
		return player1;
	}

	public void setPlayer1(IPlayer player1) {
		this.player1 = player1;
	}

	public IPlayer getPlayer2() {
		return player2;
	}

	public void setPlayer2(IPlayer player2) {
		this.player2 = player2;
	}

	private IPlayer player2;
	/*
	 * 
	 * 
Enter BattleArea Boundary 5E
Type Of Battleship 1 : Q
Dimension of Battleship 1 : 1 1
Location of Battleship for player A : A1
Location of Battleship for player B : B2


Type Of Battleship 2 : P
Dimension of Battleship 2 : 2 1
Location of Battleship for player A : D4
Location of Battleship for player B : C3

Missile Targets for player A: A1 B2 B2 B3
Missile Targets for player B: A1 B2 B3 A1 D1 E1 D4 D4 D5 D5


	 */
	/*
	public static void main(String[] args){
		try {
		Game g = new Game();
		
		BattleArea ba1 = new BattleArea("5","E");
		BattleArea ba2 = new BattleArea("5","E");
		
//		Ship s1 = new Ship();
		
		Ship s1_1 = new Ship("Q",new Dimension(1, 1));
		Ship s2_1 = new Ship("P", new Dimension(2, 1));
		
		Ship s1_2 = new Ship("Q",new Dimension(1, 1));
		Ship s2_2 = new Ship("P", new Dimension(2, 1));
		
		Map<Ship, String> placementMap1 = new HashMap<Ship, String>();
		placementMap1.put(s1_1, "A1");
		placementMap1.put(s2_1, "D4");
		
		Map<Ship, String> placementMap2 = new HashMap<Ship, String>();
		placementMap2.put(s1_2, "B2");
		placementMap2.put(s2_2, "C3");
		
		g.player1 = new NormalPlayer("P1",ba1, placementMap1);
		
		if(!g.player1.placeShips()) {
			System.out.println("Colud not place ship for player 1 ,Exiting");
			System.exit(0);
		}
		List<String> targets1 = new ArrayList<String>();
		targets1.add("A1");
		targets1.add("B2");
		targets1.add("B2");
		targets1.add("B3");
		g.player1.initializeMissileTargets(targets1);
		g.player2 = new NormalPlayer("P2",ba2, placementMap2);
		if(!g.player2.placeShips()) {
			System.out.println("Colud not place ship for player 2 ,Exiting");
			System.exit(0);
		}
		List<String> targets2 = new ArrayList<String>();
		targets2.add("A1");
		targets2.add("B2");
		targets2.add("B3");
		targets2.add("B3");
		targets2.add("A1");
		targets2.add("D1");
		targets2.add("E1");
		targets2.add("D4");
		targets2.add("D4");
		targets2.add("D5");
		targets2.add("D5");
		
		g.player2.initializeMissileTargets(targets2);
		
		
		
		ba1.printCells();
		System.out.println("==========================");
		ba2.printCells();
		g.startGame();
		System.out.println("GAME FINISHED");
		if(g.player1.lost()){
			System.out.println("P2 won");
		} else if(g.player2.lost()) {
			System.out.println("P1 won");
		} else {
			System.out.println("DRAW");
		}
		} catch(InitializationException ex){
			System.out.println("Exception "+ex);
		}catch(Exception ex) {
			System.out.println("Exception "+ex);
		}
	}
	*/
	public void startGame() {
		IPlayer startingPlayer = player1;
		IPlayer opponentPlayer = player2;
		while(startingPlayer.hasMissilesLeft() || opponentPlayer.hasMissilesLeft()) {
			System.out.println(startingPlayer.getName()+"'s turn");
			HitResult result = startingPlayer.hit(opponentPlayer);
			if(result != HitResult.MISS){
				System.out.println(startingPlayer.getName()+ " Hit ");
				if(opponentPlayer.lost()){
					System.out.println("Player "+startingPlayer.getName()+" won");
					break;
				}
				
			} else{
				System.out.println(startingPlayer.getName()+ " Missed ");
				IPlayer temp = startingPlayer;
				startingPlayer = opponentPlayer;
				opponentPlayer = temp;
			}
		}
	}
	
}
