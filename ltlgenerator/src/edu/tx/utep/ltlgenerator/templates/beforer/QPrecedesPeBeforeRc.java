package edu.tx.utep.ltlgenerator.templates.beforer;

import java.util.List;

import edu.tx.utep.ltlgenerator.OutputCharacters;
import edu.tx.utep.ltlgenerator.templates.Template;

public class QPrecedesPeBeforeRc extends Template {

	// Ph &r !R
	private static String phAndNotR = "Ph &r " + OutputCharacters.NOT + "R";

	// Q &-l !(Ph)
	private static String qAndNotPh = "Q &-l " + OutputCharacters.NOT + OutputCharacters.OPEN_P + "P" + OutputCharacters.CLOSE_P;

	// (FR) -> ((!((Pi) ^ !R ^ X(Ph &r !R))) U ((Q &-l !(Ph)) v R))
	private static String template = OutputCharacters.OPEN_P + OutputCharacters.EVENTUALLY + "R" + OutputCharacters.CLOSE_P + " -> " +
			OutputCharacters.OPEN_P + OutputCharacters.OPEN_P + OutputCharacters.NOT + OutputCharacters.OPEN_P + OutputCharacters.OPEN_P + "Pi" + OutputCharacters.CLOSE_P +
			OutputCharacters.AND + OutputCharacters.NOT + "R" + OutputCharacters.AND + OutputCharacters.NEXT + OutputCharacters.OPEN_P + phAndNotR + OutputCharacters.CLOSE_P + 
			OutputCharacters.CLOSE_P + OutputCharacters.CLOSE_P + OutputCharacters.UNTIL + OutputCharacters.OPEN_P + OutputCharacters.OPEN_P + qAndNotPh + OutputCharacters.CLOSE_P +
		    OutputCharacters.OR + "R" + OutputCharacters.CLOSE_P + OutputCharacters.CLOSE_P;

	@Override
	public String generateFormula(String pProposition, String qProposition, String rProposition, String lProposition) {
		String formula = template;
		String pParallelInverse = String.join("", getParallelInverse(pProposition));
		List<String> r = getCompositeProposition(rProposition);
		List<String> ph = getHProposition(pProposition);
		List<String> q = getCompositeProposition(qProposition);
		List<String> notR = getCompositeProposition(rProposition);
		notR.add(0, OutputCharacters.NOT);
		List<String> notPh = getHProposition(pProposition);
		notPh.add(0, OutputCharacters.NOT);
		
		String phAndRNotR = operatorGenerator.getAndedPropositions(AND_R, ph, notR);
		String qAndMinusLNotPh = operatorGenerator.getAndedPropositions(AND_MINUS_L, q, notPh);
		
		formula = formula.replace(phAndNotR, phAndRNotR);
		formula = formula.replace(qAndNotPh, qAndMinusLNotPh);
		formula = formula.replace("Pi", pParallelInverse);
		formula = formula.replace(OutputCharacters.NOT + "R", String.join("", notR));
		formula = formula.replace("R", String.join("", r));

		return formula;
	}

}
