package edu.tx.utep.ltlgenerator.cps;

import java.util.ArrayList;
import java.util.List;

import edu.tx.utep.ltlgenerator.OutputCharacters;

public class ConsecutiveE extends CompositeProposition {

	// private static String cpFormula = "(!l1 ^ !l2 ^ !l3 ^ !l4) ^ ((!l1 ^ !l2 ^ !l3 ^ !l4) U (l1 ^ !l2 ^ !l3 ^ !l4 ^ X(l2 ^ !l3 ^ !l4 ^ X(l3 ^ !l4 ^ Xl4))))";
	@Override
	public List<String> generateLTLArray(String letter, int count) {
		List<String> output = new ArrayList<String>();
		StringBuilder intermediateString = new StringBuilder();
		String closingParens = "";

		// Initial String (Not Repetitive)
		output.add(OutputCharacters.OPEN_P + generateProposition(CPT_NOT_AND, letter, 1, count) + OutputCharacters.CLOSE_P);
		output.add(OutputCharacters.AND);
		output.add(OutputCharacters.OPEN_P);
		output.add(OutputCharacters.OPEN_P + generateProposition(CPT_NOT_AND, letter, 1, count) + OutputCharacters.CLOSE_P);
		output.add(OutputCharacters.UNTIL);

		// Repetitive Pattern
		for (int i = 1; i < count; i++) {
			intermediateString.setLength(0);
			intermediateString.append(OutputCharacters.OPEN_P).append(generateProposition(CPT_NOT_AND, letter, i, count, false));
			output.add(intermediateString.toString());

			output.add(OutputCharacters.AND);
			output.add(OutputCharacters.NEXT);
			if (i + 1 == count) {
				intermediateString.setLength(0);
				intermediateString.append(OutputCharacters.OPEN_P).append(letter).append(i + 1).append(OutputCharacters.CLOSE_P);
				output.add(intermediateString.toString());
			}

			closingParens = closingParens + OutputCharacters.CLOSE_P;
		}

		output.add(closingParens + OutputCharacters.CLOSE_P);

		return output;
	}
}
