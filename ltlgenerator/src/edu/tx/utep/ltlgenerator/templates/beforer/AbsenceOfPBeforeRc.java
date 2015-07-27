package edu.tx.utep.ltlgenerator.templates.beforer;

import edu.tx.utep.ltlgenerator.templates.Template;

import java.util.List;

public class AbsenceOfPBeforeRc extends Template {
    private static String template = "!((!R) U ((P &r !R) &l templatePart2))";
    private static String templatePart2 = "FR";

    @Override
    public String generateFormula(String pProposition, String qProposition, String rProposition, String lProposition) {
        String formula = template;
        String rightSideAndL = templatePart2;
        String andedL;
        List<String> p = getCompositeProposition(pProposition);
        List<String> r = getCompositeProposition(rProposition);
        String rString = String.join("", r);

        List<String> notR = getCompositeProposition(rProposition); //I noticed in my code that assigning it to r just makes them the same, so r is also negated when the notR.add instruction below is executed
        notR.add(0, "!");

        String andedR = operatorGenerator.getAndedPropositions(AND_R, p, notR);
        rightSideAndL = rightSideAndL.replace("R", rString);
        andedL = andLForBeforeR.getAndLForBeforeR(andedR, rightSideAndL);
        
        formula = formula.replace("(P &r !R) &l templatePart2",	andedL);
        formula = formula.replace("!R", String.join("", notR));
        
        return formula;
    }
}
