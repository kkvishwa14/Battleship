package com.kk.battleship.models;
import com.kk.battleship.enums.CellStatus;
import com.kk.battleship.enums.HitResult;


public class Cell implements ICell {
	CellStatus cellStatus = CellStatus.INACTIVE;
	@Override
	public HitResult getHitResult() {
		return HitResult.MISS;
	}

	@Override
	public CellStatus getCellStatus() {
		return cellStatus;
	}

	@Override
	public void setShip(Ship ship) {
		System.out.println("This Cell is still a normal cell , cannot have ship reference");
	}

}
