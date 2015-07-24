package edu.tx.utep.ltlgenerator.cps;

import java.util.ArrayList;
import java.util.List;

public class AtLeastOneH extends CompositeProposition {

	@Override
	public List<String> generateLTLArray(String letter, int count) {
		List<String> output = new ArrayList<String>();
		String or = generateProposition(CPT_OR, letter, 1, count);

		output.add(OPEN_P + or + CLOSE_P);
		return output;
	}

}
