package edu.tx.utep.ltlgenerator.templates.beforer;

import java.util.List;
import edu.tx.utep.ltlgenerator.templates.Template;

public class QStrictlyPrecedesPcBeforeRc extends Template {

    private static String template = "(FR) -> (((!(P &r !R)) U ((Q &r !P) v R))";

    @Override
    public String generateFormula(String pProposition, String qProposition, String rProposition, String lProposition) {
        String formula = template;
        List<String> r = getCompositeProposition(rProposition);
        List<String> p = getCompositeProposition(pProposition);
        List<String> q = getCompositeProposition(qProposition);
        String rString = String.join("", r);

        List<String> notR = r;
        notR.add(0, "!");
        String andedP = operatorGenerator.getAndedPropositions(AND_R, p, notR);
        formula = formula.replace("(P &r !R)", andedP);

        List<String> notP = p;
        notP.add(0, "!");
        String andedQ = operatorGenerator.getAndedPropositions(AND_R, q, notP);
        formula = formula.replace("(Q &r !P)", andedQ);

        formula = formula.replace("R", rString);

        return formula;
    }
}
