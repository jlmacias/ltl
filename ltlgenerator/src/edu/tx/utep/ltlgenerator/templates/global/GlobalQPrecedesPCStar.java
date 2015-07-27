package edu.tx.utep.ltlgenerator.templates.global;

import java.util.List;

import edu.tx.utep.ltlgenerator.templates.Template;

public class GlobalQPrecedesPCStar extends Template {

	private static String template = "!((!Q) U (P ^ !Q))";

	@Override
	public String generateFormula(String pProposition, String qProposition, String rProposition, String lProposition) {
		String formula = template;
		List<String> p = getCompositeProposition(pProposition);
		List<String> q = getCompositeProposition(qProposition);
		String pString = String.join("", p);
		String qString = String.join("", q);

		formula = formula.replace("Q", qString);
		formula = formula.replace("P", pString);

		return formula;
	}

}
