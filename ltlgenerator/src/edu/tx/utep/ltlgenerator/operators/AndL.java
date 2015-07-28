package edu.tx.utep.ltlgenerator.operators;

import java.util.List;

import edu.tx.utep.ltlgenerator.OutputCharacters;

public class AndL implements Operator {

	@Override
	public String andCPs(List<String> leftSides, String rightSide) {
		List<String> newLeftSides = leftSides;
		int indexOfLastCP = leftSides.size() > 2 ? leftSides.size() - 2 : 0;

		String lastCp = leftSides.get(indexOfLastCP);
		String newLast = "";

		if (lastCp.indexOf(OutputCharacters.OPEN_P) == 0) {
			if (lastCp.indexOf(OutputCharacters.CLOSE_P) == -1) {
				newLast = getNewLastCP(lastCp, true, rightSide);
			} else {
				newLast = getNewLastCP(lastCp, false, rightSide);
			}
		} else if (lastCp.indexOf("l") == 0 || lastCp.indexOf("p") == 0 || lastCp.indexOf("q") == 0 || lastCp.indexOf("r") == 0) {
			newLast = getNewLastCP(lastCp, false, rightSide);
		}

		newLeftSides.set(indexOfLastCP, newLast);
		return String.join("", newLeftSides);
	}

	private String getNewLastCP(String lastCp, boolean hasOpenParen, String rightSide) {
		String newLastCp = lastCp;
		if (hasOpenParen) {
			newLastCp = lastCp.substring(0, 1) + OutputCharacters.O_OPEN_P + lastCp.substring(1, lastCp.length());
			return newLastCp + OutputCharacters.O_AND + rightSide + OutputCharacters.O_CLOSE_P;
		} else {
			return OutputCharacters.O_OPEN_P + lastCp + OutputCharacters.O_AND + rightSide + OutputCharacters.O_CLOSE_P;
		}
	}
}
