package com.kk.battleship.tests;

import org.junit.Assert;
import org.junit.Test;

import com.kk.battleship.utils.CellUtils;


public class CellUtilsTest {

	@Test
	public void testColumn(){//Zero-based column no
		Assert.assertEquals(5, CellUtils.getColumnNo("C6"));
	}
	
	@Test
	public void testRow(){
		Assert.assertEquals(2, CellUtils.getRowNo("C6"));
	}
}
