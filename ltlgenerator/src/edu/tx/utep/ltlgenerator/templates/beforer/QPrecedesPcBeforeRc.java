package edu.tx.utep.ltlgenerator.templates.beforer;

import java.util.List;

import edu.tx.utep.ltlgenerator.templates.Template;

public class QPrecedesPcBeforeRc extends Template {

	private static String template = "(FR) -> ((!(P &r !R))) U ((Q &-l !P) v R)))";

	@Override
	public String generateFormula(String pProposition, String qProposition, String rProposition, String lProposition) {
		String formula = template;
		List<String> r = getCompositeProposition(rProposition);
		List<String> p = getCompositeProposition(pProposition);
		List<String> q = getCompositeProposition(qProposition);
		String rString = String.join("", r);
		String pString = String.join("", p);

		List<String> notR = r;
		notR.add(0, "!");
		String andedR = operatorGenerator.getAndedPropositions(AND_R, p, notR);
		formula = formula.replace("(P &r !R)", andedR);

		List<String> notP = p;
		notP.add(0, "!");
		String andedP = operatorGenerator.getAndedPropositions(AND_MINUS_L, q, notP);
		formula = formula.replace("(Q &-l !P)", andedP);

		formula = formula.replace("R", rString);
		formula = formula.replace("P", pString);

		return formula;
	}

}
