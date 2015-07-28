package edu.tx.utep.ltlgenerator.cps;

import java.util.ArrayList;
import java.util.List;

import edu.tx.utep.ltlgenerator.OutputCharacters;

public class EventualE extends CompositeProposition {

	// (!p1 ^ !p2 ^ !p3 ^ !p4 ^ !p5) ^ ((!p1 ^ !p2 ^ !p3 ^ !p4 ^ !p5) U (p1 ^ !p2 ^ !p3 ^ !p4 ^ !p5 ^ ((!p2 ^ !p3 ^ !p4 ^ !p5) U (p2 ^ !p3 ^ !p4 ^ !p5 ^ ((!p3 ^ !p4 ^ !p5) U (p3 ^ !p4 ^ !p5 ^ ((!p4 ^ !p5) U (p4 ^ !p5 ^ (!p5 U p5)))))))))

	@Override
	public List<String> generateLTLArray(String letter, int count) {
		List<String> output = new ArrayList<String>();
		String closingParentheses = "";

		output.add(OutputCharacters.OPEN_P + generateProposition(CPT_NOT_AND, letter, 1, count) + OutputCharacters.CLOSE_P);
		output.add(OutputCharacters.AND);

		for (int n = 1; n < count; n++) {
			output.add(OutputCharacters.OPEN_P);
			output.add(OutputCharacters.OPEN_P + generateProposition(CPT_NOT_AND, letter, n, count) + OutputCharacters.CLOSE_P);
			output.add(OutputCharacters.UNTIL);
			output.add(OutputCharacters.OPEN_P + letter + n + OutputCharacters.AND + generateProposition(CPT_NOT_AND, letter, n + 1, count));
			output.add(OutputCharacters.AND);

			if (n + 1 >= count) {
				output.add(OutputCharacters.OPEN_P);
				output.add(OutputCharacters.OPEN_P + OutputCharacters.NOT + letter + ++n + OutputCharacters.CLOSE_P);
				output.add(OutputCharacters.UNTIL);
				output.add(OutputCharacters.OPEN_P + letter + n);
				closingParentheses += (OutputCharacters.CLOSE_P + OutputCharacters.CLOSE_P);
				n--;
			}
		}

		for (int i = 1; i < count; i++) {
			closingParentheses += (OutputCharacters.CLOSE_P + OutputCharacters.CLOSE_P);
		}

		output.add(closingParentheses);

		return output;
	}
}
