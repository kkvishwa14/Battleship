package com.kk.battleship.launcher;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.kk.battleship.exceptions.InitializationException;
import com.kk.battleship.models.BattleArea;
import com.kk.battleship.models.Dimension;
import com.kk.battleship.models.Game;
import com.kk.battleship.models.IPlayer;
import com.kk.battleship.models.NormalPlayer;
import com.kk.battleship.models.Ship;

public class GameLauncher {
	private String gameInputsFileName = "input.txt";
	private int totalShips = 2;

	public String getGameInputsFileName() {
		return gameInputsFileName;
	}

	public void setGameInputsFileName(String gameInputsFileName) {
		this.gameInputsFileName = gameInputsFileName;
	}

	private List<BattleArea> createBattleArea(Scanner sc) {
		List<BattleArea> baList = new ArrayList<BattleArea>();
		try {
			String[] parts = sc.nextLine().split(" ");
			BattleArea ba1 = new BattleArea(parts[0], parts[1]);
			BattleArea ba2 = new BattleArea(parts[0], parts[1]);
			baList.add(ba1);
			baList.add(ba2);
		} catch (InitializationException e) {
			System.out.println("Could not initialize BattleArea, Exception :"
					+ e);
		} catch (Exception e) {
			System.out.println("Could not initialize BattleArea, Exception :"
					+ e);
		}
		return baList;
	}

	private Dimension getDimension(String dimensionInput) {
		String dParts[] = dimensionInput.split(" ");
		Dimension d = new Dimension(Integer.parseInt(dParts[0]),
				Integer.parseInt(dParts[1]));
		return d;
	}

	private List<Map<Ship, String>> getShipPlacementList(Scanner sc) {
		List<Map<Ship, String>> placementList = new ArrayList<Map<Ship, String>>();
		Map<Ship, String> player1Ships = new HashMap<Ship, String>();
		Map<Ship, String> player2Ships = new HashMap<Ship, String>();
		try {
			for (int i = 0; i < totalShips; i++) {
				String shipType = sc.nextLine();
				Dimension d = getDimension(sc.nextLine());
				String cellLocation1 = sc.nextLine();
				String cellLocation2 = sc.nextLine();
				Ship s1 = new Ship(shipType, d);
				Ship s2 = new Ship(shipType, d);
				player1Ships.put(s1, cellLocation1);
				player2Ships.put(s2, cellLocation2);
			}
			placementList.add(player1Ships);
			placementList.add(player2Ships);
		} catch (Exception e) {
			System.out.println("Exception " + e);
		}
		return placementList;
	}

	public List<String> getMissileTargets(Scanner sc) {
		String line = sc.nextLine();
		String parts[] = line.split(" ");
		List<String> targets = new ArrayList<String>();
		for(String part : parts) {
			targets.add(part);
		}
		return targets;
	}
	public void initializeGame(Game game) {
		Scanner sc= null;
		try {

			sc = new Scanner(new File(this.getClass().getClassLoader().getResource(gameInputsFileName).toURI()));
			System.out.println("Creating Battleareas");
			List<BattleArea> battleAreas = createBattleArea(sc);
			if (battleAreas.isEmpty()) {
				System.out
						.println("Problem while initializing battleArea, Exiting");
				System.exit(0);
			}
			System.out.println("Creating ships");
			List<Map<Ship, String>> placementsList = getShipPlacementList(sc);

			if (placementsList.isEmpty()) {
				System.out.println("Problem while initializing ships, Exiting");
				System.exit(0);
			}
			System.out.println("initializing players");
			IPlayer player1 = new NormalPlayer("P1", battleAreas.get(0),
					placementsList.get(0));
			IPlayer player2 = new NormalPlayer("P2", battleAreas.get(1),
					placementsList.get(1));

			game.setPlayer1(player1);
			game.setPlayer2(player2);

			System.out.println("placing ships");
			boolean placedShips = player1.placeShips() && player2.placeShips();

			if (!placedShips) {
				System.out.println("Problem while placing ships, Exiting");
				System.exit(0);
			}
			System.out.println("setting targets");
			player1.initializeMissileTargets(getMissileTargets(sc));
			player2.initializeMissileTargets(getMissileTargets(sc));
			
			System.out.println("Printing battle  area:");
			battleAreas.get(0).printCells();
			battleAreas.get(1).printCells();
			
		} catch (Exception e) {
			System.out.println("Exception occurred :" + e);
		} finally {
			if(sc != null)
				sc.close();
		}
	}

	public void launchGame() {
		Game game = new Game();
		System.out.println("initializing game");
		initializeGame(game);
		System.out.println("starting game");
		game.startGame();
	}

	public static void main(String[] args) {
		GameLauncher gl = new GameLauncher();
		if (args.length > 0 && args[0] != null) {
			gl.setGameInputsFileName(args[0]);
		}
		gl.launchGame();
	}

}
