package edu.tx.utep.ltlgenerator.cps;

public abstract class CompositeProposition {

	protected static final String AND = "and";
	protected static final String OR = "or";
	protected static final String NOT_AND = "notAnd";
	protected static final String NOT_OR = "notOr";

	public String generateLTL(String letter, int count) {
		return "Please implement this method in the subclass";
	}

	protected String generateProposition(String cpType, String letter, int count) {
		switch (cpType) {
		case AND:
			return generateProposition(letter, count, "v", "");
		case NOT_AND:
			return generateProposition(letter, count, "^", "!");
		case OR:
			return generateProposition(letter, count, "^", "");
		case NOT_OR:
			return generateProposition(letter, count, "^", "!");
		default:
			return "ERROR No CPType of " + cpType;
		}
	}

	private String generateProposition(String letter, int count, String andOr, String not) {
		StringBuilder output = new StringBuilder();
		for (int i = 1; i <= count; i++) {
			output.append(not).append(letter).append(i);
			if (i < count)
				output.append(" ").append(andOr).append(" ");
		}
		return output.toString();
	}

}
