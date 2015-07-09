package edu.tx.utep.ltlgenerator.cps;

import java.util.ArrayList;
import java.util.List;

public class EventualC extends CompositeProposition {

	// private static String cpFormula = "(q1 ^ X(!q2 U (q2 ^ X(!q3 U (q3 ^ X(!q4 U q4))))))";

	@Override
	public String generateLTLString(String letter, int count) {
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

	@Override
	public List<String> generateLTLArray(String letter, int count) {
		List<String> output = new ArrayList<String>();

		for (int n = 1; n <= count; n++) {
			if (n == count) {
				output.add(letter + n);

				// Closing Parenthesis
				for (int i = 1; i < count; i++) {
					output.add(CLOSE_P + CLOSE_P);
				}
			} else {
				output.add(OPEN_P + letter + n++ + AND + NEXT);
				output.add(OPEN_P + NOT + letter + n + UNTIL);
				n--;
			}
		}

		return output;
	}
}