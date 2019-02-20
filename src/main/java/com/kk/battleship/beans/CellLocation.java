package com.kk.battleship.beans;

import com.kk.battleship.utils.CellUtils;

public class CellLocation {
	private String cellLocation;
	private int row;
	private int column;
	public CellLocation(String location) {
		this.cellLocation = location;
		this.row = CellUtils.getRowNo(cellLocation);
		this.column = CellUtils.getColumnNo(cellLocation);
	}
	
	public int getRow() {
		return row;
	}
	public int getColumn() {
		return column;
	}
	
	public Dimension convertToDimension(){
		Dimension d = new Dimension(row, column);
		return d;
	}
}
