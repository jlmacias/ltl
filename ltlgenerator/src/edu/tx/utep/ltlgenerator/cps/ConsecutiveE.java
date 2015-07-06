package edu.tx.utep.ltlgenerator.cps;

import java.util.ArrayList;
import java.util.List;

public class ConsecutiveE extends CompositeProposition {

	// private static String cpFormula = "(!l1 ^ !l2 ^ !l3 ^ !l4) ^ ((!l1 ^ !l2 ^ !l3 ^ !l4) U (l1 ^ !l2 ^ !l3 ^ !l4 ^ X(l2 ^ !l3 ^ !l4 ^ X(l3 ^ !l4 ^ Xl4))))";

	@Override
	public String generateLTLString(String letter, int count) {
		StringBuilder formula = new StringBuilder();
		StringBuilder intermediateString = new StringBuilder();
		StringBuilder initialString = new StringBuilder();

		// Initial String (Not Repetitive)
		initialString.append(OPEN_P);
		for (int i = 1; i <= count; i++) {
			initialString.append(NOT).append(letter).append(i);

			if (i < count) {
				initialString.append(AND);
			}
		}
		initialString.append(CLOSE_P);

		// Repetitive Pattern
		for (int i = 1; i < count; i++) {
			intermediateString.append(OPEN_P).append(letter).append(i).append(AND).append(generateProposition(CPT_NOT_AND, letter, i + 1, count));

			if (i + 1 < count) {
				intermediateString.append(AND).append(NEXT);
			} else {
				intermediateString.append(AND).append(NEXT).append(letter).append(i + 1);
			}
		}

		// Adding Parenthesis At The End
		for (int i = 1; i < count; i++) {
			intermediateString.append(CLOSE_P);
		}

		formula.append(initialString).append(AND).append(OPEN_P).append(initialString).append(UNTIL).append(intermediateString).append(CLOSE_P);

		return formula.toString();
	}

	// private static String cpFormula = "(!l1 ^ !l2 ^ !l3 ^ !l4) ^ ((!l1 ^ !l2 ^ !l3 ^ !l4) U (l1 ^ !l2 ^ !l3 ^ !l4 ^ X(l2 ^ !l3 ^ !l4 ^ X(l3 ^ !l4 ^ Xl4))))";
	@Override
	public List<String> generateLTLArray(String letter, int count) {
		List<String> output = new ArrayList<String>();
		StringBuilder intermediateString = new StringBuilder();
		String closingParens = "";
		
		// Initial String (Not Repetitive)
		output.add(OPEN_P + generateProposition(CPT_NOT_AND, letter, 1, count) + CLOSE_P);
		output.add(AND);
		output.add(OPEN_P);
		output.add(OPEN_P + generateProposition(CPT_NOT_AND, letter, 1, count) + CLOSE_P);
		output.add(UNTIL);
		
		// Repetitive Pattern
		for (int i = 1; i < count; i++) {
			intermediateString.setLength(0);
			intermediateString.append(OPEN_P).append(generateProposition(CPT_NOT_AND, letter, i, count, false));
			output.add(intermediateString.toString());
			
			output.add(AND);
			output.add(NEXT);
			if (i + 1 == count) {
				intermediateString.setLength(0);
				intermediateString.append(OPEN_P).append(letter).append(i+1).append(CLOSE_P);
				output.add(intermediateString.toString());
			}
			
			closingParens = closingParens + CLOSE_P;
		}

		output.add(closingParens + CLOSE_P);
		
		return output;
	}
}
