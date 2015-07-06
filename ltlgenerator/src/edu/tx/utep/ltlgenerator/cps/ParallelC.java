package edu.tx.utep.ltlgenerator.cps;

import java.util.ArrayList;
import java.util.List;

public class ParallelC extends CompositeProposition {

	private static String cpFormula = OPEN_P + CPT_AND + CLOSE_P;

	@Override
	public String generateLTLString(String letter, int count) {
		String formula = cpFormula;
		String and = generateProposition(CPT_AND, letter, 1, count);

		formula = formula.replace(CPT_AND, and);
		return formula;
	}

	@Override
	public List<String> generateLTLArray(String letter, int count) {
		List<String> output = new ArrayList<String>();
		String and = generateProposition(CPT_AND, letter, 1, count);
		
		output.add(OPEN_P + and + CLOSE_P);
		return output;
	}

}
