package edu.tx.utep.ltlgenerator.templates;

import java.util.List;

public class GlobalAbsenceOfP extends Template {

	private static String template = "G!P";

	@Override
	public String generateFormula(List<String> p, List<String> q, List<String> r, List<String> l) {
		String formula = template;
		return formula.replace("P", String.join("", p));
	}
}
