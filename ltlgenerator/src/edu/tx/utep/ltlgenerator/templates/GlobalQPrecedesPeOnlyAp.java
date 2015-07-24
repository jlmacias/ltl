package edu.tx.utep.ltlgenerator.templates;

import java.util.ArrayList;
import java.util.List;

public class GlobalQPrecedesPeOnlyAp extends Template {
  
	/*
	 * rTemplate will be used for the right side of the & operator
	 * 
	 * I = (!p1 ^ !p2 ^ !pn ^ XP) which is Parallel Inverse
	 * & = Q &-l !I
	 * 
	 *  !((!(Q &-l !(!p1 ^ !p2 ^ !pn ^ XP))) U (!p1 ^ !p2 ^ !pn ^ XP))
	 *  !((!(Q &-l !I)) U I)
	 *  !((!(&)) U I)
	 *  
	 *  This gives us a simplified template that we can easily manipulate
	 */
	
	private static String template = "!((!(&)) U I)";

	@Override
	public String generateFormula(List<String> p, List<String> q, List<String> r,
			List<String> l) {
		
		/*
		 * Parameters of List
		 * 
		 * p = preposition string for P
		 * q = preposition string for Q
		 * r = ParallelInverse preposition with expected format (!p1 ^ !p2 ^ !pn)
		 * 
		 */
		
		String formula = template;
		
		/*
		 * Changing parallel Inverse preposition from
		 * (!p1 ^ !p2 ^ !pn) to (!p1 ^ !p2 ^ !pn ^ XP)
		 * 
		 * Warning: this is with the assumption that r will be the Parallel Inverse
		 * preposition otherwise it will not work.
		 */
		
	  List<String> parallelInverse = r;
		parallelInverse.remove(")");
		parallelInverse.add(" ^ X");
		parallelInverse.addAll(p);
		parallelInverse.add(")");

		/*
		 * We make parallelInverse a string instead of list since
		 * we will be using it later
		 * 
		 */

		String parallelformula = String.join("", parallelInverse);
		
		/*
		 * We create a new list called right side since it will be at the right
		 * of the & operator and we format it in the following manner:
		 * 
		 * !I = !(!p1 ^ !p2 ^ !p3 ^ !pn ^ XP)
		 *
		 */
		
		List<String> rightsideP = new ArrayList<String>();
		rightsideP.add("!");
		rightsideP.add(parallelformula);
	
		/*
		 * We create new operator generator and pass the parameters
		 * 
		 */
	
		String andminusl = operatorGenerator.getAndedPropositions(AND_MINUS_L, q, rightsideP);
		
		/*
		 * After recieving the & operation we replace & with andminusl
		 * and we call back parallel formula to substitute the I
		 * 
		 */
	
	  formula = formula.replace("&",andminusl);
	  formula = formula.replace("I", parallelformula);
		
	  
		return formula;
	}
}
