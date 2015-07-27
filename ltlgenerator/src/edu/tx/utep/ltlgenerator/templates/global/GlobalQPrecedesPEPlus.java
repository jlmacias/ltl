package edu.tx.utep.ltlgenerator.templates.global;

import java.util.ArrayList;
import java.util.List;

import edu.tx.utep.ltlgenerator.templates.Template;


public class GlobalQPrecedesPEPlus extends Template {

    private static String template = "!((!(Q &-l !(pInverse ^ XPH))) U (pInverse ^ XPH))";

    @Override
    public String generateFormula(String pProposition, String qProposition, String rProposition, String lProposition) {
        String formula = template;
		List<String> q = getCompositeProposition(qProposition);
		List<String> pH = getHProposition(pProposition);
		String pInverse = String.join("", getParallelInverse(pProposition));

        List<String> rightSide = new ArrayList<String>();
        rightSide.add("!(pInverse ^ XPH)");
        formula = formula.replace("Q &-l !(pInverse ^ XPH)", operatorGenerator.getAndedPropositions(AND_MINUS_L, q, rightSide));

        formula = formula.replace("PH", String.join("", pH));
        formula = formula.replace("pInverse", pInverse);

        return formula;
    }

}



