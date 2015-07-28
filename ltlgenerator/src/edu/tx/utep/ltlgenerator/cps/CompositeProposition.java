package edu.tx.utep.ltlgenerator.cps;

import java.util.List;

import edu.tx.utep.ltlgenerator.OutputCharacters;

public abstract class CompositeProposition {

	protected static final String CPT_AND = "and";
	protected static final String CPT_OR = "or";
	protected static final String CPT_NOT_AND = "notAnd";
	protected static final String CPT_NOT_OR = "notOr";

	// Template Method Pattern
	public List<String> generateLTLFormulaArray(String letter, int count) {
		return generateLTLArray(letter, count);
	}

	protected abstract List<String> generateLTLArray(String letter, int count);

	protected String generateProposition(String cpType, String letter, int firstProposition, int lastProposition) {
		return generateProposition(cpType, letter, firstProposition, lastProposition, true);
	}

	protected String generateProposition(String cpType, String letter, int firstProposition, int lastProposition, boolean addNotToTheFirstOne) {
		switch (cpType) {
		case CPT_AND:
			return generateProposition(letter, firstProposition, lastProposition, OutputCharacters.AND, "", addNotToTheFirstOne);
		case CPT_NOT_AND:
			return generateProposition(letter, firstProposition, lastProposition, OutputCharacters.AND, OutputCharacters.NOT, addNotToTheFirstOne);
		case CPT_OR:
			return generateProposition(letter, firstProposition, lastProposition, OutputCharacters.OR, "", addNotToTheFirstOne);
		case CPT_NOT_OR:
			return generateProposition(letter, firstProposition, lastProposition, OutputCharacters.OR, OutputCharacters.NOT, addNotToTheFirstOne);
		default:
			return "ERROR No CPType of " + cpType;
		}
	}

	private String generateProposition(String letter, int firstProposition, int lastProposition, String andOr, String not, boolean addNotToTheFirstOne) {
		StringBuilder output = new StringBuilder();
		for (int i = firstProposition; i <= lastProposition; i++) {
			if (addNotToTheFirstOne && i == firstProposition) {
				output.append(not);
			} else if (i > firstProposition) {
				output.append(not);
			}
			output.append(letter).append(i);
			if (i < lastProposition)
				output.append(andOr);
		}
		return output.toString();
	}

}
