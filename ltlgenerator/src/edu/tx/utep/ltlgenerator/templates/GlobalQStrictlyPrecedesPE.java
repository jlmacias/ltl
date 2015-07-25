package edu.tx.utep.ltlgenerator.templates;

import java.util.ArrayList;
import java.util.List;

public class GlobalQStrictlyPrecedesPE extends Template {

	// "!((!(Q &R !(!p1 ^......^!pn ^ X PH))) U (!p1 ^ ...^ !pn ^ X PH))"
	private static String template = "!((!(Q &R !(PARALLEINVERSE ^ X PH))) U (PARALLELINVERSE ^ X PH))";

	@Override
	public String generateFormula(String pProposition, String qProposition, String rProposition, String lProposition) {
		List<String> q = getCompositeProposition(qProposition);
		List<String> ph = getHProposition(pProposition);
		List<String> pinverse = getParallelInverse(pProposition);

		String formula = template;
		List<String> parallelInverse_X_PH = new ArrayList<String>();
		parallelInverse_X_PH.addAll(pinverse);
		parallelInverse_X_PH.add(" ^ X");
		parallelInverse_X_PH.addAll(ph);

		List<String> NotParallelInverse_X_PH = new ArrayList<String>();
		NotParallelInverse_X_PH.add(0, "!(");
		NotParallelInverse_X_PH.addAll(parallelInverse_X_PH);
		NotParallelInverse_X_PH.add(")");

		String andedQP = operatorGenerator.getAndedPropositions(AND_R, q, NotParallelInverse_X_PH);
		formula = formula.replace("Q &R !(PARALLEINVERSE ^ X PH)", andedQP);
		String pInverse_X_PH = String.join("", parallelInverse_X_PH);
		formula = formula.replace("PARALLELINVERSE ^ X PH", pInverse_X_PH);

		return formula;
	}

}
