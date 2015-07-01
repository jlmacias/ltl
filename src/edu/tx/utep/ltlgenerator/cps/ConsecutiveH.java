package edu.tx.utep.ltlgenerator.cps;

public class ConsecutiveH extends CompositeProposition {

	//private static String cpFormula = "(p1 ^ !p2 ^ !p3 ^ !p4 ^ X(p2 ^ !p3 ^ !p4 ^ X(p3 ^ !p4 ^ Xp4)))";

	@Override
	public String generateLTL(String letter, int count) {
		StringBuilder formula = new StringBuilder();
		StringBuilder intermediateString = new StringBuilder();

		for (int i = count; i > 0; i--) {
			if (i == count) {
				formula.append("^ X").append(letter).append(i).append("");
			} else {
				intermediateString.setLength(0);
				intermediateString.append("(").append(letter).append(i).append(" ^ ").append(generateProposition(NOT_AND, letter, i+1, count)).append(" ");
				formula.insert(0, intermediateString).append(")");

				if (i > 1) {
					formula.insert(0, "^ X");
				}
			}
		}

		return formula.toString();
	}

}
