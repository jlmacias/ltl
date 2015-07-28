package edu.tx.utep.ltlgenerator.cps;

import java.util.ArrayList;
import java.util.List;

import edu.tx.utep.ltlgenerator.OutputCharacters;

public class ConsecutiveH extends CompositeProposition {

	// private static String cpFormula = "(p1 ^ !p2 ^ !p3 ^ !p4 ^ X(p2 ^ !p3 ^ !p4 ^ X(p3 ^ !p4 ^ Xp4)))";

	@Override
	public List<String> generateLTLArray(String letter, int count) {
		List<String> output = new ArrayList<String>();
		String closingParentheses = "";

		for (int n = 1; n < count; n++) {
			output.add(OutputCharacters.OPEN_P + generateProposition(CPT_NOT_AND, letter, n, count, false));
			output.add(OutputCharacters.AND);
			output.add(OutputCharacters.NEXT);

			if (n + 1 == count) {
				output.add(OutputCharacters.OPEN_P + letter + ++n);
				closingParentheses += OutputCharacters.CLOSE_P;
				n--;
			}
		}

		for (int n = 1; n < count; n++) {
			closingParentheses += OutputCharacters.CLOSE_P;
		}

		output.add(closingParentheses);

		return output;
	}
}
