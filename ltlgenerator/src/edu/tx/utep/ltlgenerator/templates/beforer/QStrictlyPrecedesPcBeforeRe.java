package edu.tx.utep.ltlgenerator.templates.beforer;

import edu.tx.utep.ltlgenerator.templates.Template;

import java.util.List;

public class QStrictlyPrecedesPcBeforeRe extends Template {

    private static String template = "(FR) -> (((!(P &r !RH)) U ((Q &r !P) v ((rInverse) ^ XRH))))";

    @Override
    public String generateFormula(String pProposition, String qProposition, String rProposition, String lProposition) {
        String formula = template;

        List<String> p = getCompositeProposition(pProposition);
        List<String> rH = getHProposition(rProposition);
        List<String> r = getCompositeProposition(rProposition);
        List<String> q = getCompositeProposition(qProposition);
        String rInverse = String.join("", getParallelInverse(rProposition));
        String rString = String.join("", r);
        String rHString = String.join("", rH);

        List<String> notRh = rH;
        notRh.add(0, "!");
        String andedP = operatorGenerator.getAndedPropositions(AND_R, p, notRh);
        formula = formula.replace("(P &r !RH)", andedP);

        List<String> notP = p;
        notRh.add(0, "!");
        String andedQ = operatorGenerator.getAndedPropositions(AND_R, q, notP);
        formula = formula.replace("(Q &r !P)", andedQ);

        formula = formula.replace("rInverse", rInverse);
        formula = formula.replace("RH", rHString);
        formula = formula.replace("R", rString);

        return formula;
    }
}
