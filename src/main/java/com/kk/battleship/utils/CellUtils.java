package com.kk.battleship.utils;

import java.util.HashSet;
import java.util.Set;

import com.kk.battleship.exceptions.InitializationException;
import com.kk.battleship.models.CapitalAlphabetConstraint;
import com.kk.battleship.models.Constraint;
import com.kk.battleship.models.Dimension;
import com.kk.battleship.models.PositiveSingleDigitConstraint;

public class CellUtils {
	
	static Set<Constraint> rowConstraints = new HashSet<Constraint>();
	static Set<Constraint> columnConstraints = new HashSet<Constraint>();
	static {
		rowConstraints.add(new PositiveSingleDigitConstraint());
		columnConstraints.add(new CapitalAlphabetConstraint());
	}
	
	public static boolean isValidRowSize(String rows) {
		
		for(Constraint c : rowConstraints) {
			if(!c.isValid(rows))
				return false;
		}
		return true;
	}
	
	public static boolean isValidColumnSize(String columns) {
		for(Constraint c : columnConstraints) {
			if(!c.isValid(columns))
				return false;
		}
		return true;
	}
	public static int getColumnNo(String cellCoordinate){
		return 	cellCoordinate.charAt(1) - '0' -1;
	}
	
	public static int getRowNo(String cellCoordinate){
		return 	cellCoordinate.charAt(0) - 'A';
	}

	public static Dimension getDimension(String rows, String columns) throws InitializationException{
		
		if(!isValidRowSize(rows) || !isValidColumnSize(columns)){
			throw new InitializationException();
		}
		int rowCount = Integer.parseInt(rows);
		columns = columns.trim();
		int columnCount = columns.charAt(0)- 'A' + 1;
		Dimension d = new Dimension(rowCount, columnCount);
		return d;
	}
}
