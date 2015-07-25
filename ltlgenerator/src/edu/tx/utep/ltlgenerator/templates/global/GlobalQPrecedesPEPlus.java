package edu.tx.utep.ltlgenerator.templates.global;

import java.util.ArrayList;
import java.util.List;

import edu.tx.utep.ltlgenerator.templates.Template;


public class GlobalQPrecedesPEPlus extends Template {
    // Q can be anything BUT AtLeastOneC or ParallelC, and P has to be event type
    private static String template = "!((!(Q &-l !(Pi ^ X(Ph)))) U (Pi ^ X(Ph)))";

    @Override
    public String generateFormula(String pProposition, String qProposition, String rProposition, String lProposition) {
        String formula = template;
		List<String> q = getCompositeProposition(qProposition);
		List<String> ph = getHProposition(pProposition);
		String pinverse = String.join("", getParallelInverse(pProposition));


        List<String> rightSide = new ArrayList<String>();
        rightSide.add("!(Pi ^ X(Ph))");
        formula = formula.replace("(Q &-l !(Pi ^ X(Ph)))", operatorGenerator.getAndedPropositions(AND_MINUS_L, q, rightSide));

        //replace the Ph's
        formula = formula.replace("(Ph)", String.join("", ph));

        // replace !p1 ^ ... ^ !pn
        formula = formula.replace("Pi", pinverse);

        return formula;
    }

}



