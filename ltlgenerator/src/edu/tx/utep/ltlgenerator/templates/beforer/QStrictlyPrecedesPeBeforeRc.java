package edu.tx.utep.ltlgenerator.templates.beforer;

import java.util.List;

import edu.tx.utep.ltlgenerator.OutputCharacters;
import edu.tx.utep.ltlgenerator.templates.Template;

public class QStrictlyPrecedesPeBeforeRc extends Template {

	// Ph &r !R
	private static String phAndNotR = "Ph &r " + OutputCharacters.NOT + "R";

	// Q &r !Ph
	private static String qAndNotPh = "Q &r " + OutputCharacters.NOT + "Ph";

	// (FR) -> ((!(Pi ^ !R ^ X(PH &r !R))) U ((Q &r !PH) v R))
	private static String template = OutputCharacters.OPEN_P + OutputCharacters.EVENTUALLY + "R" + OutputCharacters.CLOSE_P + " -> " +
			OutputCharacters.OPEN_P + OutputCharacters.OPEN_P + OutputCharacters.NOT + OutputCharacters.OPEN_P + "Pi" + OutputCharacters.AND + OutputCharacters.NOT + "R" +
			OutputCharacters.AND + OutputCharacters.NEXT + OutputCharacters.OPEN_P + phAndNotR + OutputCharacters.CLOSE_P + OutputCharacters.CLOSE_P + OutputCharacters.CLOSE_P + 
			OutputCharacters.UNTIL + OutputCharacters.OPEN_P + OutputCharacters.OPEN_P + qAndNotPh + OutputCharacters.CLOSE_P + OutputCharacters.OR + "R" + 
			OutputCharacters.CLOSE_P + OutputCharacters.CLOSE_P;

    @Override
    public String generateFormula(String pProposition, String qProposition, String rProposition, String lProposition) {
        String formula = template;

        List<String> r = getCompositeProposition(rProposition);
        List<String> q = getCompositeProposition(qProposition);
        List<String> pH = getHProposition(pProposition);
        String pInverse = String.join("", getParallelInverse(pProposition));
        String rString = String.join("", r);

        List<String> notR = r;
        notR.add(0, OutputCharacters.NOT);
        String notRString = String.join("", notR);
        String andedPH = operatorGenerator.getAndedPropositions(AND_R, pH, notR);
        formula = formula.replace(phAndNotR, andedPH);

        List<String> notpH = pH;
        notpH.add(0, OutputCharacters.NOT);
        String andedQ = operatorGenerator.getAndedPropositions(AND_R, q, notpH);
        formula = formula.replace(qAndNotPh, andedQ);

        formula = formula.replace("Pi", pInverse);
        formula = formula.replace(OutputCharacters.NOT + "R", notRString);
        formula = formula.replace("R", rString);

        return formula;
    }
}
