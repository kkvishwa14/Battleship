package com.kk.battleship.enums;

public enum ShipType {
	
	P(1),Q(2);
	private int strength;
	
	private ShipType(int strength) {
		this.strength = strength;
	}
	
	public int getStrength(){
		return strength;
	}
}
