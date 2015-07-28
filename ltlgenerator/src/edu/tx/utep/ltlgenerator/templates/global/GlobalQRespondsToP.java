package edu.tx.utep.ltlgenerator.templates.global;

import java.util.ArrayList;
import java.util.List;

import edu.tx.utep.ltlgenerator.OutputCharacters;
import edu.tx.utep.ltlgenerator.templates.Template;

public class GlobalQRespondsToP extends Template {

	// P &l FQ
	private static String pAndFQ =  "P &l " + OutputCharacters.EVENTUALLY + "Q";

	// G(P -> (P &l FQ)))
	private static String template = OutputCharacters.ALWAYS + OutputCharacters.OPEN_P + "P" + OutputCharacters.IMPLY + OutputCharacters.OPEN_P + pAndFQ + OutputCharacters.CLOSE_P + 
			OutputCharacters.CLOSE_P + OutputCharacters.CLOSE_P;

	@Override
	public String generateFormula(String pProposition, String qProposition, String rProposition, String lProposition) {
		String formula = template;
		List<String> p = getCompositeProposition(pProposition);
		List<String> q = getCompositeProposition(qProposition);
		String pString = String.join("", p);

		List<String> rightSideQ = new ArrayList<String>();
		rightSideQ.add(OutputCharacters.EVENTUALLY);
		rightSideQ.add(OutputCharacters.OPEN_P);
		rightSideQ.addAll(q);
		rightSideQ.add(OutputCharacters.CLOSE_P);

		String andedPQ = operatorGenerator.getAndedPropositions(AND_L, p, rightSideQ);
		formula = formula.replace(pAndFQ, andedPQ);
		formula = formula.replace("P", pString);

		return formula;
	}

}
