package edu.tx.utep.ltlgenerator.templates;

import java.util.ArrayList;
import java.util.List;

public class GlobalQRespondsToP extends Template {

	private static String template = "G(P -> (P &l FQ)))";

	@Override
	public String generateFormula(String pProposition, String qProposition, String rProposition, String lProposition) {
		String formula = template;
		List<String> p = getCompositeProposition(pProposition);
		List<String> q = getCompositeProposition(qProposition);
		String pString = String.join("", p);

		List<String> rightSideQ = new ArrayList<String>();
		rightSideQ.add("F(");
		rightSideQ.addAll(q);
		rightSideQ.add(")");

		String andedPQ = operatorGenerator.getAndedPropositions(AND_L, p, rightSideQ);
		formula = formula.replace("P &l FQ", andedPQ);
		formula = formula.replace("P", pString);

		return formula;
	}

}
