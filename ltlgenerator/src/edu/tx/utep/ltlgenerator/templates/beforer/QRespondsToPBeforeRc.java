package edu.tx.utep.ltlgenerator.templates.beforer;

import java.util.List;

import edu.tx.utep.ltlgenerator.templates.Template;

public class QRespondsToPBeforeRc extends Template {

	private static String template = "!((!R) U ((P andR !R) andL templatePart2))";
	private static String templatePart2 = "((!(Q andR !R)) U R)";

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
		notR.add(0, "!");
		
		qAndRNotR = operatorGenerator.getAndedPropositions(AND_R, q, notR);
		rightSideTemplatePart2 = rightSideTemplatePart2.replace("Q andR !R", qAndRNotR);
		rightSideTemplatePart2 = rightSideTemplatePart2.replace("R", r);
		
		pAndRNotR = operatorGenerator.getAndedPropositions(AND_R, p, notR);
		pAndRNotR_AND_L_RightSideTemplatePart2 = andLForBeforeR.getAndLForBeforeR(pAndRNotR, rightSideTemplatePart2);
		
		formula = formula.replace("(P andR !R) andL templatePart2", pAndRNotR_AND_L_RightSideTemplatePart2);
		formula = formula.replace("!R", String.join("", notR));
		
		return formula;
	}

}
