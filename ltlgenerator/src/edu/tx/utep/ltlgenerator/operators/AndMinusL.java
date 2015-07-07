package edu.tx.utep.ltlgenerator.operators;

import java.util.List;

public class AndMinusL extends Operator {

	@Override
	public String andCPs(List<String> leftSides, String rightSide) {
		List<String> newLeftSides = leftSides;
		String cpPart = "";
		String newCpPart = "";
		int endIndex = leftSides.size() == 1 ? 1 : leftSides.size() - 2;

		for (int i = 0; i < endIndex; i++) {
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
}
