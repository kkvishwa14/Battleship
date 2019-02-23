package com.kk.battleship.launcher;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class GameLauncher {
	private String gameInputsFileName = "input.txt";
	
	public String getGameInputsFileName() {
		return gameInputsFileName;
	}
	public void setGameInputsFileName(String gameInputsFileName) {
		this.gameInputsFileName = gameInputsFileName;
	}
	public void launchGame() {
		try (Scanner sc = new Scanner(new File(this.getClass().getResource(gameInputsFileName).toURI()));){
			String line = "";
			while(sc.hasNextLine()){
				
			}
		} catch (FileNotFoundException | URISyntaxException e) {
			System.out.println("Exception occurred :"+e);
		}
	}
	public static void main(String[] args) {
		GameLauncher gl = new GameLauncher();
		if(args[0] != null){
			gl.setGameInputsFileName(args[0]);
		}
		gl.launchGame();
	}
	

}
