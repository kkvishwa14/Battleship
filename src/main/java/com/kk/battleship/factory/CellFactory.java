package com.kk.battleship.factory;
import com.kk.battleship.beans.BoardedCell;
import com.kk.battleship.beans.Cell;
import com.kk.battleship.beans.ICell;
import com.kk.battleship.enums.CellStatus;


public class CellFactory {

	public static ICell getCellInstance(CellStatus cellstatus){
		switch(cellstatus){
			case INACTIVE: return new Cell();
			case ACTIVE: return new BoardedCell();
			default: throw new IllegalArgumentException("Illegal Argument "+cellstatus+" passed for cell initialization");
		}
		
	}
}
