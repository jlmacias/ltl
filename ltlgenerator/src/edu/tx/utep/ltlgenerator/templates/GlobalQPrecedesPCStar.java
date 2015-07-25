package edu.tx.utep.ltlgenerator.templates;

import java.util.List;

public class GlobalQPrecedesPCStar extends Template {

	private static String template = "!((!Q) U (P ^ !Q))";

	@Override
	public String generateFormula(String pProposition, String qProposition, String rProposition, String lProposition) {
		String formula = template;
		List<String> p = getCompositeProposition(pProposition);
		List<String> q = getCompositeProposition(qProposition);

		String notQ = "!" + String.join("", q);
		String jointP = String.join("", p);

		formula = formula.replace("!Q", notQ);
		formula = formula.replace("P", jointP);

		return formula;
	}

}
