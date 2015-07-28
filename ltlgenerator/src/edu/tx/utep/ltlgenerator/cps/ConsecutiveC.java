package edu.tx.utep.ltlgenerator.cps;

import java.util.ArrayList;
import java.util.List;

import edu.tx.utep.ltlgenerator.OutputCharacters;

public class ConsecutiveC extends CompositeProposition {

	// "(p1 ^ X(p2 ^ X(p3)))";

	@Override
	public List<String> generateLTLArray(String letter, int count) {
		List<String> output = new ArrayList<String>();
		StringBuilder intermediateString = new StringBuilder();
		String closingParens = "";

		for (int i = 1; i <= count; i++) {
			intermediateString.setLength(0);
			intermediateString.append(OutputCharacters.OPEN_P).append(letter).append(i);
			output.add(intermediateString.toString());

			if (i < count) {
				output.add(OutputCharacters.AND);
				output.add(OutputCharacters.NEXT);
			}

			closingParens = closingParens + OutputCharacters.CLOSE_P;
		}

		output.add(closingParens);

		return output;
	}

}
