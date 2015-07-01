package edu.tx.utep.ltlgenerator.cps;

public class ParallelE extends CompositeProposition {

	private static String cpFormula = "(" + NOT_AND + ") ^ ((" + NOT_AND + ") U (" + AND + "))";

	@Override
	public String generateLTL(String letter, int count) {
		String formula = cpFormula;
		String notAnd = generateProposition(NOT_AND, letter, count);
		String and = generateProposition(AND, letter, count);

		formula = formula.replace(NOT_AND, notAnd);
		formula = formula.replace(AND, and);
		return formula;
	}

}
