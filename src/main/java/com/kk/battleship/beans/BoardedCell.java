package com.kk.battleship.beans;

import com.kk.battleship.enums.CellStatus;
import com.kk.battleship.enums.HitResult;

public class BoardedCell extends Cell {

	private int countHit;
	private Ship ship;
	
	public BoardedCell() {
		super();
	}
	
	public int getCountHit() {
		return countHit;
	}

	public void setCountHit(int countHit) {
		this.countHit = countHit;
	}

	public Ship getShip() {
		return ship;
	}

	public void setShip(Ship ship) {
		this.ship = ship;
	}

	public BoardedCell(Ship ship){
		this.ship = ship;
		countHit = 0;
		cellStatus = CellStatus.ACTIVE;
	}
	
	public void updateCellStatus() {
		if(!(countHit<this.ship.getType().getStrength()))
			cellStatus = CellStatus.DESTROYED;
	}
	
	@Override
	public HitResult getHitResult() {
		//check if already destroyed
		if(getCellStatus() == CellStatus.DESTROYED){
			return HitResult.MISS;
		}
		
		countHit++;
		updateCellStatus();
		HitResult hitResult = HitResult.PARTIALLY_DESTROYED;
		if(getCellStatus()==CellStatus.DESTROYED) {
			hitResult = HitResult.DESTROYED;
		}
		this.ship.evaluateResult(hitResult);
		return hitResult;
	}

	@Override
	public CellStatus getCellStatus() {
		return cellStatus;
	}

}
