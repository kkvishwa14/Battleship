package com.kk.battleship.launcher;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
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
		
		try {
			URL url = this.getClass().getResource(gameInputsFileName);
			Scanner sc = new Scanner(new File(url.toURI()));
			//String line = "";
			while(sc.hasNextLine()){
				System.out.println(sc.nextLine());
			}
			sc.close();
		} catch (FileNotFoundException | URISyntaxException e) {
			System.out.println("Exception occurred :"+e);
		}
	}
	public static void main(String[] args) {
		GameLauncher gl = new GameLauncher();
		if(args.length>0 && args[0] != null){
			gl.setGameInputsFileName(args[0]);
		}
		gl.launchGame();
	}
	

}
