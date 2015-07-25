package edu.tx.utep.ltlgenerator.templates;

import java.util.List;

public class GlobalExistanceOfP extends Template {

	private static String template = "FP";

	@Override
	public String generateFormula(String pProposition, String qProposition, String rProposition, String lProposition) {
		String formula = template;
		List<String> p = getCompositeProposition(pProposition);
		return formula.replace("P", String.join("", p));
	}
}
