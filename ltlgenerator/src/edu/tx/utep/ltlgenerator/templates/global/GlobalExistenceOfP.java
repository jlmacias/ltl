package edu.tx.utep.ltlgenerator.templates.global;

import java.util.List;

import edu.tx.utep.ltlgenerator.templates.Template;

public class GlobalExistenceOfP extends Template {

	private static String template = "FP";

	@Override
	public String generateFormula(String pProposition, String qProposition, String rProposition, String lProposition) {
		String formula = template;
		List<String> p = getCompositeProposition(pProposition);
		return formula.replace("P", String.join("", p));
	}
}
