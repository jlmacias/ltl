package edu.tx.utep.ltlgenerator.cps;

public class ParallelC extends CompositeProposition {

	private static String cpFormula = "(" + AND + ")";

	@Override
	public String generateLTL(String letter, int count) {
		String formula = cpFormula;
		String and = generateProposition(AND, letter, count);

		formula = formula.replace(AND, and);
		return formula;
	}

}
