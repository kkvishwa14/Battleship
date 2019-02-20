package com.kk.battleship.beans;
import com.kk.battleship.enums.CellStatus;
import com.kk.battleship.enums.HitResult;


public interface ICell {
	
	CellStatus getCellStatus();
	HitResult getHitResult();
	void setShip(Ship ship);
}
