package edu.tx.utep.ltlgenerator.templates.global;

import edu.tx.utep.ltlgenerator.templates.Template;

import java.util.List;

public class GlobalQStrictlyPrecedesPC extends Template {
    private static String template = "!((!(Q &r !P)) U P)";

    @Override
    public String generateFormula(String pProposition, String qProposition, String rProposition, String lProposition) {
        String formula = template;

        List<String> q = getCompositeProposition(qProposition);
        List<String> pH = getHProposition(pProposition);
        String pInverse = String.join("", getParallelInverse(pProposition));

        return formula;
    }
}
