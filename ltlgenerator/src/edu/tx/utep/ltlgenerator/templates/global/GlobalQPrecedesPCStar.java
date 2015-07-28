package edu.tx.utep.ltlgenerator.templates.global;

import java.util.List;

import edu.tx.utep.ltlgenerator.OutputCharacters;
import edu.tx.utep.ltlgenerator.templates.Template;

public class GlobalQPrecedesPCStar extends Template {

	// !((!Q) U (P ^ !Q))
	private static String template = OutputCharacters.NOT + OutputCharacters.OPEN_P + OutputCharacters.OPEN_P + OutputCharacters.NOT + "Q" + OutputCharacters.CLOSE_P +
			OutputCharacters.UNTIL + OutputCharacters.OPEN_P + "P" + OutputCharacters.AND + OutputCharacters.NOT + "Q" + OutputCharacters.CLOSE_P + OutputCharacters.CLOSE_P;

	@Override
	public String generateFormula(String pProposition, String qProposition, String rProposition, String lProposition) {
		String formula = template;
		List<String> p = getCompositeProposition(pProposition);
		List<String> q = getCompositeProposition(qProposition);
		String pString = String.join("", p);
		String qString = String.join("", q);

		formula = formula.replace("Q", qString);
		formula = formula.replace("P", pString);

		return formula;
	}

}
