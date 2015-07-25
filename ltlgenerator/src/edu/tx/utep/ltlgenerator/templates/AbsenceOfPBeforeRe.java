package edu.tx.utep.ltlgenerator.templates;

import java.util.List;


public class AbsenceOfPBeforeRe extends Template {

	private static String template = "(FR) -> !((!((Pi) ^ X(Rh))) U (P &r !Rh))";

	@Override
	public String generateFormula(String pProposition, String qProposition, String rProposition, String lProposition) {
		String formula = template;
		List<String> r = getCompositeProposition(rProposition);
		List<String> rh = getHProposition(rProposition);
		List<String> p = getHProposition(pProposition);
		String pinverse = String.join("", getParallelInverse(pProposition));
		String rString = String.join("", r);
		String rhString = String.join("", rh);
		
		List<String> notRh = rh;
		notRh.add(0, "!");

		String andedR = operatorGenerator.getAndedPropositions(AND_R, p, notRh);
		formula = formula.replace("(P &r !Rh)", andedR);

		formula = formula.replace("Rh", String.join("", rhString));
		formula = formula.replace("Pi", pinverse);
		formula = formula.replace("R", rString);

		return formula;
	}

}
