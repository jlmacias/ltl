package edu.tx.utep.ltlgenerator.templates.until;

import edu.tx.utep.ltlgenerator.templates.Template;

import java.util.ArrayList;
import java.util.List;

public class AfterLUntilRc extends Template {

    private String template = "G((L &l !R) -> (L &l ((PR ^ ((!FR) -> PG)))))";
    private Template globalTemplate;
    private Template beforeRTemplate;

    public AfterLUntilRc(Template globalTemplate, Template beforeRTemplate){
        this.globalTemplate = globalTemplate;
        this.beforeRTemplate = beforeRTemplate;
    }

    @Override
    public String generateFormula(String pProposition, String qProposition, String rProposition, String lProposition) {
        String formula = template;
        String PRString = beforeRTemplate.generateFormula(pProposition, qProposition, rProposition, lProposition);
        String PGString = globalTemplate.generateFormula(pProposition, qProposition, rProposition, lProposition);
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
        List<String> rightSide = new ArrayList<>();
        rightSide.add(PRString + " ^ ((!F" + rString + ") -> " + PGString + ")))");

        String andedL2 = operatorGenerator.getAndedPropositions(AND_L, l, rightSide);
        formula = formula.replace("L &l ((PR ^ ((!FR) -> PG)))", andedL2);

        formula = formula.replace("R", rString);
        formula = formula.replace("L", lString);

        return formula;
    }
}
