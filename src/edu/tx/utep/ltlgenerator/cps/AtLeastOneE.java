package edu.tx.utep.ltlgenerator.cps;

public class AtLeastOneE extends CompositeProposition {

	private static String cpFormula = "(" + NOT_AND + ") ^ ((" + NOT_AND + ") U (" + OR + "))";

	@Override
	public String generateLTL(String letter, int count) {
		String formula = cpFormula;
		String notAnd = generateProposition(NOT_AND, letter, count);
		String or = generateProposition(OR, letter, count);

		formula = formula.replace(NOT_AND, notAnd);
		formula = formula.replace(OR, or);
		return formula;
	}

}
