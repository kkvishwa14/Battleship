package com.kk.battleship.beans;

import com.kk.battleship.beans.Dimension;

import com.kk.battleship.enums.HitResult;
import com.kk.battleship.enums.ShipType;


public class Ship {
	private String shipId;
	private ShipType type;
	private Dimension dimension;
	private int activeCellsRemaining;
	
	public String getShipId() {
		return shipId;
	}

	public void setShipId(String shipId) {
		this.shipId = shipId;
	}

	public void evaluateResult(HitResult hitResult) {
		if(HitResult.DESTROYED==hitResult){
			activeCellsRemaining--;
		}
	}
	
	public Ship(ShipType type, Dimension d) {
		this.type = type;
		this.dimension = d;
		this.activeCellsRemaining = d.getArea();
	}
	
	public Ship(String type, Dimension d) {
		this.type = ShipType.valueOf(type);
		this.dimension = d;
		this.activeCellsRemaining = d.getArea();
	}
	
	public boolean isCompletelyDestroyed(){
		return activeCellsRemaining == 0;
	}

	public ShipType getType() {
		return type;
	}

	public void setType(ShipType type) {
		this.type = type;
	}

	public Dimension getDimension() {
		return dimension;
	}

	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}

	public int getActiveCellsRemaining() {
		return activeCellsRemaining;
	}

	public void setActiveCellsRemaining(int activeCellsRemaining) {
		this.activeCellsRemaining = activeCellsRemaining;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((shipId == null) ? 0 : shipId.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ship other = (Ship) obj;
		if (shipId == null) {
			if (other.shipId != null)
				return false;
		} else if (!shipId.equals(other.shipId))
			return false;
		if (type != other.type)
			return false;
		return true;
	}
	
	
}

