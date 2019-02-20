package com.kk.battleship.utils;

import com.kk.battleship.exceptions.InitializationException;
import com.kk.battleship.models.Dimension;

public class CellUtils {

	public static int getColumnNo(String cellCoordinate){
		return 	cellCoordinate.charAt(1) - '0' -1;
	}
	
	public static int getRowNo(String cellCoordinate){
		return 	cellCoordinate.charAt(0) - 'A';
	}

	public static Dimension getDimension(int rows, String columns) throws InitializationException{
		if(columns != null) {
			columns = columns.trim();
		}
		if(rows<1 || rows>10 ||columns == null||columns.length()<1||columns.length()>1||!(columns.charAt(0)>='A'&& columns.charAt(0)<='Z')){
			throw new InitializationException();
		}
		Dimension d = new Dimension(rows, columns.charAt(0)-'A'+1);
		return d;
	}
}
