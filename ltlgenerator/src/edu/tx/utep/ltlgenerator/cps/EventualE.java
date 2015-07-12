package edu.tx.utep.ltlgenerator.cps;

import java.util.ArrayList;
import java.util.List;

public class EventualE extends CompositeProposition {

	// (!p1 ^ !p2 ^ !p3 ^ !p4 ^ !p5) ^ ((!p1 ^ !p2 ^ !p3 ^ !p4 ^ !p5) U (p1 ^ !p2 ^ !p3 ^ !p4 ^ !p5 ^ ((!p2 ^ !p3 ^ !p4 ^ !p5) U (p2 ^ !p3 ^ !p4 ^ !p5 ^ ((!p3 ^ !p4 ^ !p5) U (p3 ^ !p4 ^ !p5 ^ ((!p4 ^ !p5) U (p4 ^ !p5 ^ (!p5 U p5)))))))))

	@Override
	public String generateLTLString(String letter, int count) {
		StringBuilder formula = new StringBuilder();
		StringBuilder initialString = new StringBuilder();
		StringBuilder intermediateString = new StringBuilder();

		// Initial
		initialString.append(OPEN_P).append(generateProposition(CPT_NOT_AND, letter, 1, count)).append(CLOSE_P).append(AND);

		// Repetitive Pattern
		for (int i = 1; i < count; i++) {
			intermediateString.append(OPEN_P).append(OPEN_P).append(generateProposition(CPT_NOT_AND, letter, i, count)).append(CLOSE_P).append(UNTIL).append(OPEN_P).append(letter).append(i).append(AND).append(generateProposition(CPT_NOT_AND, letter, i + 1, count)).append(AND);

			if (i + 1 >= count) {
				intermediateString.append(OPEN_P).append(NOT).append(letter).append(i + 1).append(UNTIL).append(letter).append(i + 1).append(CLOSE_P);
			}
		}

		// Adding Parenthesis At The End
		for (int i = 1; i < count; i++) {
			intermediateString.append(CLOSE_P).append(CLOSE_P);
		}

		formula.append(initialString).append(intermediateString);

		return formula.toString();
	}

	@Override
	public List<String> generateLTLArray(String letter, int count) {
		List<String> output = new ArrayList<String>();
		String closingParentheses = "";

		output.add(OPEN_P + generateProposition(CPT_NOT_AND, letter, 1, count) + CLOSE_P);
		output.add(AND);

		for (int n = 1; n < count; n++) {
			output.add(OPEN_P);
			output.add(OPEN_P + generateProposition(CPT_NOT_AND, letter, n, count) + CLOSE_P);
			output.add(UNTIL);
			output.add(OPEN_P + letter + n + AND + generateProposition(CPT_NOT_AND, letter, n + 1, count));
			output.add(AND);

			if (n + 1 >= count) {
				output.add(OPEN_P);
				output.add(OPEN_P + NOT + letter + ++n + CLOSE_P);
				output.add(UNTIL);
				output.add(OPEN_P + letter + n);
				closingParentheses += (CLOSE_P + CLOSE_P);
				n--;
			}
		}

		for (int i = 1; i < count; i++) {
			closingParentheses += (CLOSE_P + CLOSE_P);
		}

		output.add(closingParentheses);

		return output;
	}
}
