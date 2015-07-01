package edu.tx.utep.ltlgenerator.cps;

public class EventualE extends CompositeProposition {

	//private static String cpFormula = "(!l1 ^ !l2 ^ !l3 ^ !l4) ^ ((!l1 ^ !l2 ^ !l3 ^ !l4) U (l1 ^ ! l2 ^ !l3 ^ !l4 ^ ((!l2 ^ !l3 ^ !l4) U (l2 ^ !l3 ^ !l4 ^ (l3 ^ !l4 ^ (!l4 U l4))))))"; 

	@Override
	public String generateLTL(String letter, int count) {
		return "";
	}

}
