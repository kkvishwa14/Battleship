package com.kk.battleship.beans;

public class Dimension {
	private int length;
	private int breadth;
	private int area;
	
	
	public Dimension(int length, int breadth) {
		super();
		this.length = length;
		this.breadth = breadth;
		this.area = length * breadth;
	}
	
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getBreadth() {
		return breadth;
	}
	public void setBreadth(int breadth) {
		this.breadth = breadth;
	}
	public int getArea() {
		return area;
	}
}
