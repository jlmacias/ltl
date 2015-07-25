package edu.tx.utep.ltlgenerator.templates;

import edu.tx.utep.ltlgenerator.CPGenerator;
import edu.tx.utep.ltlgenerator.OperatorGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class GlobalQPrecedesPEPlus extends Template {
    // Q can be anything BUT AtLeastOneC or ParallelC, and P has to be event type
    private static String template = "!((!(Q &-l !(!p1 ^ ··· ^ !pn ^ X(Ph)))) U (!p1 ^ ··· ^ !pn ^ X(Ph)))";

    @Override
    public String generateFormula(List<String> q, List<String> p, List<String> r, List<String> l) {
        String formula = template;


        List<String> anded = new ArrayList<>(Arrays.asList("!(!p1 ^ ··· ^ !pn ^ X(Ph))".split(" ")));
        formula = formula.replace("(Q &-l !(!p1 ^ ··· ^ !pn ^ X(Ph)))", new OperatorGenerator().getAndedPropositions(AND_MINUS_L, q, anded));

        //find n
        int n = findN(p);
        //replace the Ph's
        formula = formula.replace("(Ph)", pickPh(p, n));


        // replace !p1 ^ ... ^ !pn
        formula = formula.replace("!p1^···^!pn^", occurrencesOfP(n));
        formula = formula.replace("!p1 ^ ··· ^ !pn ^ ", occurrencesOfP(n));

        return formula;
    }

    private String occurrencesOfP(int n) {
        String retP = "";

        for (int i = 1; i <= n; i++) {
            retP += (i == n) ? "!p" + i + " ^ " : "!p" + i + " ^ ";
        }


        assert !retP.equals("");

        return retP;
    }

    private int findN(List<String> p) {
        String tempCp = String.join("", p);
        int n = 0;
        for (int i = 0; i < tempCp.length(); i++) {
            if (Character.isDigit(tempCp.charAt(i))) {
                n = Math.max(n, tempCp.charAt(i) - 48);
            }
        }

        assert n != 0;

        return n;
    }


    private String pickPh(List<String> p, int n) {
        // get the last part of the string
        String lastEntry, lastEntryLong;
        lastEntry = lastEntryLong = String.join("", p);
        // getting the last word of the string
        lastEntry = lastEntry.substring(lastEntry.lastIndexOf(" "));
        lastEntryLong = lastEntryLong.substring(lastEntryLong.lastIndexOf(" ^ "));

        assert !lastEntry.equals(")");
        // EventualE ends with ...^ !q3 ^ ((!q3) U (q3))))))
        if (lastEntry.endsWith("))))))")) {
            return String.join("", new CPGenerator().getCompositeProposition2("P_EventualH_" + n));
        }
        // ConsecutiveE ends with ...^ X(q2 ^ !q3 ^ X(q3))))
        else if (lastEntry.endsWith("))))")) {
            return String.join("", new CPGenerator().getCompositeProposition2("P_ConsecutiveH_" + n));
        }

        // else it can be AtLeastOneE or ParallelE which are the same
        else {
            if (lastEntryLong.length() < 8) {
                return String.join("", new CPGenerator().getCompositeProposition2("P_ParallelH_" + n));
            } else {
                return String.join("", new CPGenerator().getCompositeProposition2("P_AtLeastOneH_" + n));
            }

        }

    }
}



