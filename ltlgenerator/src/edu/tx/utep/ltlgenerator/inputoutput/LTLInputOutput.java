package edu.tx.utep.ltlgenerator.inputoutput;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import edu.tx.utep.ltlgenerator.LTLCharacters;
import edu.tx.utep.ltlgenerator.LTLPatternType;
import edu.tx.utep.ltlgenerator.LTLScopeType;
import edu.tx.utep.ltlgenerator.exceptions.LTLScopeTypeNotFoundException;
import edu.tx.utep.ltlgenerator.factories.LTLGeneratorFactory;

public class LTLInputOutput {

	protected static final int inputLinesToRead = 7;

	protected static final String PATTERN = LTLCharacters.PATTERN;
	protected static final String SCOPE = LTLCharacters.SCOPE;
	protected static final String SEPARATOR = LTLCharacters.SEPARATOR;
	protected static final String ATLEASTONEC = LTLCharacters.ATLEASTONEC;
	protected static final String ATLEASTONEH = LTLCharacters.ATLEASTONEH;
	protected static final String ATLEASTONEE = LTLCharacters.ATLEASTONEE;
	protected static final String PARALLELC = LTLCharacters.PARALLELC;
	protected static final String PARALLELH = LTLCharacters.PARALLELH;
	protected static final String PARALLELE = LTLCharacters.PARALLELE;
	protected static final String CONSECUTIVEC = LTLCharacters.CONSECUTIVEC;
	protected static final String CONSECUTIVEH = LTLCharacters.CONSECUTIVEH;
	protected static final String CONSECUTIVEE = LTLCharacters.CONSECUTIVEE;
	protected static final String EVENTUALC = LTLCharacters.EVENTUALC;
	protected static final String EVENTUALH = LTLCharacters.EVENTUALH;
	protected static final String EVENTUALE = LTLCharacters.EVENTUALE;
	protected static final String CP_SEPARATOR = LTLCharacters.CP_SEPARATOR;
	protected static final String EMPTY_CP_INDICATOR = LTLCharacters.EMPTY_CP_INDICATOR;

	protected static String getNumberOfCPs(String lineInput) {
		int firstIndexOfNumberOfCPs = lineInput.lastIndexOf(CP_SEPARATOR) + 1;
		return lineInput.substring(firstIndexOfNumberOfCPs);
	}

	protected static String getFormattedCompositeProposition(String cpLetter, String cpType, String numberOfCPs) {
		if (!cpType.equals(EMPTY_CP_INDICATOR)) {
			return cpLetter + CP_SEPARATOR + cpType + CP_SEPARATOR + numberOfCPs;
		} else {
			return "";
		}
	}

	public static void processInput() {// String inputFile, String outputFile){
		String lineReadFromInputFile = null;
		String inputType = null;
		String ltlFormula = null;
		LTLScopeType scope = null;
		LTLPatternType pattern = null;
		String L = null;
		String P = null;
		String Q = null;
		String R = null;
		boolean isOkToCallLTLGenerator = false;

		try (BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"))) {
			int readingLineNumber = 1;

			OutputToFile.outputInitialMessage();

			lineReadFromInputFile = bufferedReader.readLine();

			while (lineReadFromInputFile != null) {

				inputType = ProcessInput.getInputType(lineReadFromInputFile);

				if (readingLineNumber < inputLinesToRead) {
					if (inputType.equals(SCOPE)) {
						scope = ProcessInput.getScope(lineReadFromInputFile);
					} else if (inputType.equals(PATTERN)) {
						pattern = ProcessInput.getPattern(lineReadFromInputFile);
					} else {
						if (!inputType.isEmpty()) {
							// input type must be a CP in this case
							String numberOfCPs = getNumberOfCPs(lineReadFromInputFile);
							if (lineReadFromInputFile.substring(0, 1).toUpperCase().equals("L")) {
								L = getFormattedCompositeProposition("L", inputType, numberOfCPs);
							} else if (lineReadFromInputFile.substring(0, 1).toUpperCase().equals("P")) {
								P = getFormattedCompositeProposition("P", inputType, numberOfCPs);
							} else if (lineReadFromInputFile.substring(0, 1).toUpperCase().equals("Q")) {
								Q = getFormattedCompositeProposition("Q", inputType, numberOfCPs);
							} else if (lineReadFromInputFile.substring(0, 1).toUpperCase().equals("R")) {
								R = getFormattedCompositeProposition("R", inputType, numberOfCPs);
							}
						} else {
							// Something went wrong for this Input Set, go to the next one
							for (int i = readingLineNumber; i < inputLinesToRead; i++) {
								lineReadFromInputFile = bufferedReader.readLine();
								readingLineNumber++;
							}
							readingLineNumber = 0;

							OutputToFile.outputInputErrorMessage();
						}
					}
				} else {
					isOkToCallLTLGenerator = ((scope != null) && (pattern != null) && (L != null) && (P != null) && (Q != null) && (R != null));
					if (isOkToCallLTLGenerator) {

						try {
							LTLGeneratorFactory ltlGeneratorFactory = LTLGeneratorFactory.getLTLGeneratorFactory(scope);
							ltlFormula = ltlGeneratorFactory.getLTLFormula(pattern, P, Q, R, L);

							OutputToFile.outputLTLFormulaResultSet(scope.toString(), pattern.toString(), P, Q, R, L, ltlFormula);

							readingLineNumber = 0;
							scope = null;
							pattern = null;
							ltlFormula = null;
							L = null;
							P = null;
							Q = null;
							R = null;
						} catch (LTLScopeTypeNotFoundException e) {
							e.printStackTrace();
						}
					}
				}

				lineReadFromInputFile = bufferedReader.readLine();
				readingLineNumber++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
