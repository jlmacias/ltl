package edu.tx.utep.ltlgenerator.templates.beforer;

import java.util.List;

import edu.tx.utep.ltlgenerator.OutputCharacters;
import edu.tx.utep.ltlgenerator.templates.Template;

public class QPrecedesPcBeforeRe extends Template {

	// P &r !Rh
	private static String pAndNotRh = "P &r " + OutputCharacters.NOT + "Rh";

	// Q &-l !P
	private static String qAndNotP = "Q &-l " + OutputCharacters.NOT + "P";

	// (FR) -> (((!(P &r !Rh)) U ((Q &-l !P) v ((Ri) ^ XRh))))
	private static String template = OutputCharacters.OPEN_P + OutputCharacters.EVENTUALLY + "R" + OutputCharacters.CLOSE_P + " -> " +
			OutputCharacters.OPEN_P + OutputCharacters.OPEN_P + OutputCharacters.OPEN_P + OutputCharacters.NOT + OutputCharacters.OPEN_P + pAndNotRh + 
			OutputCharacters.CLOSE_P + OutputCharacters.CLOSE_P + 
			OutputCharacters.UNTIL + OutputCharacters.OPEN_P + OutputCharacters.OPEN_P + qAndNotP + OutputCharacters.CLOSE_P + 
			OutputCharacters.OR + OutputCharacters.OPEN_P + OutputCharacters.OPEN_P + "Ri" + OutputCharacters.CLOSE_P +
		    OutputCharacters.AND + OutputCharacters.NEXT + "Rh" + OutputCharacters.CLOSE_P + OutputCharacters.CLOSE_P + OutputCharacters.CLOSE_P + OutputCharacters.CLOSE_P;

	@Override
	public String generateFormula(String pProposition, String qProposition, String rProposition, String lProposition) {
		String formula = template;
		List<String> r = getCompositeProposition(rProposition);
		List<String> p = getCompositeProposition(pProposition);
		List<String> q = getCompositeProposition(qProposition);
		List<String> rh = getHProposition(rProposition);
		String rinverse = String.join("", getParallelInverse(rProposition));
		String rString = String.join("", r);
		String pString = String.join("", p);
		String rhString = String.join("", rh);

		List<String> notRh = rh;
		notRh.add(0, OutputCharacters.NOT);
		String andedRh = operatorGenerator.getAndedPropositions(AND_R, p, notRh);
		formula = formula.replace(pAndNotRh, andedRh);

		List<String> notP = p;
		notP.add(0, OutputCharacters.NOT);
		String andedP = operatorGenerator.getAndedPropositions(AND_MINUS_L, q, notP);
		formula = formula.replace(qAndNotP, andedP);

		formula = formula.replace("Rh", rhString);
		formula = formula.replace("Ri", rinverse);
		formula = formula.replace("R", rString);
		formula = formula.replace("P", pString);

		return formula;
	}

}
