package edu.tx.utep.ltlgenerator.templates.beforer;

import java.util.List;

import edu.tx.utep.ltlgenerator.OutputCharacters;
import edu.tx.utep.ltlgenerator.templates.Template;

public class QRespondsToPBeforeRe extends Template {

	// Q &r !Rh
	private static String qAndNotRh = "Q &r " + OutputCharacters.NOT + "Rh";

	// ((!(Q &r !Rh)) U Rh)
	private static String templatePart2 = OutputCharacters.OPEN_P + OutputCharacters.OPEN_P + OutputCharacters.NOT + OutputCharacters.OPEN_P + qAndNotRh +
			OutputCharacters.CLOSE_P + OutputCharacters.CLOSE_P + OutputCharacters.UNTIL + "Rh" + OutputCharacters.CLOSE_P;

	// (P &r !Rh) &l templatePart2
	private static String pAndNotRhAndStuff = OutputCharacters.OPEN_P + "P &r " + OutputCharacters.NOT + OutputCharacters.CLOSE_P + " &l templatePart2";

	// !((!((Ri) ^ X(Rh))) U ((P &r !Rh) &l templatePart2))
	private static String template = OutputCharacters.NOT + OutputCharacters.OPEN_P + OutputCharacters.OPEN_P + OutputCharacters.NOT + OutputCharacters.OPEN_P + OutputCharacters.OPEN_P + 
			"Ri" + OutputCharacters.CLOSE_P + OutputCharacters.AND + OutputCharacters.NEXT + OutputCharacters.OPEN_P + "Rh" + OutputCharacters.CLOSE_P + OutputCharacters.CLOSE_P + OutputCharacters.CLOSE_P +
			OutputCharacters.UNTIL + OutputCharacters.OPEN_P + pAndNotRhAndStuff + OutputCharacters.CLOSE_P + OutputCharacters.CLOSE_P;

	@Override
	public String generateFormula(String pProposition, String qProposition, String rProposition, String lProposition) {
		String formula = template;
		String rightSideTemplatePart2 = templatePart2;
		String ri = String.join("", getCompositeProposition(rProposition));
		String rh = String.join("", getHProposition(rProposition));
		List<String> notRh = getHProposition(rProposition);
		List<String> p = getCompositeProposition(pProposition);
		List<String> q = getCompositeProposition(qProposition);
		String qAndRNotRh;
		String pAndRNotRh;
		String qAndRNotRh_AND_L_rightSideTemplatePart2;
		notRh.add(0, OutputCharacters.NOT);
		
		qAndRNotRh = operatorGenerator.getAndedPropositions(AND_R, q, notRh);
		rightSideTemplatePart2 = rightSideTemplatePart2.replace(qAndNotRh, qAndRNotRh);
		rightSideTemplatePart2 = rightSideTemplatePart2.replace("Rh", rh);
		
		pAndRNotRh = operatorGenerator.getAndedPropositions(AND_R, p, notRh);
		qAndRNotRh_AND_L_rightSideTemplatePart2 = andLForBeforeR.getAndLForBeforeR(pAndRNotRh, rightSideTemplatePart2);
		formula = formula.replace(pAndNotRhAndStuff, qAndRNotRh_AND_L_rightSideTemplatePart2);
		
		formula = formula.replace("Rh", rh);
		formula = formula.replace("Ri", ri);

		return formula;
	}

}
