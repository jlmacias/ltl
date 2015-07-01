package edu.tx.utep.ltlgenerator.cps;

public class AtLeastOneC extends CompositeProposition {

	private static String cpFormula = "(" + OR + ")";

	@Override
	public String generateLTL(String letter, int count) {
		String formula = cpFormula;
		String or = generateProposition(OR, letter, 1, count);

		formula = formula.replace(OR, or);
		return formula;
	}

}
