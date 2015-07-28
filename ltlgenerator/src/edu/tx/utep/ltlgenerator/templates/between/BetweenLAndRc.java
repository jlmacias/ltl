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
        List<String> l = getCompositeProposition(lProposition);
        String PRString = beforeRTemplate.generateFormula(pProposition, qProposition, rProposition, lProposition);
        List<String> r = getCompositeProposition(rProposition);
        String lString = String.join("", l);
        String rString = String.join("", r);

        List<String> notR = new ArrayList<String>();
        notR.add("!" + rString);
        String andedL1 = operatorGenerator.getAndedPropositions(AND_L, l, notR);
        formula = formula.replace("(L &l !R)", andedL1);

        l = getCompositeProposition(lProposition);

        List<String> PR = new ArrayList<>();
        PR.add(PRString);
        String andedL2 = operatorGenerator.getAndedPropositions(AND_L, l, PR);
        formula = formula.replace("(L &l PR)", andedL2);

        formula = formula.replace("R", rString);
        formula = formula.replace("L", lString);

        return formula;
    }
}
