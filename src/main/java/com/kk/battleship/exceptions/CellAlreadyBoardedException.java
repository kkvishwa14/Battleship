package com.kk.battleship.exceptions;

public class CellAlreadyBoardedException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CellAlreadyBoardedException() {
		super("Cell already boarded with a ship");
	}
}
