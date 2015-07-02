package edu.tx.utep.ltlgenerator.cps;

public class EventualE extends CompositeProposition {

	// (!p1 ^ !p2 ^ !p3 ^ !p4 ^ !p5) ^ ((!p1 ^ !p2 ^ !p3 ^ !p4 ^ !p5) U (p1 ^ !p2 ^ !p3 ^ !p4 ^ !p5 ^ ((!p2 ^ !p3 ^ !p4 ^ !p5) U (p2 ^ !p3 ^ !p4 ^ !p5 ^ ((!p3 ^ !p4 ^ !p5) U (p3 ^ !p4 ^ !p5 ^ ((!p4 ^ !p5) U (p4 ^ !p5 ^ (!p5 U p5)))))))))

	@Override
	public String generateLTL(String letter, int count) {
		StringBuilder formula = new StringBuilder();
		StringBuilder initialString = new StringBuilder();
		StringBuilder intermediateString = new StringBuilder();

		// Initial
		initialString.append("(").append(generateProposition(NOT_AND, letter, 1, count)).append(") ^ ");

		// Repetitive Pattern
		for (int i = 1; i < count; i++) {
			intermediateString.append("((").append(generateProposition(NOT_AND, letter, i, count)).append(")").append(" U ").append("(").append(letter).append(i).append(" ^ ").append(generateProposition(NOT_AND, letter, i+1, count)).append(" ^ ");

			if (i + 1 >= count) {
				intermediateString.append("(").append("!").append(letter).append(i + 1).append(" U ").append(letter).append(i + 1).append(")");
			}
		}

		// Adding Parenthesis At The End
		for (int i = 1; i < count; i++) {
			intermediateString.append("))");
		}

		formula.append(initialString).append(intermediateString);

		return formula.toString();
	}

}
