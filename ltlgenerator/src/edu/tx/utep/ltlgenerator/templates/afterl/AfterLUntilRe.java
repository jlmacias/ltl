package edu.tx.utep.ltlgenerator.templates.until;


import edu.tx.utep.ltlgenerator.templates.Template;


import java.util.ArrayList;
import java.util.Arrays;


public class AfterLUntilRe extends Template {

    private String template = "G((L) -> (L &l ((P_BeforeR ^ ((!FR) -> P_Global)))))";
    private Template globalTemplate;
    private Template beforeRTemplate;

    public AfterLUntilRe(Template globalTemplate, Template beforeRTemplate) {
        this.globalTemplate = globalTemplate;
        this.beforeRTemplate = beforeRTemplate;
    }

    @Override
    public String generateFormula(String pProposition, String qProposition, String rProposition, String lProposition) {
        String formula = template;
        String globalFormula = globalTemplate.generateFormula(pProposition, qProposition, rProposition, lProposition);
        String beforeRFormula = beforeRTemplate.generateFormula(pProposition, qProposition, rProposition, lProposition);


        // solve for anded formula
        formula = formula.replace("L &l ((P_BeforeR ^ ((!FR) -> P_Global)))", operatorGenerator.getAndedPropositions(
                AND_L,
                getCompositeProposition(lProposition),
                new ArrayList<String>(Arrays.asList("((P_BeforeR ^ ((!FR) -> P_Global)))".split(",")))
        ));

        //replace L
        formula = formula.replace("(L)", String.join("", getCompositeProposition(lProposition)));

        // replace R
        formula = formula.replace("FR", "F(" + String.join("", getCompositeProposition(rProposition)) + ")");

        // replace P_Global
        formula = formula.replace("P_Global", globalFormula);

        // replace P_BeforeR
        formula = formula.replace("P_BeforeR", beforeRFormula);

        return formula;
    }


//    public static void main(String[] args) {
//        AfterLUntilRe cons = new AfterLUntilRe(new GlobalAbsenceOfP(),new ExistenceOfPBeforeRe());
//        String output = cons.generateFormula(
//                "P_ParallelE_2",
//                "Q_EventualC_3",
//                "R_ConsecutiveE_2",
//                "L_AtLeastOneC_3"
//        );
//
//        System.out.println(output);
//    }
}



