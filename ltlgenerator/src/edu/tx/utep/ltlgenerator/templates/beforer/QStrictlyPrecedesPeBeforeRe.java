package edu.tx.utep.ltlgenerator.templates.beforer;

import edu.tx.utep.ltlgenerator.templates.Template;

import java.util.List;

public class QStrictlyPrecedesPeBeforeRe extends Template {

    private static String template = "(FR) -> ((!((pInverse) ^ !RH ^ X(PH &r !RH))) U ((Q &r !PH) v ((rInverse) ^ XRH)))";
                                    // (FR) -> ((!((pInverse) ^ !RH ^ X(PH &r !RH))) U ((Q &r !PH) v ((rInverse) ^ XRH)))

    @Override
    public String generateFormula(String pProposition, String qProposition, String rProposition, String lProposition) {
        String formula = template;

        List<String> r = getCompositeProposition(rProposition);
        List<String> q = getCompositeProposition(qProposition);
        List<String> rH = getHProposition(rProposition);
        List<String> pH = getHProposition(pProposition);
        String pInverse = String.join("", getParallelInverse(pProposition));
        String rInverse = String.join("", getParallelInverse(rProposition));
        String rHString = String.join("", rH);
        String rString = String.join("", r);
        
        List<String> notRH = rH;
        notRH.add(0, "!");
        List<String> notPH = pH;
        notPH.add(0, "!");

        String andedPH = operatorGenerator.getAndedPropositions(AND_R, pH, notRH);
        formula = formula.replace("(PH &r !RH)", andedPH);

        String andedQ = operatorGenerator.getAndedPropositions(AND_R, q, notPH);
        formula = formula.replace("(Q &r !PH)", andedQ);

        formula = formula.replace("pInverse", pInverse);
        formula = formula.replace("rInverse", rInverse);
        formula = formula.replace("RH", rHString);
        formula = formula.replace("R", rString);

        return formula;
    }
}
