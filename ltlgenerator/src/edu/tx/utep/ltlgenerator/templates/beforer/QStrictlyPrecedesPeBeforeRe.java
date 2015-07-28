package edu.tx.utep.ltlgenerator.templates.beforer;

import java.util.List;

import edu.tx.utep.ltlgenerator.OutputCharacters;
import edu.tx.utep.ltlgenerator.templates.Template;

public class QStrictlyPrecedesPeBeforeRe extends Template {

	// Ph &r !Rh
	private static String phAndNotRh = "Ph &r " + OutputCharacters.NOT + "Rh";

	// Q &r !Ph
	private static String qAndNotPh = "Q &r " + OutputCharacters.NOT + "Ph";

	// (FR) -> ((!(Pi ^ !Rh ^ X(Ph &r !Rh))) U ((Q &r !Ph) v (Ri ^ XRh)))
	private static String template = OutputCharacters.OPEN_P + OutputCharacters.EVENTUALLY + "R" + OutputCharacters.CLOSE_P + OutputCharacters.IMPLY +
			OutputCharacters.OPEN_P + OutputCharacters.OPEN_P + OutputCharacters.NOT + OutputCharacters.OPEN_P + "Pi" + OutputCharacters.AND + OutputCharacters.NOT + "Rh" +
			OutputCharacters.AND + OutputCharacters.NEXT + OutputCharacters.OPEN_P + phAndNotRh + OutputCharacters.CLOSE_P + OutputCharacters.CLOSE_P + OutputCharacters.CLOSE_P + 
			OutputCharacters.UNTIL + OutputCharacters.OPEN_P + OutputCharacters.OPEN_P + qAndNotPh + OutputCharacters.CLOSE_P + OutputCharacters.OR + OutputCharacters.OPEN_P + "Ri" + 
			OutputCharacters.AND + OutputCharacters.NEXT + "Rh" + OutputCharacters.CLOSE_P + OutputCharacters.CLOSE_P + OutputCharacters.CLOSE_P;

    @Override
    public String generateFormula(String pProposition, String qProposition, String rProposition, String lProposition) {
        String formula = template;

        List<String> r = getCompositeProposition(rProposition);
        List<String> q = getCompositeProposition(qProposition);
        List<String> rH = getHProposition(rProposition);
        List<String> pH = getHProposition(pProposition);
        String pInverse = String.join("", getParallelInverse(pProposition));
        String rInverse = String.join("", getParallelInverse(rProposition));
        String rHString = String.join("", rH);
        String rString = String.join("", r);

        List<String> notRH = rH;
        notRH.add(0, OutputCharacters.NOT);
        String andedPH = operatorGenerator.getAndedPropositions(AND_R, pH, notRH);
        formula = formula.replace(phAndNotRh, andedPH);

        List<String> notPH = pH;
        notPH.add(0, OutputCharacters.NOT);
        String andedQ = operatorGenerator.getAndedPropositions(AND_R, q, notPH);
        formula = formula.replace(qAndNotPh, andedQ);

        formula = formula.replace("Pi", pInverse);
        formula = formula.replace("Ri", rInverse);
        formula = formula.replace("Rh", rHString);
        formula = formula.replace("R", rString);

        return formula;
    }
}
