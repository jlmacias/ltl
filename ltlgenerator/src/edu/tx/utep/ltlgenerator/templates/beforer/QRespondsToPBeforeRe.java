package edu.tx.utep.ltlgenerator.templates.beforer;

import java.util.List;

import edu.tx.utep.ltlgenerator.templates.Template;

public class QRespondsToPBeforeRe extends Template {

	private static String template = "!((!((Ri) ^ X(Rh))) U ((P andR !Rh) andL templatePart2))";
	private static String templatePart2 = "((!(Q andR !Rh)) U Rh )";

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
		notRh.add(0, "!");
		
		qAndRNotRh = operatorGenerator.getAndedPropositions(AND_R, q, notRh);
		rightSideTemplatePart2 = rightSideTemplatePart2.replace("Q andR !Rh", qAndRNotRh);
		rightSideTemplatePart2 = rightSideTemplatePart2.replace("Rh", rh);
		
		pAndRNotRh = operatorGenerator.getAndedPropositions(AND_R, p, notRh);
		qAndRNotRh_AND_L_rightSideTemplatePart2 = andLForBeforeR.getAndLForBeforeR(pAndRNotRh, rightSideTemplatePart2);
		formula = formula.replace("(P andR !Rh) andL templatePart2", qAndRNotRh_AND_L_rightSideTemplatePart2);
		
		formula = formula.replace("Rh", rh);
		formula = formula.replace("Ri", ri);

		return formula;
	}

}
