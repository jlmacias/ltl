package edu.tx.utep.ltlgenerator.templates.between;

import edu.tx.utep.ltlgenerator.OutputCharacters;
import edu.tx.utep.ltlgenerator.templates.Template;

import java.util.ArrayList;
import java.util.List;

public class BetweenLAndRc extends Template {

    // L &r !R
    private static String L_AndL_NotR = "L &l " + OutputCharacters.NOT + "R";

    // L &l PR
    private static String L_AndL_PR = "L &l PR";

    // G((L &l !R) -> (L &l PR))
    private static String template =
            OutputCharacters.ALWAYS +
            OutputCharacters.OPEN_P + OutputCharacters.OPEN_P + L_AndL_NotR + OutputCharacters.CLOSE_P +
            OutputCharacters.IMPLY +
            OutputCharacters.OPEN_P + L_AndL_PR + OutputCharacters.CLOSE_P + OutputCharacters.CLOSE_P;

    private Template beforeRTemplate;

    public BetweenLAndRc(Template beforeRTemplate){
        this.beforeRTemplate = beforeRTemplate;
    }

    @Override
    public String generateFormula(String pProposition, String qProposition, String rProposition, String lProposition) {
        String formula = template;
        List<String> l = getCompositeProposition(lProposition);
        List<String> r = getCompositeProposition(rProposition);
        String PRString = beforeRTemplate.generateFormula(pProposition, qProposition, rProposition, lProposition);

        List<String> notR = r;
        notR.add(0, OutputCharacters.NOT);

        String andedL1 = operatorGenerator.getAndedPropositions(AND_L, l, notR);
        formula = formula.replace(L_AndL_NotR, andedL1);

        l = getCompositeProposition(lProposition);

        List<String> PR = new ArrayList<>();
        PR.add(PRString);
        String andedL2 = operatorGenerator.getAndedPropositions(AND_L, l, PR);
        formula = formula.replace(L_AndL_PR, andedL2);

        return formula;
    }
}
