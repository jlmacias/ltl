package edu.tx.utep.ltlgenerator.cps;

public class ConsecutiveC extends CompositeProposition {

	// private static String cpFormula = "(p1 ^ X(p2 ^ X(p3)))";

	@Override
	public String generateLTL(String letter, int count) {
		StringBuilder formula = new StringBuilder();
		StringBuilder intermediateString = new StringBuilder();

		for (int i = count; i > 0; i--) {
			if (i == count) {
				formula.append(NEXT).append(OPEN_P).append(letter).append(i).append(CLOSE_P);
			} else {
				intermediateString.setLength(0);
				intermediateString.append(OPEN_P).append(letter).append(i).append(AND);
				formula.insert(0, intermediateString).append(CLOSE_P);

				if (i > 1) {
					formula.insert(0, NEXT);
				}
			}
		}

		return formula.toString();
	}

}
