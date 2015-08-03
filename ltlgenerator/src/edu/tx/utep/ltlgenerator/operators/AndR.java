package edu.tx.utep.ltlgenerator.operators;

import java.util.List;

import edu.tx.utep.ltlgenerator.OutputCharacters;

public class AndR implements Operator {

	@Override
	public String andCPs(List<String> leftSides, String rightSide) {
		List<String> newLeftSides = leftSides;
		String cpPart = "";
		String newCpPart = "";
		int endIndex = leftSides.size() > 2 ? leftSides.size() - 2 : 0;

		for (int i = 0; i <= endIndex; i++) {
			cpPart = leftSides.get(i);
			if (cpPart.indexOf("(") == 0 && cpPart.length() > 1) {
				if (cpPart.indexOf(")") == -1) {
					cpPart = cpPart.substring(0, 1) + OutputCharacters.O_OPEN_P + cpPart.substring(1, cpPart.length());
					newCpPart = cpPart + OutputCharacters.O_AND + rightSide + OutputCharacters.O_CLOSE_P;
				} else {
					newCpPart = OutputCharacters.O_OPEN_P + cpPart + OutputCharacters.O_AND + rightSide + OutputCharacters.O_CLOSE_P;
				}
				newLeftSides.set(i, newCpPart);
			}
		}
		return String.join("", newLeftSides);
	}

}