package edu.tx.utep.ltlgenerator.templates.beforer;

import java.util.List;

import edu.tx.utep.ltlgenerator.templates.Template;

public class ExistenceOfPBeforeRc extends Template {

	private static String template = "!((!(P &r !R)) U R)";

	@Override
	public String generateFormula(String pProposition, String qProposition, String rProposition, String lProposition) {
		String formula = template;
		List<String> r = getCompositeProposition(rProposition);
		List<String> p = getCompositeProposition(pProposition);
		String rString = String.join("", r);
		
		List<String> notR = r;
		notR.add(0, "!");

		String andedR = operatorGenerator.getAndedPropositions(AND_R, p, notR);
		formula = formula.replace("(P &r !R)", andedR);

		formula = formula.replace("R", rString);

		return formula;
	}

}
