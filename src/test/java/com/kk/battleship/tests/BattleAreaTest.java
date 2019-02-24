package com.kk.battleship.tests;

import org.junit.Assert;
import org.junit.Test;

import com.kk.battleship.exceptions.CellAlreadyBoardedException;
import com.kk.battleship.exceptions.InitializationException;
import com.kk.battleship.models.BattleArea;
import com.kk.battleship.models.Dimension;
import com.kk.battleship.models.Ship;

public class BattleAreaTest {

	@Test
	public void testWrongInit_1() {
		boolean thrown = false;
		try {
			BattleArea ba = new BattleArea("4", "4");
		} catch(InitializationException e) {
			thrown = true;
		}
		
		Assert.assertEquals(Boolean.TRUE, thrown);
	}
	
	@Test
	public void testWrongInit_2() {
		boolean thrown = false;
		try {
			BattleArea ba = new BattleArea("E", "E");
		} catch(InitializationException e) {
			thrown = true;
		}
		
		Assert.assertEquals(Boolean.TRUE, thrown);
	}
	
	@Test
	public void testInit() {
		boolean thrown = false;
		try {
			BattleArea ba = new BattleArea("4", "E");
		} catch(InitializationException e) {
			thrown = true;
		}
		
		Assert.assertEquals(Boolean.FALSE, thrown);
	}
	
	
	@Test
	public void testSinglePlacement() {
		boolean placed = false;
		try {
			BattleArea ba = new BattleArea("4","E");
			Ship s = new Ship("Q", new Dimension(1, 1));
			ba.placeShip(s, "A2");
			placed = true;
		} catch(InitializationException e) {
			
		} catch (CellAlreadyBoardedException e) {
			placed = false;
		}
		
		Assert.assertEquals(Boolean.TRUE, placed);
	}
	
	@Test
	public void testWrongPlacement_SameLocation() {
		boolean placed = false;
		try {
			BattleArea ba = new BattleArea("4","E");
			Ship s1 = new Ship("Q", new Dimension(1, 1));
			ba.placeShip(s1, "A2");
			Ship s2 = new Ship("Q", new Dimension(1, 1));
			ba.placeShip(s2, "A2");
			placed = true;
		} catch(InitializationException e) {
			
		} catch (CellAlreadyBoardedException e) {
			placed = false;
		}
		
		Assert.assertEquals(Boolean.FALSE, placed);
	}
	
	@Test
	public void testWrongPlacement_OverlappingLocation_1() {
		boolean placed = false;
		try {
			BattleArea ba = new BattleArea("4","E");
			Ship s1 = new Ship("Q", new Dimension(2, 2));
			ba.placeShip(s1, "A2"); //A2, A3, B2, B3 all are occuppied
			Ship s2 = new Ship("Q", new Dimension(1, 1));
			ba.placeShip(s2, "B2");
			placed = true;
		} catch(InitializationException e) {
			
		} catch (CellAlreadyBoardedException e) {
			placed = false;
		}
		
		Assert.assertEquals(Boolean.FALSE, placed);
	}
	
	@Test
	public void testWrongPlacement_OverlappingLocation_2() {
		boolean placed = false;
		try {
			BattleArea ba = new BattleArea("4","E");
			Ship s1 = new Ship("Q", new Dimension(2, 2));
			ba.placeShip(s1, "A2"); //A2, A3, B2, B3 all are occuppied
			Ship s2 = new Ship("Q", new Dimension(1, 1));
			ba.placeShip(s2, "B3");
			placed = true;
		} catch(InitializationException e) {
			
		} catch (CellAlreadyBoardedException e) {
			placed = false;
		}
		
		Assert.assertEquals(Boolean.FALSE, placed);
	}
	
	@Test
	public void testWrongPlacement_OverlappingLocation_3() {
		boolean placed = false;
		try {
			BattleArea ba = new BattleArea("4","E");
			Ship s1 = new Ship("Q", new Dimension(1, 1));
			ba.placeShip(s1, "B2"); //A2, A3, B2, B3 all are occuppied
			Ship s2 = new Ship("Q", new Dimension(2, 2));
			ba.placeShip(s2, "A2");
			placed = true;
		} catch(InitializationException e) {
			
		} catch (CellAlreadyBoardedException e) {
			placed = false;
		}
		
		Assert.assertEquals(Boolean.FALSE, placed);
	}
}
