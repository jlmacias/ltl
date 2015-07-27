package edu.tx.utep.ltlgenerator.templates.beforer;

import java.util.List;

import edu.tx.utep.ltlgenerator.templates.Template;

public class QPrecedesPeBeforeRc extends Template {

	private static String template = "(F R) -> ((!((Pi) ^ !R ^ X(Ph andR !R))) U ((Q andMinusL !(Ph)) v R))";

	@Override
	public String generateFormula(String pProposition, String qProposition, String rProposition, String lProposition) {
		String formula = template;
		String pParallelInverse = String.join("", getParallelInverse(pProposition));
		List<String> r = getCompositeProposition(rProposition);
		List<String> ph = getHProposition(pProposition);
		List<String> q = getCompositeProposition(qProposition);
		List<String> notR = getCompositeProposition(rProposition);
		notR.add(0, "!");
		List<String> notPh = getHProposition(pProposition);
		notPh.add(0, "!");
		
		String phAndRNotR = operatorGenerator.getAndedPropositions(AND_R, ph, notR);
		String qAndMinusLNotPh = operatorGenerator.getAndedPropositions(AND_MINUS_L, q, notPh);
		
		formula = formula.replace("Ph andR !R", phAndRNotR);
		formula = formula.replace("Q andMinusL !(Ph)", qAndMinusLNotPh);
		formula = formula.replace("Pi", pParallelInverse);
		formula = formula.replace("!R", String.join("", notR));
		formula = formula.replace("R", String.join("", r));

		return formula;
	}

}
