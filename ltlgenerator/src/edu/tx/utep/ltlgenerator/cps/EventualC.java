package edu.tx.utep.ltlgenerator.cps;

import java.util.ArrayList;
import java.util.List;

public class EventualC extends CompositeProposition {

	// private static String cpFormula = "(q1 ^ X(!q2 U (q2 ^ X(!q3 U (q3 ^ X(!q4 U q4))))))";

	@Override
	public List<String> generateLTLArray(String letter, int count) {
		List<String> output = new ArrayList<String>();
		String closingParentheses = "";
		
		for (int n = 1; n <= count; n++) {
			if (n == count) {
				output.add(OPEN_P + letter + n );
				closingParentheses += CLOSE_P;
				for (int i = 1; i < count; i++) {
					closingParentheses += (CLOSE_P + CLOSE_P);
				}
			} else {
				output.add(OPEN_P + letter + n);
				output.add(AND);
				output.add(NEXT);
				output.add(OPEN_P + NOT + letter + ++n);
				n--;
				output.add(UNTIL);
			}
		}
		output.add(closingParentheses);

		return output;
	}
}