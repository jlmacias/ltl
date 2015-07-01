package edu.tx.utep.ltlgenerator.cps;

public abstract class CompositeProposition {

	protected static final String AND = "and";
	protected static final String OR = "or";
	protected static final String NOT_AND = "notAnd";
	protected static final String NOT_OR = "notOr";

	public String generateLTL(String letter, int count) {
		return "Please implement this method in the subclass";
	}

	protected String generateProposition(String cpType, String letter, int firstProposition, int lastProposition) {
		switch (cpType) {
		case AND:
			return generateProposition(letter, firstProposition, lastProposition, "^", "");
		case NOT_AND:
			return generateProposition(letter, firstProposition, lastProposition, "^", "!");
		case OR:
			return generateProposition(letter, firstProposition, lastProposition, "v", "");
		case NOT_OR:
			return generateProposition(letter, firstProposition, lastProposition, "v", "!");
		default:
			return "ERROR No CPType of " + cpType;
		}
	}

	private String generateProposition(String letter, int firstProposition, int lastProposition, String andOr, String not) {
		StringBuilder output = new StringBuilder();
		for (int i = firstProposition; i <= lastProposition; i++) {
			output.append(not).append(letter).append(i);
			if (i < lastProposition)
				output.append(" ").append(andOr).append(" ");
		}
		return output.toString();
	}

}
