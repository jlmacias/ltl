package edu.tx.utep.ltlgenerator.cps;

public abstract class CompositeProposition {

	protected static final String CPT_AND = "and";
	protected static final String CPT_OR = "or";
	protected static final String CPT_NOT_AND = "notAnd";
	protected static final String CPT_NOT_OR = "notOr";

	protected static final String AND = " ^ ";
	protected static final String OR = " v ";
	protected static final String NOT = "!";
	protected static final String NEXT = "X";
	protected static final String UNTIL = " U ";
	protected static final String OPEN_P = "(";
	protected static final String CLOSE_P = ")";

	
	public String generateLTL(String letter, int count) {
		return "Please implement this method in the subclass";
	}

	protected String generateProposition(String cpType, String letter, int firstProposition, int lastProposition) {
		switch (cpType) {
		case CPT_AND:
			return generateProposition(letter, firstProposition, lastProposition, AND, "");
		case CPT_NOT_AND:
			return generateProposition(letter, firstProposition, lastProposition, AND, NOT);
		case CPT_OR:
			return generateProposition(letter, firstProposition, lastProposition, OR, "");
		case CPT_NOT_OR:
			return generateProposition(letter, firstProposition, lastProposition, OR, NOT);
		default:
			return "ERROR No CPType of " + cpType;
		}
	}

	private String generateProposition(String letter, int firstProposition, int lastProposition, String andOr, String not) {
		StringBuilder output = new StringBuilder();
		for (int i = firstProposition; i <= lastProposition; i++) {
			output.append(not).append(letter).append(i);
			if (i < lastProposition)
				output.append(andOr);
		}
		return output.toString();
	}

}
