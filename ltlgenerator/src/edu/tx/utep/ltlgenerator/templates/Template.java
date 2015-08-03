package edu.tx.utep.ltlgenerator.templates;

import java.util.List;

import edu.tx.utep.ltlgenerator.CPGenerator;
import edu.tx.utep.ltlgenerator.OperatorGenerator;
import edu.tx.utep.ltlgenerator.OutputCharacters;
import edu.tx.utep.ltlgenerator.factories.OperatorFactory;
import edu.tx.utep.ltlgenerator.operators.AndLForBeforeR;

public abstract class Template {

	public abstract String generateFormula(String pProposition, String qProposition, String rProposition, String lProposition);
	protected OperatorGenerator operatorGenerator = new OperatorGenerator();
	protected CPGenerator cpGenerator = new CPGenerator();
	protected AndLForBeforeR andLForBeforeR = new  AndLForBeforeR();

	protected static final String AND_L = OperatorFactory.AND_L;
	protected static final String AND_R = OperatorFactory.AND_R;
	protected static final String AND_MINUS_L = OperatorFactory.AND_MINUS_L;

	// Template Factory Method
	public String getLTLFormula(String pProposition, String qProposition, String rProposition, String lProposition){
		String formula = generateFormula(pProposition, qProposition, rProposition, lProposition);
		return replaceOperatorStrings(formula);
	}

	protected List<String> getCompositeProposition(String propositionName) {
		return cpGenerator.getCompositeProposition(propositionName);
	}

	protected List<String> getParallelInverse(String propositionName) {
		// Get the letter and number from the proposition name
		String[] splitCP = propositionName.split("_");
		String inverseName = splitCP[0] + "_ParallelInverse_" + splitCP[2]; 
		return cpGenerator.getCompositeProposition(inverseName);
	}
	
	protected List<String> getHProposition(String propositionName) {
		StringBuilder hProposition = new StringBuilder(propositionName);
		int currentLetterIndex = propositionName.lastIndexOf("_")-1;
		hProposition.setCharAt(currentLetterIndex, 'H');
		return cpGenerator.getCompositeProposition(hProposition.toString());
	}
	
	private String replaceOperatorStrings(String formula) {
		formula = formula.replace(OutputCharacters.O_AND, OutputCharacters.AND);
		formula = formula.replace(OutputCharacters.O_CLOSE_P, OutputCharacters.CLOSE_P);
		formula = formula.replace(OutputCharacters.O_OPEN_P, OutputCharacters.OPEN_P);
		return formula;
	}

}
