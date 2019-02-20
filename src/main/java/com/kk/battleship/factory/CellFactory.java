package com.kk.battleship.factory;
import com.kk.battleship.enums.CellStatus;
import com.kk.battleship.models.BoardedCell;
import com.kk.battleship.models.Cell;
import com.kk.battleship.models.ICell;


public class CellFactory {

	public static ICell getCellInstance(CellStatus cellstatus){
		switch(cellstatus){
			case INACTIVE: return new Cell();
			case ACTIVE: return new BoardedCell();
			default: throw new IllegalArgumentException("Illegal Argument "+cellstatus+" passed for cell initialization");
		}
		
	}
}
