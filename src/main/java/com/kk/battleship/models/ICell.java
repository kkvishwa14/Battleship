package com.kk.battleship.models;
import com.kk.battleship.enums.CellStatus;
import com.kk.battleship.enums.HitResult;


public interface ICell {
	
	CellStatus getCellStatus();
	HitResult getHitResult();
	void setShip(Ship ship);
}
