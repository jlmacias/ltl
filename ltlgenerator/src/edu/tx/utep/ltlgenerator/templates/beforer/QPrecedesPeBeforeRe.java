package edu.tx.utep.ltlgenerator.templates.beforer;

import java.util.List;

import edu.tx.utep.ltlgenerator.OutputCharacters;
import edu.tx.utep.ltlgenerator.templates.Template;

public class QPrecedesPeBeforeRe extends Template {

	// Ph &r !Rh
	private static String phAndNotRh = "Ph &r " + OutputCharacters.NOT + "Rh";

	// Q &-l !Ph
	private static String qAndNotPh = "Q &-l " + OutputCharacters.NOT + "Ph";

	// (FR) -> ((!((Pi) ^ !Rh ^ X(Ph &r !Rh))) U ((Q &-l !Ph) v ((Ri) ^ XRh)))
	private static String template = OutputCharacters.OPEN_P + OutputCharacters.EVENTUALLY + "R" + OutputCharacters.CLOSE_P + " -> " +
			OutputCharacters.OPEN_P + OutputCharacters.OPEN_P + OutputCharacters.NOT + OutputCharacters.OPEN_P + OutputCharacters.OPEN_P + "Pi" + OutputCharacters.CLOSE_P +
			OutputCharacters.AND + OutputCharacters.NOT + "Rh" + OutputCharacters.AND + OutputCharacters.NEXT + OutputCharacters.OPEN_P + phAndNotRh + OutputCharacters.CLOSE_P + 
			OutputCharacters.CLOSE_P + OutputCharacters.CLOSE_P + OutputCharacters.UNTIL + OutputCharacters.OPEN_P + OutputCharacters.OPEN_P + qAndNotPh + OutputCharacters.CLOSE_P +
		    OutputCharacters.OR + OutputCharacters.OPEN_P + OutputCharacters.OPEN_P + "Ri" + OutputCharacters.CLOSE_P + OutputCharacters.AND + OutputCharacters.NEXT + "Rh" +
		    OutputCharacters.CLOSE_P + OutputCharacters.CLOSE_P + OutputCharacters.CLOSE_P;

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
		notRh.add(0, OutputCharacters.NOT);
		List<String> notPh = getHProposition(pProposition);
		notPh.add(0, OutputCharacters.NOT);
		
		String phAndRNotRh = operatorGenerator.getAndedPropositions(AND_R, ph, notRh);
		String qAndMinusLNotPh = operatorGenerator.getAndedPropositions(AND_MINUS_L, q, notPh);
		
		formula = formula.replace(phAndNotRh, phAndRNotRh);
		formula = formula.replace(qAndNotPh, qAndMinusLNotPh);
		formula = formula.replace("Pi", pi);
		formula = formula.replace(OutputCharacters.NOT + "Rh", String.join("", notRh));
		formula = formula.replace("Ri", ri);
		formula = formula.replace("Rh", rh);
		formula = formula.replace("R", r);
		
		return formula;
	}

}
