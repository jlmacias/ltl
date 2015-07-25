package edu.tx.utep.ltlgenerator.templates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class GlobalQPrecedesPEPlus extends Template {
    // Q can be anything BUT AtLeastOneC or ParallelC, and P has to be event type
    private static String template = "!((!(Q &-l !(!p1 ^ ··· ^ !pn ^ X(Ph)))) U (!p1 ^ ··· ^ !pn ^ X(Ph)))";

    @Override
    public String generateFormula(String pProposition, String qProposition, String rProposition, String lProposition) {
        String formula = template;
		List<String> q = getCompositeProposition(qProposition);
		List<String> ph = getHProposition(pProposition);
		String pinverse = String.join("", getParallelInverse(pProposition));

        List<String> anded = new ArrayList<>(Arrays.asList("!(!p1 ^ ··· ^ !pn ^ X(Ph))".split(" ")));
        formula = formula.replace("(Q &-l !(!p1 ^ ··· ^ !pn ^ X(Ph)))", operatorGenerator.getAndedPropositions(AND_MINUS_L, q, anded));

        //replace the Ph's
        formula = formula.replace("(Ph)", String.join("", ph));

        // replace !p1 ^ ... ^ !pn
        formula = formula.replace("!p1^···^!pn^", pinverse);
        formula = formula.replace("!p1 ^ ··· ^ !pn ^ ", pinverse);

        return formula;
    }

}



