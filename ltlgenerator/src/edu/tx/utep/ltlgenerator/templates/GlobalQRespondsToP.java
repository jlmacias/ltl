package edu.tx.utep.ltlgenerator.templates;

import java.util.ArrayList;
import java.util.List;

public class GlobalQRespondsToP extends Template {

	private static String template = "G(P -> (P &l FQ)))";

	@Override
	public String generateFormula(List<String> p, List<String> q, List<String> r, List<String> l) {
		String formula = template;
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
