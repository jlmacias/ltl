package edu.tx.utep.ltlgenerator.cps;

public class EventualC extends CompositeProposition {

	// private static String cpFormula = "(q1 ^ X(!q2 U (q2 ^ X(!q3 U (q3 ^ X(!q4 U q4))))))";

	@Override
	public String generateLTL(String letter, int count) {
		StringBuilder formula = new StringBuilder();

		for (int stringCurrentPosition = 1; stringCurrentPosition <= count; stringCurrentPosition++) {
			if (stringCurrentPosition == count) {
				formula.append(letter).append(stringCurrentPosition);
				for (int openParentesisCount = 1; openParentesisCount <= count - 1; openParentesisCount++) {
					formula.append(CLOSE_P).append(CLOSE_P);
				}
			} else {
				formula.append(OPEN_P).append(letter).append(stringCurrentPosition).append(AND).append(NEXT).append(OPEN_P).append(NOT).append(letter).append(stringCurrentPosition + 1).append(UNTIL);
			}
		}

		return formula.toString();
	}

}