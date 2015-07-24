package edu.tx.utep.ltlgenerator.cps;

import java.util.ArrayList;
import java.util.List;

public class AtLeastOneE extends CompositeProposition {

	@Override
	public List<String> generateLTLArray(String letter, int count) {
		List<String> output = new ArrayList<String>();
		String notAnd = OPEN_P + generateProposition(CPT_NOT_AND, letter, 1, count) + CLOSE_P;
		String or = OPEN_P + generateProposition(CPT_OR, letter, 1, count) + CLOSE_P;

		output.add(notAnd);

		output.add(AND);

		output.add(OPEN_P);
		output.add(notAnd);
		output.add(UNTIL);
		output.add(or);
		output.add(CLOSE_P);
		
		return output;
	}

}
