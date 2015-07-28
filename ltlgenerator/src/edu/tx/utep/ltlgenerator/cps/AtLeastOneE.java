package edu.tx.utep.ltlgenerator.cps;

import java.util.ArrayList;
import java.util.List;

import edu.tx.utep.ltlgenerator.OutputCharacters;

public class AtLeastOneE extends CompositeProposition {

	@Override
	public List<String> generateLTLArray(String letter, int count) {
		List<String> output = new ArrayList<String>();
		String notAnd = OutputCharacters.OPEN_P + generateProposition(CPT_NOT_AND, letter, 1, count) + OutputCharacters.CLOSE_P;
		String or = OutputCharacters.OPEN_P + generateProposition(CPT_OR, letter, 1, count) + OutputCharacters.CLOSE_P;

		output.add(notAnd);

		output.add(OutputCharacters.AND);

		output.add(OutputCharacters.OPEN_P);
		output.add(notAnd);
		output.add(OutputCharacters.UNTIL);
		output.add(or);
		output.add(OutputCharacters.CLOSE_P);

		return output;
	}

}
