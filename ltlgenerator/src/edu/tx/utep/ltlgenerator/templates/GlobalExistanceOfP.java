package edu.tx.utep.ltlgenerator.templates;

import java.util.List;

public class GlobalExistanceOfP extends Template {

	private static String template = "FP";

	@Override
	public String generateFormula(List<String> p, List<String> q, List<String> r, List<String> l) {
		String formula = template;
		return formula.replace("P", String.join("", p));
	}
}
