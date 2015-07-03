package edu.tx.utep.ltlgenerator.cps;

public class AtLeastOneC extends CompositeProposition {

	private static String cpFormula = OPEN_P + CPT_OR + CLOSE_P;

	@Override
	public String generateLTL(String letter, int count) {
		String formula = cpFormula;
		String or = generateProposition(CPT_OR, letter, 1, count);

		formula = formula.replace(CPT_OR, or);
		return formula;
	}

}
