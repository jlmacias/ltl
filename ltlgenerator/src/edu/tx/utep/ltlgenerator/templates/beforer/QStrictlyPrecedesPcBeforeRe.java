package edu.tx.utep.ltlgenerator.templates.beforer;

import java.util.List;

import edu.tx.utep.ltlgenerator.OutputCharacters;
import edu.tx.utep.ltlgenerator.templates.Template;

public class QStrictlyPrecedesPcBeforeRe extends Template {

	// P &r !Rh
	private static String pAndNotRh = "P &r " + OutputCharacters.NOT + "Rh";

	// Q &r !P
	private static String qAndNotP = "Q &r " + OutputCharacters.NOT + "P";

	// (FR) -> (((!(P &r !Rh)) U ((Q &r !P) v (Ri ^ XRh))))
	private static String template = OutputCharacters.OPEN_P + OutputCharacters.EVENTUALLY + "R" + OutputCharacters.CLOSE_P + OutputCharacters.IMPLY +
			OutputCharacters.OPEN_P + OutputCharacters.OPEN_P + OutputCharacters.OPEN_P + OutputCharacters.NOT + OutputCharacters.OPEN_P + pAndNotRh + OutputCharacters.CLOSE_P + 
			OutputCharacters.CLOSE_P + OutputCharacters.UNTIL + OutputCharacters.OPEN_P + OutputCharacters.OPEN_P + qAndNotP + OutputCharacters.CLOSE_P +
		    OutputCharacters.OR + OutputCharacters.OPEN_P + "Ri" + OutputCharacters.AND + OutputCharacters.NEXT + "Rh" + OutputCharacters.CLOSE_P + 
		    OutputCharacters.CLOSE_P + OutputCharacters.CLOSE_P + OutputCharacters.CLOSE_P;

    @Override
    public String generateFormula(String pProposition, String qProposition, String rProposition, String lProposition) {
        String formula = template;

        List<String> p = getCompositeProposition(pProposition);
        List<String> rH = getHProposition(rProposition);
        List<String> r = getCompositeProposition(rProposition);
        List<String> q = getCompositeProposition(qProposition);
        String rInverse = String.join("", getParallelInverse(rProposition));
        String rString = String.join("", r);
        String rHString = String.join("", rH);

        List<String> notRh = rH;
        notRh.add(0, OutputCharacters.NOT);
        String andedP = operatorGenerator.getAndedPropositions(AND_R, p, notRh);
        formula = formula.replace(pAndNotRh, andedP);

        List<String> notP = p;
        notP.add(0, OutputCharacters.NOT);
        String andedQ = operatorGenerator.getAndedPropositions(AND_R, q, notP);
        formula = formula.replace(qAndNotP, andedQ);

        formula = formula.replace("Ri", rInverse);
        formula = formula.replace("Rh", rHString);
        formula = formula.replace("R", rString);

        return formula;
    }
}
