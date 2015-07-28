package edu.tx.utep.ltlgenerator.operators;

import java.util.List;

import edu.tx.utep.ltlgenerator.OutputCharacters;

public class AndR implements Operator {
	
	@Override
	public String andCPs(List<String> leftSides, String rightSide) {
		String leftSide = String.join("", leftSides);
		StringBuilder generatedString = new StringBuilder();
		generatedString.append(OutputCharacters.O_OPEN_P).append(OutputCharacters.O_OPEN_P).append(leftSide).append(OutputCharacters.O_CLOSE_P).append(OutputCharacters.O_AND).append(rightSide).append(OutputCharacters.O_CLOSE_P);
		return generatedString.toString();
	}

}