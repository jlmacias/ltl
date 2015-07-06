package edu.tx.utep.ltlgenerator.cps;

import java.util.ArrayList;
import java.util.List;

public class ParallelE extends CompositeProposition {

	private static String cpFormula = OPEN_P + CPT_NOT_AND + CLOSE_P + AND + OPEN_P + OPEN_P + CPT_NOT_AND + CLOSE_P + UNTIL + OPEN_P + CPT_AND + CLOSE_P + CLOSE_P;

	@Override
	public String generateLTLString(String letter, int count) {
		String formula = cpFormula;
		String notAnd = generateProposition(CPT_NOT_AND, letter, 1, count);
		String and = generateProposition(CPT_AND, letter, 1, count);

		formula = formula.replace(CPT_NOT_AND, notAnd);
		formula = formula.replace(CPT_AND, and);
		return formula;
	}

	@Override
	public List<String> generateLTLArray(String letter, int count) {
		List<String> output = new ArrayList<String>();
		String notAnd = OPEN_P + generateProposition(CPT_NOT_AND, letter, 1, count) + CLOSE_P;
		String or = OPEN_P + generateProposition(CPT_AND, letter, 1, count) + CLOSE_P;

		output.add(notAnd);
		output.add(AND);
		output.add(OPEN_P);
		output.add(notAnd);
		output.add(UNTIL);
		output.add (or);
		output.add(CLOSE_P);
		
		return output;
	}


}
