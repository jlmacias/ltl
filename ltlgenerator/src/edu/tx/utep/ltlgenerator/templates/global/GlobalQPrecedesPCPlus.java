package edu.tx.utep.ltlgenerator.templates.global;

import java.util.List;

import edu.tx.utep.ltlgenerator.OutputCharacters;
import edu.tx.utep.ltlgenerator.templates.Template;

public class GlobalQPrecedesPCPlus extends Template {

	// Q &-l !P
	private static String qAndNotP = "Q &-l " + OutputCharacters.NOT + "P";
	
	// !((!(Q &-l !P)) U P)
	private static String template = OutputCharacters.NOT + OutputCharacters.OPEN_P + OutputCharacters.OPEN_P + OutputCharacters.NOT + OutputCharacters.OPEN_P + 
			qAndNotP + OutputCharacters.CLOSE_P + OutputCharacters.CLOSE_P + OutputCharacters.UNTIL + "P" + OutputCharacters.CLOSE_P;

	@Override
	public String generateFormula(String pProposition, String qProposition, String rProposition, String lProposition) {
		String formula = template;
		List<String> p = getCompositeProposition(pProposition);
		List<String> q = getCompositeProposition(qProposition);

		String jointP = String.join("", p);
		List<String> notP = p;
		notP.add(0, OutputCharacters.NOT);

		String qAndMinusLNotP = operatorGenerator.getAndedPropositions(AND_MINUS_L, q, notP);

		formula = formula.replace(qAndNotP, qAndMinusLNotP);
		formula = formula.replace("P", jointP);

		return formula;
	}

}
