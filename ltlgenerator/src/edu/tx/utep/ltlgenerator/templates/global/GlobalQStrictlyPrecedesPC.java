package edu.tx.utep.ltlgenerator.templates.global;

import edu.tx.utep.ltlgenerator.templates.Template;
import java.util.ArrayList;
import java.util.List;

public class GlobalQStrictlyPrecedesPC extends Template {

    private static String template = "!((!(Q &R !P)) U P)";

    @Override
    public String generateFormula(String pProposition, String qProposition, String rProposition, String lProposition) {
        List<String> p = getCompositeProposition(pProposition);
        List<String> q = getCompositeProposition(qProposition);
        String formula = template;
        String pString = String.join("", p);
        List<String> rightSideP = new ArrayList<String>();
        rightSideP.add("!(");
        rightSideP.addAll(p);
        rightSideP.add(")");

        String andedQP = operatorGenerator.getAndedPropositions(AND_R, q, rightSideP);
        formula = formula.replace("Q &R !P", andedQP);
        formula = formula.replace("P", pString);

        return formula;
    }

}