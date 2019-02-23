package com.kk.battleship.models;

public class PositiveSingleDigitConstraint implements Constraint{
	@Override
	public boolean isValid(String data) {
		boolean isValid = false;
		try {
			int number = Integer.parseInt(data.trim());
			if(!(number<1 || number>10)){
				isValid = true;
			}
		}catch(Exception e) {
			System.out.println("Exception occurred while converting "+data+" to number");
		}
		return isValid;
	}

}
