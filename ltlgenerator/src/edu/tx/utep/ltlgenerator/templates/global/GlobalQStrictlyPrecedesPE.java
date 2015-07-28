package edu.tx.utep.ltlgenerator.templates.global;

import java.util.ArrayList;
import java.util.List;

import edu.tx.utep.ltlgenerator.OutputCharacters;
import edu.tx.utep.ltlgenerator.templates.Template;

public class GlobalQStrictlyPrecedesPE extends Template {

	// (pInverse ^ XPh)
    private static String pInverseOrXPh = OutputCharacters.OPEN_P + "pInverse" + OutputCharacters.AND + OutputCharacters.NEXT + "Ph" + OutputCharacters.CLOSE_P;

	// Q &r !(pInverse ^ XPh)
    private static String qAndNotSomething = "Q &r " + OutputCharacters.NOT + pInverseOrXPh;

    // !((!(Q &r !(pInverse ^ XPh))) U (pInverse ^ XPhH))
    private static String template = OutputCharacters.NOT + OutputCharacters.OPEN_P + OutputCharacters.OPEN_P + OutputCharacters.NOT + OutputCharacters.OPEN_P +
    		qAndNotSomething + OutputCharacters.CLOSE_P + OutputCharacters.CLOSE_P + OutputCharacters.UNTIL + pInverseOrXPh + OutputCharacters.CLOSE_P;

	@Override
	public String generateFormula(String pProposition, String qProposition, String rProposition, String lProposition) {
		String formula = template;
		List<String> q = getCompositeProposition(qProposition);
		List<String> pH = getHProposition(pProposition);
		String pInverse = String.join("", getParallelInverse(pProposition));

		List<String> rightSide = new ArrayList<String>();
		rightSide.add(OutputCharacters.NOT);
		rightSide.add(pInverseOrXPh);
		formula = formula.replace(qAndNotSomething, operatorGenerator.getAndedPropositions(AND_R, q, rightSide));

		formula = formula.replace("pInverse", pInverse);
		formula = formula.replace("Ph", String.join("", pH));

		return formula;
	}

}
