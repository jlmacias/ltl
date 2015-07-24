package edu.tx.utep.ltlgenerator.cps;

import java.util.ArrayList;
import java.util.List;

public class EventualH extends CompositeProposition {

	// (p1 ^ !p2 ^ !p3 ^ !p4 ^ ((!p2 ^ !p3 ^ !p4) U (p2 ^ !p3 ^ !p4 ^ ((!p3 ^ !p4) U (p3 ^ !p4 ^ (!p4 U p4))))))
	// (p1 ^ !p2 ^ !p3 ^ !p4 ^ !p5 ^ ((!p2 ^ !p3 ^ !p4 ^ !p5) U (p2 ^ !p3 ^ !p4 ^ !p5 ^ ((!p3 ^ !p4 ^ !p5) U (p3 ^ !p4 ^ !p5) ^ ((!p4 ^ !p5) U (p4 ^ !p5 ^ (!p5 U p5)))))))

	@Override
	public List<String> generateLTLArray(String letter, int count) {
		List<String> output = new ArrayList<String>();
		String closingParentheses = "";

		for (int n = 1; n < count; n++) {
			output.add(OPEN_P + letter + n + AND + generateProposition(CPT_NOT_AND, letter, n + 1, count));
			output.add(AND);
			output.add(OPEN_P);
			output.add(OPEN_P + generateProposition(CPT_NOT_AND, letter, n + 1, count) + CLOSE_P);

			if (n + 1 < count) {
				output.add(UNTIL);
			} else {
				output.add(UNTIL);
				output.add(OPEN_P + letter + ++n);
                closingParentheses += CLOSE_P;
				for (int i = 1; i < count; i++) {
					closingParentheses += (CLOSE_P + CLOSE_P);
				}
			}
		}

		output.add(closingParentheses);

		return output;
	}
}
