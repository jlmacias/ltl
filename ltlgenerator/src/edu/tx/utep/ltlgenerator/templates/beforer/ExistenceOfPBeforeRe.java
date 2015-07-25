package edu.tx.utep.ltlgenerator.templates.beforer;

import java.util.List;

import edu.tx.utep.ltlgenerator.templates.Template;

public class ExistenceOfPBeforeRe extends Template {
	
	private static String template = "(FR) -> ((!((Ri ^ X(Rh))) U (P &r !Rh)";

	@Override
	public String generateFormula(String pProposition, String qProposition, String rProposition, String lProposition) {
		String formula = template;
		List<String> r = getCompositeProposition(rProposition);
		List<String> p = getCompositeProposition(pProposition);
		List<String> rh = getHProposition(rProposition);
		String rinverse = String.join("", getParallelInverse(rProposition));
		String rString = String.join("", r);
		String rhString = String.join("", rh);

		List<String> notRh = rh;
		notRh.add(0, "!");

		String andedRh = operatorGenerator.getAndedPropositions(AND_R, p, notRh);
		formula = formula.replace("(P &r !Rh)", andedRh);

		formula = formula.replace("Rh", rhString);
		formula = formula.replace("Ri", rinverse);
		formula = formula.replace("R", rString);

		return formula;
	}

}
