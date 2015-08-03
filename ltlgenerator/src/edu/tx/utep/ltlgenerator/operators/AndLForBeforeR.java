package edu.tx.utep.ltlgenerator.operators;

import edu.tx.utep.ltlgenerator.OutputCharacters;

public class AndLForBeforeR {

	public String getAndLForBeforeR(String leftSide, String rightSide) {
		boolean sidesAreInitialized = ((leftSide != null) && (rightSide != null));
		int lastElementStartIndex;
		int firstClosingParenthesisIndex;
		int leftSideLength;
		int IntroduceRightSideIndex;
		String lastElementString;
		StringBuilder leftSideAndLRightSide = new StringBuilder();

		leftSideLength = leftSide.length();
		if (sidesAreInitialized) {
			lastElementStartIndex = leftSide.lastIndexOf(OutputCharacters.O_AND);
			if (lastElementStartIndex != -1) {
				lastElementStartIndex++;
				if (leftSide.indexOf(OutputCharacters.UNTIL, lastElementStartIndex) != -1) {
					lastElementStartIndex = leftSide.lastIndexOf(OutputCharacters.UNTIL, leftSideLength) + 1;
				} else if (leftSide.indexOf(OutputCharacters.NEXT, lastElementStartIndex) != -1) {
					lastElementStartIndex = leftSide.lastIndexOf(OutputCharacters.NEXT, leftSideLength) + 1;
				}

				lastElementString = leftSide.substring(lastElementStartIndex);
				firstClosingParenthesisIndex = lastElementString.indexOf(OutputCharacters.CLOSE_P);

				if (firstClosingParenthesisIndex != -1) {
					IntroduceRightSideIndex = lastElementStartIndex + firstClosingParenthesisIndex + 1;
					leftSideAndLRightSide.append(leftSide.substring(0, IntroduceRightSideIndex));
					leftSideAndLRightSide.append(OutputCharacters.O_AND);
					leftSideAndLRightSide.append(OutputCharacters.O_OPEN_P);
					leftSideAndLRightSide.append(rightSide);
					leftSideAndLRightSide.append(OutputCharacters.O_CLOSE_P);
					leftSideAndLRightSide.append(leftSide.substring(IntroduceRightSideIndex, leftSideLength));
					return leftSideAndLRightSide.toString();
				} else {
					// error
					return null;
				}

			} else {
				// This is only for strings resulting from the andR operation. Further Error Handling might need to be implemented. Roberto Fierro
				return null;
			}
		}
		return null;
	}

}
