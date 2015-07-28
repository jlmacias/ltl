package edu.tx.utep.ltlgenerator.templates.beforer;

import java.util.List;

import edu.tx.utep.ltlgenerator.OutputCharacters;
import edu.tx.utep.ltlgenerator.templates.Template;

public class QRespondsToPBeforeRc extends Template {

	// Q &r !R
	private static String qAndNotR = "Q &r " + OutputCharacters.NOT + "R";

	// ((!(Q &r !R)) U R)
	private static String templatePart2 = OutputCharacters.OPEN_P + OutputCharacters.OPEN_P + OutputCharacters.NOT + OutputCharacters.OPEN_P + qAndNotR +
			OutputCharacters.CLOSE_P + OutputCharacters.CLOSE_P + OutputCharacters.UNTIL + "R" + OutputCharacters.CLOSE_P;

	// (P &r !R) &l templatePart2
	private static String pAndNotRAndStuff = OutputCharacters.OPEN_P + "P &r " + OutputCharacters.NOT + OutputCharacters.CLOSE_P + " &l templatePart2";
			
	// !((!R) U ((P &r !R) &l templatePart2))
	private static String template = OutputCharacters.NOT + OutputCharacters.OPEN_P + OutputCharacters.OPEN_P + OutputCharacters.NOT + "R" + OutputCharacters.CLOSE_P +
			OutputCharacters.UNTIL + OutputCharacters.OPEN_P + pAndNotRAndStuff + OutputCharacters.CLOSE_P + OutputCharacters.CLOSE_P;

	@Override
	public String generateFormula(String pProposition, String qProposition, String rProposition, String lProposition) {
		String formula = template;
		String rightSideTemplatePart2 = templatePart2;
		List<String> notR = getCompositeProposition(rProposition);
		List<String> p = getCompositeProposition(pProposition);
		List<String> q = getCompositeProposition(qProposition);
		String r = String.join("", getCompositeProposition(rProposition));
		String qAndRNotR;
		String pAndRNotR;
		String pAndRNotR_AND_L_RightSideTemplatePart2;
		notR.add(0, OutputCharacters.NOT);
		
		qAndRNotR = operatorGenerator.getAndedPropositions(AND_R, q, notR);
		rightSideTemplatePart2 = rightSideTemplatePart2.replace(qAndNotR, qAndRNotR);
		rightSideTemplatePart2 = rightSideTemplatePart2.replace("R", r);
		
		pAndRNotR = operatorGenerator.getAndedPropositions(AND_R, p, notR);
		pAndRNotR_AND_L_RightSideTemplatePart2 = andLForBeforeR.getAndLForBeforeR(pAndRNotR, rightSideTemplatePart2);
		
		formula = formula.replace(pAndNotRAndStuff, pAndRNotR_AND_L_RightSideTemplatePart2);
		formula = formula.replace(OutputCharacters.NOT + "R", String.join("", notR));
		
		return formula;
	}

}
