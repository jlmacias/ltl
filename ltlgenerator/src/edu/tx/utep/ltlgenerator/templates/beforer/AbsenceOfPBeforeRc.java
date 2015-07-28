package edu.tx.utep.ltlgenerator.templates.beforer;

import java.util.List;

import edu.tx.utep.ltlgenerator.OutputCharacters;
import edu.tx.utep.ltlgenerator.templates.Template;

public class AbsenceOfPBeforeRc extends Template {
	
    // FR
    private static String templatePart2 = OutputCharacters.EVENTUALLY + "R";

    // (P &r !R) &l templatePart2
    private static String pAndNotRAndStuff = OutputCharacters.OPEN_P + "P &r " + OutputCharacters.NOT + "R" + OutputCharacters.CLOSE_P + " &l templatePart2";

    // !((!R) U ((P &r !R) &l templatePart2))
    private static String template = OutputCharacters.NOT + OutputCharacters.OPEN_P + OutputCharacters.OPEN_P + OutputCharacters.NOT + "R" + OutputCharacters.CLOSE_P + OutputCharacters.UNTIL + 
    		OutputCharacters.OPEN_P + pAndNotRAndStuff + OutputCharacters.CLOSE_P + OutputCharacters.CLOSE_P;

    @Override
    public String generateFormula(String pProposition, String qProposition, String rProposition, String lProposition) {
        String formula = template;
        String rightSideAndL = templatePart2;
        String andedL;
        List<String> p = getCompositeProposition(pProposition);
        List<String> r = getCompositeProposition(rProposition);
        String rString = String.join("", r);

        List<String> notR = getCompositeProposition(rProposition); 
        //I noticed in my code that assigning it to r just makes them the same, so r is also negated when the notR.add instruction below is executed
        notR.add(0, OutputCharacters.NOT);

        String andedR = operatorGenerator.getAndedPropositions(AND_R, p, notR);
        rightSideAndL = rightSideAndL.replace("R", rString);
        andedL = andLForBeforeR.getAndLForBeforeR(andedR, rightSideAndL);
        
        formula = formula.replace(pAndNotRAndStuff,	andedL);
        formula = formula.replace("!R", String.join("", notR));
        
        return formula;
    }
}
