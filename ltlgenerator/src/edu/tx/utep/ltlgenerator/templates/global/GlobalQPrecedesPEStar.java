package edu.tx.utep.ltlgenerator.templates.global;

import java.util.LinkedList;
import java.util.List;

import edu.tx.utep.ltlgenerator.templates.Template;

public class GlobalQPrecedesPEStar extends Template {

	private static String template = "!((!(Q &-l !(pInverse ^ X PH))) U (pInverse ^ X PH))";

	@Override
	public String generateFormula(String pProposition, String qProposition, String rProposition, String lProposition) {
		String formula = template;
		List<String> q = getCompositeProposition(qProposition);
		List<String> pH = getHProposition(pProposition);
		String pInverse = String.join("", getParallelInverse(pProposition));

		// pInverse ^ X PH
		List<String> combinedInverse = new LinkedList<>();
		combinedInverse.add("!");
		combinedInverse.add("(");
		combinedInverse.add(pInverse);
		combinedInverse.add(" ^ X");
		combinedInverse.add(String.join("", pH));
		combinedInverse.add(")");

		// pInverse ^ X PH
		List<String> combined = new LinkedList<>();
		combined.add("(");
		combined.add(pInverse);
		combined.add(" ^ X");
		combined.add(String.join("", pH));
		combined.add(")");

		// Q &-l !(combined)
		formula = formula.replace("Q &-l !(pInverse ^ X PH)", operatorGenerator.getAndedPropositions(AND_MINUS_L, q, combinedInverse));
		formula = formula.replace("pInverse ^ X PH", String.join("", combined));

		return formula;
	}
}