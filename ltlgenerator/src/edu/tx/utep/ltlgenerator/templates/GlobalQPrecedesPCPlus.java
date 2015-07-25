package edu.tx.utep.ltlgenerator.templates;

import java.util.List;

import edu.tx.utep.ltlgenerator.OperatorGenerator;
import edu.tx.utep.ltlgenerator.factories.OperatorFactory;

public class GlobalQPrecedesPCPlus extends Template {

	private static String template = "!((!(Q andMinusL !P)) U P)";
	private static final String AND_MINUSL = OperatorFactory.AND_MINUS_L;

	@Override
	public String generateFormula(String pProposition, String qProposition, String rProposition, String lProposition) {
		String formula = template;
		List<String> p = getCompositeProposition(pProposition);
		List<String> q = getCompositeProposition(qProposition);

		String jointP = String.join("", p);
		List<String> notP = p;
		notP.add(0, "!");

		OperatorGenerator operatorGenerator = new OperatorGenerator();
		String qAndMinusLNotP = operatorGenerator.getAndedPropositions(AND_MINUSL, q, notP);

		formula = formula.replace("Q andMinusL !P", qAndMinusLNotP);
		formula = formula.replace("P", jointP);

		return formula;
	}

}
