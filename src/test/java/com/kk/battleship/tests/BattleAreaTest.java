package com.kk.battleship.tests;

import org.junit.Assert;
import org.junit.Test;

import com.kk.battleship.exceptions.InitializationException;
import com.kk.battleship.models.BattleArea;

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
}
