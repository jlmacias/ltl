package edu.tx.utep.ltlgenerator.cps;

public class ParallelC extends CompositeProposition {

	private static String cpFormula = OPEN_P + CPT_AND + CLOSE_P;

	@Override
	public String generateLTL(String letter, int count) {
		String formula = cpFormula;
		String and = generateProposition(CPT_AND, letter, 1, count);

		formula = formula.replace(CPT_AND, and);
		return formula;
	}

}
