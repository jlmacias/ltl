package edu.tx.utep.ltlgenerator.templates.global;

import java.util.List;

import edu.tx.utep.ltlgenerator.OutputCharacters;
import edu.tx.utep.ltlgenerator.templates.Template;

public class GlobalQPrecedesPEStar extends Template {

	// !((!(Q ^ !(pInverse ^ XPH))) U (pInverse ^ XPH ^ !Q))
	private static String template = OutputCharacters.NOT + OutputCharacters.OPEN_P + OutputCharacters.OPEN_P + OutputCharacters.NOT + OutputCharacters.OPEN_P +
			"Q" + OutputCharacters.AND + OutputCharacters.NOT + OutputCharacters.OPEN_P + "pInverse" + OutputCharacters.AND + OutputCharacters.NEXT + "Ph" + OutputCharacters.CLOSE_P +
			OutputCharacters.CLOSE_P + OutputCharacters.CLOSE_P + OutputCharacters.UNTIL + OutputCharacters.OPEN_P + "pInverse" + OutputCharacters.AND + OutputCharacters.NEXT +
			"Ph" + OutputCharacters.AND + OutputCharacters.NOT + "Q" + OutputCharacters.CLOSE_P + OutputCharacters.CLOSE_P;

	@Override
	public String generateFormula(String pProposition, String qProposition, String rProposition, String lProposition) {
		String formula = template;
		List<String> q = getCompositeProposition(qProposition);
		List<String> pH = getHProposition(pProposition);
		String pHString = String.join("", pH);
		String qString = String.join("", q);
		String pInverse = String.join("", getParallelInverse(pProposition));

		formula = formula.replace("pInverse", pInverse);
		formula = formula.replace("Ph", pHString);
		formula = formula.replace("Q", qString);

		return formula;
	}
}