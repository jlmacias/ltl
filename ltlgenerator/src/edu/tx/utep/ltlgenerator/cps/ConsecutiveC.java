package edu.tx.utep.ltlgenerator.cps;

import java.util.ArrayList;
import java.util.List;

public class ConsecutiveC extends CompositeProposition {

	//"(p1 ^ X(p2 ^ X(p3)))";

	@Override
	public String generateLTLString(String letter, int count) {
		StringBuilder formula = new StringBuilder();
		StringBuilder intermediateString = new StringBuilder();
		String closingParens = "";

		for (int i = 1; i <= count; i++) {
			intermediateString.setLength(0);
			intermediateString.append(OPEN_P).append(letter).append(i);
			formula.append(intermediateString);

			if (i < count) {
				formula.append(AND).append(NEXT);
			}

			closingParens = closingParens + CLOSE_P;
		}

		return formula.append(closingParens).toString();
	}

	@Override
	public List<String> generateLTLArray(String letter, int count) {
		List<String> output = new ArrayList<String>();
		StringBuilder intermediateString = new StringBuilder();
		String closingParens = "";

		for (int i = 1; i <= count; i++) {
			intermediateString.setLength(0);
			intermediateString.append(OPEN_P).append(letter).append(i);
			output.add(intermediateString.toString());

			if (i < count) {
				output.add(AND);
				output.add(NEXT);
			}

			closingParens = closingParens + CLOSE_P;
		}

		output.add(closingParens);
		return output;
	}

}
