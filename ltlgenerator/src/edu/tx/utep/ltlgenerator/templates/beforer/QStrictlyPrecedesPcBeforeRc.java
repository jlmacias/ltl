package edu.tx.utep.ltlgenerator.templates.beforer;

import java.util.List;

import edu.tx.utep.ltlgenerator.OutputCharacters;
import edu.tx.utep.ltlgenerator.templates.Template;

public class QStrictlyPrecedesPcBeforeRc extends Template {

	// P &r !R
	private static String pAndNotR = "P &r " + OutputCharacters.NOT + "R";

	// Q &r !P
	private static String qAndNotP = "Q &r " + OutputCharacters.NOT + "P";

	// (FR) -> ((!(P &r !R)) U ((Q &r !P) v R))
	private static String template = OutputCharacters.OPEN_P + OutputCharacters.EVENTUALLY + "R" + OutputCharacters.CLOSE_P + " -> " +
			OutputCharacters.OPEN_P + OutputCharacters.OPEN_P + OutputCharacters.NOT + OutputCharacters.OPEN_P + pAndNotR + OutputCharacters.CLOSE_P + 
			OutputCharacters.CLOSE_P + OutputCharacters.UNTIL + OutputCharacters.OPEN_P + OutputCharacters.OPEN_P + qAndNotP + OutputCharacters.CLOSE_P +
		    OutputCharacters.OR + "R" + OutputCharacters.CLOSE_P + OutputCharacters.CLOSE_P;

    @Override
    public String generateFormula(String pProposition, String qProposition, String rProposition, String lProposition) {
        String formula = template;
        List<String> r = getCompositeProposition(rProposition);
        List<String> p = getCompositeProposition(pProposition);
        List<String> q = getCompositeProposition(qProposition);
        String rString = String.join("", r);

        List<String> notR = r;
        notR.add(0, OutputCharacters.NOT);
        String andedP = operatorGenerator.getAndedPropositions(AND_R, p, notR);
        formula = formula.replace(pAndNotR, andedP);

        List<String> notP = p;
        notP.add(0, OutputCharacters.NOT);
        String andedQ = operatorGenerator.getAndedPropositions(AND_R, q, notP);
        formula = formula.replace(qAndNotP, andedQ);

        formula = formula.replace("R", rString);

        return formula;
    }
}
