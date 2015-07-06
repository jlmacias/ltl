package edu.tx.utep.ltlgenerator.cps;

import java.util.ArrayList;
import java.util.List;

public class AtLeastOneC extends CompositeProposition {

	private static String cpFormula = OPEN_P + CPT_OR + CLOSE_P;

	@Override
	public String generateLTLString(String letter, int count) {
		String formula = cpFormula;
		String or = generateProposition(CPT_OR, letter, 1, count);

		formula = formula.replace(CPT_OR, or);
		return formula;
	}

	@Override
	public List<String> generateLTLArray(String letter, int count) {
		List<String> output = new ArrayList<String>();
		String or = generateProposition(CPT_OR, letter, 1, count);
		
		output.add(OPEN_P + or + CLOSE_P);
		return output;
	}

}
