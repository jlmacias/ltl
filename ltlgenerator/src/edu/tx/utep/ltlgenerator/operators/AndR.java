package edu.tx.utep.ltlgenerator.operators;

import java.util.List;

public class AndR extends Operator {
	
	@Override
	public String andCPs(List<String> leftSides, String rightSide) {
		String leftSide = String.join("", leftSides);
		StringBuilder generatedString = new StringBuilder();
		generatedString.append(OPEN_P).append(OPEN_P).append(leftSide).append(CLOSE_P).append(AND).append(rightSide).append(CLOSE_P);
		return generatedString.toString();
	}

}