package edu.tx.utep.ltlgenerator.cps;

public class EventualH extends CompositeProposition {

	// (p1 ^ !p2 ^ !p3 ^ !p4 ^ ((!p2 ^ !p3 ^ !p4) U (p2 ^ !p3 ^ !p4 ^ ((!p3 ^ !p4) U (p3 ^ !p4 ^ (!p4 U p4))))))
	// (p1 ^ !p2 ^ !p3 ^ !p4 ^ !p5 ^ ((!p2 ^ !p3 ^ !p4 ^ !p5) U (p2 ^ !p3 ^ !p4 ^ !p5 ^ ((!p3 ^ !p4 ^ !p5) U (p3 ^ !p4 ^ !p5) ^ ((!p4 ^ !p5) U (p4 ^ !p5 ^ (!p5 U p5)))))))

	@Override
	public String generateLTL(String letter, int count) {
		StringBuilder formula = new StringBuilder();
		StringBuilder intermediateString = new StringBuilder();

		// Repetitive Pattern
		for (int i = 1; i < count; i++) {
			intermediateString.append("(").append(letter).append(i).append(" ^ ").append(generateProposition(NOT_AND, letter, i+1, count)).append(" ^ ").append("(").append("(").append(generateProposition(NOT_AND, letter, i+1, count)).append(")");

			if (i+1 < count) {
				intermediateString.append(" U ");
			} else {
				intermediateString.append(" U ").append(letter).append(i+1);
			}
		}

		// Adding Parenthesis At The End
		for (int i = 1; i < count; i++) {
			intermediateString.append("))");
		}

		formula.append(intermediateString);

		return formula.toString();
	}

}
