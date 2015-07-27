package edu.tx.utep.ltlgenerator.templates.beforer;

import java.util.List;
import edu.tx.utep.ltlgenerator.templates.Template;

public class QStrictlyPrecedesPeBeforeRc extends Template {

    private static String template = "(FR) -> ((!((pInverse) ^ !R ^ X(PH &r !R))) U ((Q &r !(PH)) v R))";

    @Override
    public String generateFormula(String pProposition, String qProposition, String rProposition, String lProposition) {
        String formula = template;

        String pInverse = String.join("", getParallelInverse(pProposition));
        List<String> pH = getHProposition(pProposition);
        List<String> r = getCompositeProposition(rProposition);
        List<String> q = getCompositeProposition(qProposition);
        String rString = String.join("", r);

        List<String> notR = r;
        notR.add(0, "!");
        String notRString = String.join("", notR);
        String andedPH = operatorGenerator.getAndedPropositions(AND_R, pH, notR);
        formula = formula.replace("(PH &r !R)", andedPH);

        List<String> notpH = pH;
        notR.add(0, "!");
        String andedQ = operatorGenerator.getAndedPropositions(AND_R, q, notpH);
        formula = formula.replace("(Q &r !(PH))", andedQ);

        formula = formula.replace("pInverse", pInverse);
        formula = formula.replace("!R", notRString);
        formula = formula.replace("R", rString);

        return formula;
    }
}