package edu.tx.utep.ltlgenerator.templates.global;

import edu.tx.utep.ltlgenerator.templates.Template;
import java.util.ArrayList;
import java.util.List;

public class GlobalQStrictlyPrecedesPE extends Template {

	private static String template = "!((!(Q &r !(pInverse ^ XPH))) U (pInverse ^ XPH))";

	@Override
	public String generateFormula(String pProposition, String qProposition, String rProposition, String lProposition) {
		String formula = template;
		List<String> q = getCompositeProposition(qProposition);
		List<String> pH = getHProposition(pProposition);
		String pInverse = String.join("", getParallelInverse(pProposition));

		List<String> rightSide = new ArrayList<String>();
		rightSide.add("!(pInverse ^ XPH)");
		formula = formula.replace("Q &r !(pInverse ^ XPH)", operatorGenerator.getAndedPropositions(AND_R, q, rightSide));

		formula = formula.replace("pInverse", pInverse);
		formula = formula.replace("PH", String.join("", pH));

		return formula;
	}

}
