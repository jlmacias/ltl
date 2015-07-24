package edu.tx.utep.ltlgenerator.cps;

import java.util.ArrayList;
import java.util.List;

public class ParallelH extends CompositeProposition {

	@Override
	public List<String> generateLTLArray(String letter, int count) {
		List<String> output = new ArrayList<String>();
		String and = generateProposition(CPT_AND, letter, 1, count);
		
		output.add(OPEN_P + and + CLOSE_P);
		return output;
	}

}
