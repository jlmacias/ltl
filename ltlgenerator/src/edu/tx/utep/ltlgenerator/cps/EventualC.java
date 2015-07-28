package edu.tx.utep.ltlgenerator.cps;

import java.util.ArrayList;
import java.util.List;

import edu.tx.utep.ltlgenerator.OutputCharacters;

public class EventualC extends CompositeProposition {

	// private static String cpFormula = "(q1 ^ X(!q2 U (q2 ^ X(!q3 U (q3 ^ X(!q4 U q4))))))";

	@Override
	public List<String> generateLTLArray(String letter, int count) {
		List<String> output = new ArrayList<String>();
		String closingParentheses = "";

		for (int n = 1; n <= count; n++) {
			if (n == count) {
				output.add(OutputCharacters.OPEN_P + letter + n);
				closingParentheses += OutputCharacters.CLOSE_P;
				for (int i = 1; i < count; i++) {
					closingParentheses += (OutputCharacters.CLOSE_P + OutputCharacters.CLOSE_P);
				}
			} else {
				output.add(OutputCharacters.OPEN_P + letter + n);
				output.add(OutputCharacters.AND);
				output.add(OutputCharacters.NEXT);
				output.add(OutputCharacters.OPEN_P + OutputCharacters.NOT + letter + ++n);
				n--;
				output.add(OutputCharacters.UNTIL);
			}
		}
		output.add(closingParentheses);

		return output;
	}
}