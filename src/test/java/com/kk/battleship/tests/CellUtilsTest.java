package com.kk.battleship.tests;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.kk.battleship.exceptions.InitializationException;
import com.kk.battleship.utils.CellUtils;


public class CellUtilsTest {

	 @Rule
	 public ExpectedException thrown = ExpectedException.none();
	 
	@Test
	public void testColumn(){//Zero-based column no
		Assert.assertEquals(5, CellUtils.getColumnNo("C6"));
	}
	
	@Test
	public void testRow(){
		Assert.assertEquals(2, CellUtils.getRowNo("C6"));
	}
	
	@Test
	public void testInvalidRow_MoreThan10(){
		boolean thrown = false;
		try {
			CellUtils.getDimension(12, "E");
		}catch(InitializationException e){
			thrown = true;
		}
		Assert.assertEquals(Boolean.TRUE, thrown);
	}
	@Test
	public void testInvalidRow_Boundary_Check_1(){
		boolean thrown = false;
		try {
			CellUtils.getDimension(0, "E");
		}catch(InitializationException e){
			thrown = true;
		}
		Assert.assertEquals(Boolean.TRUE, thrown);
	}
	
	@Test
	public void testInvalidRow_Negative(){
		boolean thrown = false;
		try {
			CellUtils.getDimension(-1, "E");
		}catch(InitializationException e){
			thrown = true;
		}
		Assert.assertEquals(Boolean.TRUE, thrown);
	}
	@Test
	public void testInvalidRow_Boundary_Check_2(){
		boolean thrown = false;
		try {
			CellUtils.getDimension(11, "E");
		}catch(InitializationException e){
			thrown = true;
		}
		Assert.assertEquals(Boolean.TRUE, thrown);
	}
	
	@Test
	public void testInvalidColumns_Multiple(){
		boolean thrown = false;
		try {
			CellUtils.getDimension(0, "AE");
		}catch(InitializationException e){
			thrown = true;
		}
		Assert.assertEquals(Boolean.TRUE, thrown);
	}
	
	@Test
	public void testInvalidColumns_Empty(){
		boolean thrown = false;
		try {
			CellUtils.getDimension(0, "");
		}catch(InitializationException e){
			thrown = true;
		}
		Assert.assertEquals(Boolean.TRUE, thrown);
	}
	
	@Test
	public void testInvalidColumns_Null(){
		boolean thrown = false;
		try {
			CellUtils.getDimension(0, null);
		}catch(InitializationException e){
			thrown = true;
		}
		Assert.assertEquals(Boolean.TRUE, thrown);
	}
	
	
	@Test
	public void testInvalidColumns_Non_Alphabetic(){
		boolean thrown = false;
		try {
			CellUtils.getDimension(0, "1");
		}catch(InitializationException e){
			thrown = true;
		}
		Assert.assertEquals(Boolean.TRUE, thrown);
	}
	
	@Test
	public void testValid_Normal(){
		boolean thrown = false;
		try {
			CellUtils.getDimension(5, "E");
		}catch(InitializationException e){
			thrown = true;
		}
		Assert.assertEquals(Boolean.FALSE, thrown);
	}
	
	@Test
	public void testValid_With_Space(){
		boolean thrown = false;
		try {
			CellUtils.getDimension(5, "E   ");
		}catch(InitializationException e){
			thrown = true;
		}
		Assert.assertEquals(Boolean.FALSE, thrown);
	}
}
