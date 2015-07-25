package edu.tx.utep.ltlgenerator.templates.beforer;

import edu.tx.utep.ltlgenerator.templates.Template;

import java.util.LinkedList;
import java.util.List;

public class AbsenceOfPBeforeRc extends Template {
    private static String template = "!((!R) U ((P &r !R) &l FR))";

    @Override
    public String generateFormula(String pProposition, String qProposition, String rProposition, String lProposition) {
        String formula = template;
        List<String> p = getCompositeProposition(pProposition);
        String pString = String.join("", p);
        List<String> r = getCompositeProposition(rProposition);
        String rString = String.join("", r);

        List<String> notR = r;
        notR.add(0, "!");

        String andedR = operatorGenerator.getAndedPropositions(AND_R, p, notR);
        formula = formula.replace("(P &r !R)", andedR);
        formula = formula.replace("R", rString);

        return formula;
    }
}
