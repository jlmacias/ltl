package edu.tx.utep.ltlgenerator.templates.between;

import edu.tx.utep.ltlgenerator.OutputCharacters;
import edu.tx.utep.ltlgenerator.templates.Template;

import java.util.ArrayList;
import java.util.List;

public class BetweenLAndRe extends Template {

    // L &l PR
    private static String L_AndL_PR = "L &l PR";

    // G(L -> (L &l PR))
    private static String template =
            OutputCharacters.ALWAYS + OutputCharacters.OPEN_P + "L" + OutputCharacters.IMPLY +
            OutputCharacters.OPEN_P + L_AndL_PR + OutputCharacters.CLOSE_P + OutputCharacters.CLOSE_P;

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

        List<String> PR = new ArrayList<>();
        PR.add(PRString);
        String andedL = operatorGenerator.getAndedPropositions(AND_L, l, PR);
        formula = formula.replace(L_AndL_PR, andedL);

        formula = formula.replace("L", lString);

        return formula;
    }
}
