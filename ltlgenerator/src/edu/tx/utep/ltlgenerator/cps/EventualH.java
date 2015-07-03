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
			intermediateString.append(OPEN_P).append(letter).append(i).append(AND).append(generateProposition(CPT_NOT_AND, letter, i + 1, count)).append(AND).append(OPEN_P).append(OPEN_P).append(generateProposition(CPT_NOT_AND, letter, i + 1, count)).append(CLOSE_P);

			if (i + 1 < count) {
				intermediateString.append(UNTIL);
			} else {
				intermediateString.append(UNTIL).append(letter).append(i + 1);
			}
		}

		// Adding Parenthesis At The End
		for (int i = 1; i < count; i++) {
			intermediateString.append(CLOSE_P).append(CLOSE_P);
		}

		formula.append(intermediateString);

		return formula.toString();
	}

}
