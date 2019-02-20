package com.kk.battleship.utils;

import com.kk.battleship.beans.Dimension;
import com.kk.battleship.exceptions.InitializationException;

public class CellUtils {

	public static int getColumnNo(String cellCoordinate){
		return 	cellCoordinate.charAt(1) - '0' -1;
	}
	
	public static int getRowNo(String cellCoordinate){
		return 	cellCoordinate.charAt(0) - 'A';
	}
	
	
	public static void main(String[] args) {
		System.out.println(getColumnNo("C5"));
		System.out.println(getRowNo("C5"));
	}

	public static Dimension getDimension(int rows, String columns) throws InitializationException{
		if(rows<1 || rows>10 ||columns.length()>1||!(columns.charAt(0)>='A'&& columns.charAt(0)<='Z')){
			throw new InitializationException();
		}
		Dimension d = new Dimension(rows, columns.charAt(0)-'A'+1);
		return d;
	}
}
