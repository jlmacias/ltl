package edu.tx.utep.ltlgenerator.templates.beforer;

import java.util.List;

import edu.tx.utep.ltlgenerator.templates.Template;

public class QPrecedesPeBeforeRe extends Template {

	private static String template = "(F R) -> ((!((Pi) ^ !Rh ^ X(Ph andR !Rh))) U ((Q andMinusL !Ph) v ((Ri) ^ X Rh )))";

	@Override
	public String generateFormula(String pProposition, String qProposition, String rProposition, String lProposition) {
		String formula = template;
		String r = String.join("", getCompositeProposition(rProposition));
		List<String> ph = getHProposition(pProposition);
		String pi = String.join("", getParallelInverse(pProposition));
		String ri = String.join("", getParallelInverse(rProposition));
		List<String> q = getCompositeProposition(qProposition);
		String rh = String.join("", getHProposition(rProposition));
		List<String> notRh = getHProposition(rProposition);
		notRh.add(0, "!");
		List<String> notPh = getHProposition(pProposition);
		notPh.add(0, "!");
		
		String phAndRNotRh = operatorGenerator.getAndedPropositions(AND_R, ph, notRh);
		String qAndMinusLNotPh = operatorGenerator.getAndedPropositions(AND_MINUS_L, q, notPh);
		
		formula = formula.replace("Ph andR !Rh", phAndRNotRh);
		formula = formula.replace("Q andMinusL !Ph", qAndMinusLNotPh);
		formula = formula.replace("Pi", pi);
		formula = formula.replace("!Rh", String.join("", notRh));
		formula = formula.replace("Ri", ri);
		formula = formula.replace("Rh", rh);
		formula = formula.replace("R", r);
		
		return formula;
	}

}
