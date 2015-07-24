package edu.tx.utep.ltlgenerator.templates;

import java.util.ArrayList;
import java.util.List;

import edu.tx.utep.ltlgenerator.CPGenerator;
import edu.tx.utep.ltlgenerator.LTLGenerator;


public class GlobalQStrictlyPrecedesPE extends Template {

	private CPGenerator cpGenerator = new CPGenerator();
                                  // "!((!(Q &R !(!p1 ^......^!pn ^ X PH))) U (!p1 ^ ...^ !pn ^ X PH))"
	private static String template = "!((!(Q &R !(PARALLEINVERSE ^ X PH))) U (PARALLELINVERSE ^ X PH))";

	@Override
	public String generateFormula(List<String> p, List<String> q, List<String> r, List<String> l) {
		
		String Input_P_Proposition = LTLGenerator.getPProposition();
		String[] splitCP = Input_P_Proposition.split("_");
		String letter = splitCP[0].toLowerCase();            //this code cluster is used to create parallelInverse cp            
		String countS = splitCP[2];
		List<String> parallelInverse = cpGenerator.getCompositeProposition(letter + "_ParallelInverse_" + countS);
        
		String formula = template;
		List<String> parallelInverse_X_PH = new ArrayList<String>();
		parallelInverse_X_PH.addAll(parallelInverse);
		parallelInverse_X_PH.add(" ^ X");
		parallelInverse_X_PH.addAll(p);

		List<String> NotParallelInverse_X_PH = new ArrayList<String>();
		NotParallelInverse_X_PH.add(0, "!(");
		NotParallelInverse_X_PH.addAll(parallelInverse_X_PH);
		NotParallelInverse_X_PH.add(")");
		
		String andedQP = operatorGenerator.getAndedPropositions(AND_R, q, NotParallelInverse_X_PH);
		formula = formula.replace("Q &R !(PARALLEINVERSE ^ X PH)", andedQP);
		String pInverse_X_PH = String.join("", parallelInverse_X_PH );
		formula = formula.replace("PARALLELINVERSE ^ X PH", pInverse_X_PH);
		
		return formula;
	}

}
