package edu.tx.utep.ltlgenerator.templates.global;

import java.util.LinkedList;
import java.util.List;

import edu.tx.utep.ltlgenerator.templates.Template;

public class GlobalQPrecedesPEStar extends Template {

	private static String template = "!((!(Q ^ !(pInverse ^ XPH))) U (pInverse ^ XPH ^ !Q))";

	@Override
	public String generateFormula(String pProposition, String qProposition, String rProposition, String lProposition) {
		String formula = template;
		List<String> q = getCompositeProposition(qProposition);
		List<String> pH = getHProposition(pProposition);
		String pHString = String.join("", pH);
		String qString = String.join("", q);
		String pInverse = String.join("", getParallelInverse(pProposition));

		formula = formula.replace("pInverse", pInverse);
		formula = formula.replace("PH", pHString);
		formula = formula.replace("Q", qString);

		return formula;
	}
}