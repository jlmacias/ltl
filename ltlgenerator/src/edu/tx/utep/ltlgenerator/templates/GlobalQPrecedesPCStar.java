package edu.tx.utep.ltlgenerator.templates;

import java.util.List;

public class GlobalQPrecedesPCStar extends Template {

	private static String template = "!((!Q) U (P ^ !Q))";

	@Override
	public String generateFormula(List<String> p, List<String> q, List<String> r, List<String> l) {
		String formula = template;
		String notQ = "!" + String.join("", q);
		String jointP = String.join("", p);
		
		formula = formula.replace("!Q", notQ);
		formula = formula.replace("P", jointP);
		
		return formula;
	}

}
