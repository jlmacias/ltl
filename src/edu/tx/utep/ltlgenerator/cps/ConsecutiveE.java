package edu.tx.utep.ltlgenerator.cps;

public class ConsecutiveE extends CompositeProposition {

	//private static String cpFormula = "(!l1 ^ !l2 ^ !l3 ^ !l4) ^ ((!l1 ^ !l2 ^ !l3 ^ !l4 ) U (l1 ^ !l2 ^ !l3 ^ !l4 ^ X(l2 ^ !l3 ^ !l4^ X(l3 ^ !l4 ^ Xl4))))"; 

	@Override
	public String generateLTL(String letter, int count) {
		StringBuilder formula = new StringBuilder();
		StringBuilder intermediateString = new StringBuilder();
		StringBuilder initialString = new StringBuilder();

		// Initial String (Not Repetitive)
		initialString.append("(");
		for (int i = 1; i <= count; i++) {
			initialString.append("!").append(letter).append(i);

			if (i < count) {
				initialString.append(" ^ ");
			}
		}
		initialString.append(") ");

		// Repetitive Pattern
		for (int i = 1; i < count; i++) {
			intermediateString.append("(").append(letter).append(i).append(" ^ ").append(generateProposition(NOT_AND, letter, i+1, count));

			if (i+1 < count) {
				intermediateString.append(" ^ X");
			} else {
				intermediateString.append(" ^ X").append(letter).append(i+1);
			}
		}

		// Adding Parenthesis At The End
		for (int i = 1; i < count; i++) {
			intermediateString.append(")");
		}

		formula.append(initialString).append("^ (").append(initialString).append("U ").append(intermediateString).append(")");

		return formula.toString();
	}

}
