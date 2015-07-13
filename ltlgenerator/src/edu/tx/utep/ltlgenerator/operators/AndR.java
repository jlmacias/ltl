package edu.tx.utep.ltlgenerator.operators;

import java.util.List;

public class AndR extends Operator {

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
					cpPart = cpPart.substring(0, 1) + OPEN_P + cpPart.substring(1, cpPart.length());
					newCpPart = cpPart + AND + rightSide + CLOSE_P;
				} else {
					newCpPart = OPEN_P + cpPart + AND + rightSide + CLOSE_P;
				}
				newLeftSides.set(i, newCpPart);
			}
		}
		return String.join("", newLeftSides);
	}
	
	
	public String andCPsLessVerbose(List<String> leftSides, String rightSide) {
		String leftSide = String.join("", leftSides);
		StringBuilder generatedString = new StringBuilder();
		generatedString.append(OPEN_P).append(OPEN_P).append(leftSide).append(CLOSE_P).append(AND).append(rightSide).append(CLOSE_P);
		return generatedString.toString();
	}

}