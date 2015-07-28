package edu.tx.utep.ltlgenerator.templates.beforer;

import java.util.List;

import edu.tx.utep.ltlgenerator.OutputCharacters;
import edu.tx.utep.ltlgenerator.templates.Template;


public class AbsenceOfPBeforeRe extends Template {

	// P &r !Rh
	private static String pAndNotRh = "P &r " + OutputCharacters.NOT + "Rh";

	// (FR) -> !((!((Pi) ^ X(Rh))) U (P &r !Rh))
	private static String template = OutputCharacters.OPEN_P + OutputCharacters.EVENTUALLY + "R" + OutputCharacters.CLOSE_P + OutputCharacters.IMPLY +
			OutputCharacters.NOT + OutputCharacters.OPEN_P + OutputCharacters.OPEN_P + OutputCharacters.NOT + OutputCharacters.OPEN_P + OutputCharacters.OPEN_P + 
			"Pi" + OutputCharacters.CLOSE_P + OutputCharacters.AND + OutputCharacters.NEXT + OutputCharacters.OPEN_P + "Rh" + OutputCharacters.CLOSE_P + 
			OutputCharacters.CLOSE_P + OutputCharacters.CLOSE_P + OutputCharacters.UNTIL + OutputCharacters.OPEN_P + pAndNotRh + OutputCharacters.CLOSE_P + OutputCharacters.CLOSE_P;

	@Override
	public String generateFormula(String pProposition, String qProposition, String rProposition, String lProposition) {
		String formula = template;
		List<String> r = getCompositeProposition(rProposition);
		List<String> p = getCompositeProposition(pProposition);
		List<String> rh = getHProposition(rProposition);
		String pinverse = String.join("", getParallelInverse(pProposition));
		String rString = String.join("", r);
		String rhString = String.join("", rh);

		List<String> notRh = rh;
		notRh.add(0, OutputCharacters.NOT);

		String andedR = operatorGenerator.getAndedPropositions(AND_R, p, notRh);
		formula = formula.replace(pAndNotRh, andedR);

		formula = formula.replace("Rh", String.join("", rhString));
		formula = formula.replace("Pi", pinverse);
		formula = formula.replace("R", rString);

		return formula;
	}

}
