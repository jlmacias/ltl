package edu.tx.utep.ltlgenerator.templates;

import java.util.List;

public class GlobalQPrecedesPEStar extends Template {

	private static String template = "";

	@Override
	public String generateFormula(String pProposition, String qProposition, String rProposition, String lProposition) {
		String formula = template;
		List<String> q = getCompositeProposition(qProposition);
		List<String> ph = getHProposition(pProposition);
		String pinverse = String.join("", getParallelInverse(pProposition));

		return formula;
	}
}
