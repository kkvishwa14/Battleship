package com.kk.battleship.models;

public class CapitalAlphabetConstraint implements Constraint{

	@Override
	public boolean isValid(String data) {
		boolean isValid = false;
		if(data == null) {
			return isValid;
		}
		data = data.trim();
		if(data.length()==1 && (data.charAt(0)>='A'&& data.charAt(0)<='Z')){
			isValid = true;
		}
		return isValid;
	}

}
