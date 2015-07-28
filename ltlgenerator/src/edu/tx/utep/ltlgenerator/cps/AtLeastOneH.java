package edu.tx.utep.ltlgenerator.cps;

import java.util.ArrayList;
import java.util.List;

import edu.tx.utep.ltlgenerator.OutputCharacters;

public class AtLeastOneH extends CompositeProposition {

	@Override
	public List<String> generateLTLArray(String letter, int count) {
		List<String> output = new ArrayList<String>();
		String or = generateProposition(CPT_OR, letter, 1, count);

		output.add(OutputCharacters.OPEN_P + or + OutputCharacters.CLOSE_P);
		return output;
	}

}
