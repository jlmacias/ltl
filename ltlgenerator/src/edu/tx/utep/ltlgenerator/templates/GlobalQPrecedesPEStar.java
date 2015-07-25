package edu.tx.utep.ltlgenerator.templates;

import edu.tx.utep.ltlgenerator.factories.OperatorFactory;

import java.util.List;

public class GlobalQPrecedesPEStar extends Template {
    private static String template = "!((!(Q andMinusL !(parallelInverse ^ XPH))) U (parallelInverse ^ XPH))";
    private static final String AND_MINUSL = OperatorFactory.AND_MINUS_L;

    @Override
    public String generateFormula(List<String> p, List<String> q, List<String> r, List<String> l) {
        String formula = template;


        return null;
    }
}
