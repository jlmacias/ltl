package edu.tx.utep.ltlgenerator.templates.between;

import edu.tx.utep.ltlgenerator.templates.Template;

import java.util.ArrayList;
import java.util.List;

public class BetweenLAndRc extends Template {

    private String template = "G((L &l !R) -> (L &l PR))";
    private Template beforeRTemplate;

    public BetweenLAndRc(Template beforeRTemplate){
        this.beforeRTemplate = beforeRTemplate;
    }

    @Override
    public String generateFormula(String pProposition, String qProposition, String rProposition, String lProposition) {
        String formula = template;
        String PRString = beforeRTemplate.generateFormula(pProposition, qProposition, rProposition, lProposition);
        List<String> l = getCompositeProposition(lProposition);
        List<String> r = getCompositeProposition(rProposition);
        String lString = String.join("", l);
        String rString = String.join("", r);

        List<String> notR = new ArrayList<String>();
        notR.add("!" + rString);
        String andedL1 = operatorGenerator.getAndedPropositions(AND_L, l, notR);
        formula = formula.replace("(L &l !R)", andedL1);

        List<String> PR = new ArrayList<String>();
        PR.add(PRString);
        String andedL2 = operatorGenerator.getAndedPropositions(AND_L, l, PR);
        formula = formula.replace("(L &l PR)", andedL2);

        formula = formula.replace("R", rString);
        formula = formula.replace("L", lString);

        return formula;
    }
}
