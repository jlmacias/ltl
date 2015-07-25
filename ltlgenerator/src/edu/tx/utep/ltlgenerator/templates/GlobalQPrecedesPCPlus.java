package edu.tx.utep.ltlgenerator.templates;

import java.util.List;

public class GlobalQPrecedesPCPlus extends Template {

	private static String template = "!((!(Q andMinusL !P)) U P)";

	@Override
	public String generateFormula(String pProposition, String qProposition, String rProposition, String lProposition) {
		String formula = template;
		List<String> p = getCompositeProposition(pProposition);
		List<String> q = getCompositeProposition(qProposition);

		String jointP = String.join("", p);
		List<String> notP = p;
		notP.add(0, "!");

		String qAndMinusLNotP = operatorGenerator.getAndedPropositions(AND_MINUS_L, q, notP);

		formula = formula.replace("Q andMinusL !P", qAndMinusLNotP);
		formula = formula.replace("P", jointP);

		return formula;
	}

}
