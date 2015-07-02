package edu.tx.utep.ltlgenerator.cps;

public class ParallelE extends CompositeProposition {

	private static String cpFormula = OPEN_P + CPT_NOT_AND + CLOSE_P + AND + OPEN_P + OPEN_P + CPT_NOT_AND + CLOSE_P + UNTIL + OPEN_P + CPT_AND + CLOSE_P + CLOSE_P;

	@Override
	public String generateLTL(String letter, int count) {
		String formula = cpFormula;
		String notAnd = generateProposition(CPT_NOT_AND, letter, 1, count);
		String and = generateProposition(CPT_AND, letter, 1, count);

		formula = formula.replace(CPT_NOT_AND, notAnd);
		formula = formula.replace(CPT_AND, and);
		return formula;
	}

}
