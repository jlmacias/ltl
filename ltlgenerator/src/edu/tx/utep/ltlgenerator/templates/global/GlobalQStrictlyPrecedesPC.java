package edu.tx.utep.ltlgenerator.templates.global;

import java.util.List;

import edu.tx.utep.ltlgenerator.OutputCharacters;
import edu.tx.utep.ltlgenerator.templates.Template;

public class GlobalQStrictlyPrecedesPC extends Template {

	   // Q &r !P
	   private static String qAndNotP = "Q &r " + OutputCharacters.NOT + "P";
	   
	   // !((!(Q &r !P)) U P)
	   private static String template = OutputCharacters.NOT + OutputCharacters.OPEN_P + OutputCharacters.OPEN_P + OutputCharacters.NOT + OutputCharacters.OPEN_P + 
			   qAndNotP + OutputCharacters.CLOSE_P + OutputCharacters.CLOSE_P + OutputCharacters.UNTIL + "P" + OutputCharacters.CLOSE_P;

    @Override
    public String generateFormula(String pProposition, String qProposition, String rProposition, String lProposition) {
        String formula = template;
        List<String> p = getCompositeProposition(pProposition);
        List<String> q = getCompositeProposition(qProposition);
        String pString = String.join("", p);

        List<String> notP = p;
        notP.add(0, OutputCharacters.NOT);

        formula = formula.replace(qAndNotP, operatorGenerator.getAndedPropositions(AND_R, q, notP));
        formula = formula.replace("P", pString);

        return formula;
    }

}