package edu.tx.utep.ltlgenerator.templates.afterl;

import edu.tx.utep.ltlgenerator.OutputCharacters;
import edu.tx.utep.ltlgenerator.templates.Template;

import java.util.ArrayList;
import java.util.List;

public class AfterLUntilRc extends Template {

    // (L &l !R)
    private static String L_AndL_NotR = OutputCharacters.OPEN_P + "L &l " + OutputCharacters.NOT + "R" + OutputCharacters.CLOSE_P;

    // ((PR ^ (!FR) -> PG))
    private static String rightSide = OutputCharacters.OPEN_P + OutputCharacters.OPEN_P + "PR" + OutputCharacters.AND +
            OutputCharacters.OPEN_P + OutputCharacters.NOT + OutputCharacters.EVENTUALLY + "R" + OutputCharacters.NOT + "R" + OutputCharacters.CLOSE_P + OutputCharacters.IMPLY + "PG" + OutputCharacters.CLOSE_P + OutputCharacters.CLOSE_P;

    // (L &l rightSide)
    private static String L_AndL_rightSide = OutputCharacters.OPEN_P + "L &l " + rightSide + OutputCharacters.CLOSE_P;

    // G(L_AndL_NotR -> (L &l rightSide))
    private static String template = OutputCharacters.ALWAYS + OutputCharacters.OPEN_P + L_AndL_NotR + L_AndL_rightSide;

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

        List<String> notR = new ArrayList<>();
        notR.add(OutputCharacters.NOT + getCompositeProposition(rProposition));
        String andedL1 = operatorGenerator.getAndedPropositions(AND_L, getCompositeProposition(lProposition), notR);
        formula = formula.replace(L_AndL_NotR, andedL1);

        List<String> rSide = new ArrayList<>();
        rSide.add(PRString + " ^ ((!F" + getCompositeProposition(rProposition) + ") -> " + PGString + ")))");
        String andedL2 = operatorGenerator.getAndedPropositions(AND_L, getCompositeProposition(lProposition), rSide);
        formula = formula.replace(L_AndL_rightSide, andedL2);

        formula = formula.replace("R", String.join("", getCompositeProposition(rProposition)));
        formula = formula.replace("L", String.join("", getCompositeProposition(lProposition)));

        return formula;
    }
}
