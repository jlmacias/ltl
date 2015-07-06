package edu.tx.utep.ltlgenerator.cps;

import java.util.List;

public class ConsecutiveH extends CompositeProposition {

	// private static String cpFormula = "(p1 ^ !p2 ^ !p3 ^ !p4 ^ X(p2 ^ !p3 ^ !p4 ^ X(p3 ^ !p4 ^ Xp4)))";

	@Override
	public String generateLTLString(String letter, int count) {
		StringBuilder formula = new StringBuilder();
		StringBuilder intermediateString = new StringBuilder();

		for (int i = count; i > 0; i--) {
			if (i == count) {
				formula.append(AND).append(NEXT).append(letter).append(i);
			} else {
				intermediateString.setLength(0);
				intermediateString.append(OPEN_P).append(letter).append(i).append(AND).append(generateProposition(CPT_NOT_AND, letter, i + 1, count));
				formula.insert(0, intermediateString).append(CLOSE_P);

				if (i > 1) {
					formula.insert(0, AND + NEXT);
				}
			}
		}

		return formula.toString();
	}


	@Override
	public List<String> generateLTLArray(String letter, int count) {
		return null;
	}
}
