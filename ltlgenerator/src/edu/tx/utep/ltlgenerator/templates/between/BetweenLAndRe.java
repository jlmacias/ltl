package edu.tx.utep.ltlgenerator.templates.between;

import edu.tx.utep.ltlgenerator.templates.Template;

import java.util.ArrayList;
import java.util.List;

public class BetweenLAndRe extends Template {

    private String template = "G(L -> (L &l PR))";
    private Template beforeRTemplate;

    public BetweenLAndRe(Template beforeRTemplate){
        this.beforeRTemplate = beforeRTemplate;
    }

    @Override
    public String generateFormula(String pProposition, String qProposition, String rProposition, String lProposition) {
        String formula = template;
        String PRString = beforeRTemplate.generateFormula(pProposition, qProposition, rProposition, lProposition);
        List<String> l = getCompositeProposition(lProposition);
        String lString = String.join("", l);

        List<String> PR = new ArrayList<String>();
        PR.add(PRString);
        String andedL = operatorGenerator.getAndedPropositions(AND_L, l, PR);
        formula = formula.replace("(L &l PR)", andedL);

        formula = formula.replace("L", lString);

        return formula;
    }
}
