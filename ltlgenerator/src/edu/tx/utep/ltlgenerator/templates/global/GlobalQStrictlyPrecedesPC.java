package edu.tx.utep.ltlgenerator.templates.global;

import java.util.List;

import edu.tx.utep.ltlgenerator.templates.Template;

public class GlobalQStrictlyPrecedesPC extends Template {

    private static String template = "!((!(Q &r !P)) U P)";

    @Override
    public String generateFormula(String pProposition, String qProposition, String rProposition, String lProposition) {
        String formula = template;
        List<String> p = getCompositeProposition(pProposition);
        List<String> q = getCompositeProposition(qProposition);
        String pString = String.join("", p);

        List<String> notP = p;
        notP.add(0, "!");

        formula = formula.replace("Q &r !P", operatorGenerator.getAndedPropositions(AND_R, q, notP));
        formula = formula.replace("P", pString);

        return formula;
    }

}