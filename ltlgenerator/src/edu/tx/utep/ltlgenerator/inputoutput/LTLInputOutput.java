package edu.tx.utep.ltlgenerator.inputoutput;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import edu.tx.utep.ltlgenerator.LTLCharacters;
import edu.tx.utep.ltlgenerator.LTLPatternType;
import edu.tx.utep.ltlgenerator.LTLScopeType;
import edu.tx.utep.ltlgenerator.factories.LTLGeneratorFactory;

public class LTLInputOutput {

	public LTLInputOutput() {
		// TODO Auto-generated constructor stub
	}
	
	private static final int inputLinesToRead = 7;
	
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
	
		
	private static String getInputType(String lineInput){
		String inputType = "";
		String lineInputUpperCase = lineInput.toUpperCase();
		if (lineInputUpperCase.contains(PATTERN + SEPARATOR)){
			inputType = PATTERN;
		} else if (lineInputUpperCase.contains(SCOPE + SEPARATOR)){
			inputType = SCOPE;
		} else if (lineInputUpperCase.contains(ATLEASTONEC.toUpperCase())){
			inputType = ATLEASTONEC;
		} else if (lineInputUpperCase.contains(ATLEASTONEH.toUpperCase())){
			inputType = ATLEASTONEH;
		} else if (lineInputUpperCase.contains(ATLEASTONEE.toUpperCase())){
			inputType = ATLEASTONEE;
		} else if (lineInputUpperCase.contains(PARALLELC.toUpperCase())){
			inputType = PARALLELC;
		} else if (lineInputUpperCase.contains(PARALLELH.toUpperCase())){
			inputType = PARALLELH;
		} else if (lineInputUpperCase.contains(PARALLELE.toUpperCase())){
			inputType = PARALLELE;
		} else if (lineInputUpperCase.contains(CONSECUTIVEC.toUpperCase())){
			inputType = CONSECUTIVEC;
		} else if (lineInputUpperCase.contains(CONSECUTIVEH.toUpperCase())){
			inputType = CONSECUTIVEH;
		} else if (lineInputUpperCase.contains(CONSECUTIVEE.toUpperCase())){
			inputType = CONSECUTIVEE;
		} else if (lineInputUpperCase.contains(EVENTUALC.toUpperCase())){
			inputType = EVENTUALC;
		} else if (lineInputUpperCase.contains(EVENTUALH.toUpperCase())){
			inputType = EVENTUALH;
		} else if (lineInputUpperCase.contains(EVENTUALE.toUpperCase())){
			inputType = EVENTUALE;
		}
		return inputType;
	}
	
	private static int getFirstSeparatorIndex(String lineInput){
		return lineInput.indexOf(SEPARATOR);
	}
		
	private static LTLScopeType getScope(String lineInput){
		String scopeString = null;
		int startScopeIndex = getFirstSeparatorIndex(lineInput) + 1;
		scopeString = lineInput.substring(startScopeIndex);
		
		switch (scopeString.toUpperCase()){
		case "AFTERL":
			return LTLScopeType.AfterL;
		case "AFTERLUNTILR":
			return LTLScopeType.AfterLUntilR;
		case "BEFORER":
			return LTLScopeType.BeforeR;
		case "BETWEENLANDR":
			return LTLScopeType.BetweenLAndR;
		case "GLOBAL":
			return LTLScopeType.Global;
		default:
			return null;
		}
		
	}
	
	private static LTLPatternType getPattern(String lineInput){
		String patternString = null;
		int startPatternIndex = getFirstSeparatorIndex(lineInput) + 1;
		patternString = lineInput.substring(startPatternIndex);
		
		switch (patternString.toUpperCase()){
			case "ABSENCE":
				return LTLPatternType.Absence;
			case "EXISTENCE":
				return LTLPatternType.Existence;
			case "PRECEDENCE":
				return LTLPatternType.Precedence;
			case "RESPONSE":
				return LTLPatternType.Response;
			case "STRICTPRECEDENCE":
				return LTLPatternType.StricPrecedence;
			default:
				return null;
		}
	}
	
	private static String getNumberOfCPs(String lineInput){
		int firstIndexOfNumberOfCPs = lineInput.lastIndexOf(CP_SEPARATOR) + 1;
		return lineInput.substring(firstIndexOfNumberOfCPs);	
	}
	
	private static String getDateTime(){
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date).toString();
	}
	
	
	public static void processInput(){//String inputFile, String outputFile){
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
        
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"))) {
        	int readingLineNumber = 1;
            
        	StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("*********************************************************************************" + System.lineSeparator());
            stringBuilder.append("LTL GENERATOR RUN @ " + getDateTime() + System.lineSeparator());
            stringBuilder.append("*********************************************************************************" + System.lineSeparator());
            
            lineReadFromInputFile = bufferedReader.readLine();

            while (lineReadFromInputFile != null) {
            	
            	inputType = getInputType(lineReadFromInputFile);
            	
            	if (readingLineNumber < inputLinesToRead ){
	            	if (inputType.equals(SCOPE)){
	            		scope = getScope(lineReadFromInputFile);
	            	} else if (inputType.equals(PATTERN)){
	            		pattern = getPattern(lineReadFromInputFile);
	            	} else {
	            		if ( !inputType.isEmpty() ){
		            		//input type must be a CP in this case
		            		String numberOfCPs = getNumberOfCPs(lineReadFromInputFile);
		            		if (lineReadFromInputFile.substring(0, 1).toUpperCase().equals("L")){
		            			L = "L" + CP_SEPARATOR + inputType + CP_SEPARATOR + numberOfCPs;
		            		} else if (lineReadFromInputFile.substring(0, 1).toUpperCase().equals("P")){
		            			P = "P" + CP_SEPARATOR + inputType + CP_SEPARATOR + numberOfCPs;
		            		} else if (lineReadFromInputFile.substring(0, 1).toUpperCase().equals("Q")){
		            			Q = "Q" + CP_SEPARATOR + inputType + CP_SEPARATOR + numberOfCPs;
		            		} else if (lineReadFromInputFile.substring(0, 1).toUpperCase().equals("R")){
		            			R = "R" + CP_SEPARATOR + inputType + CP_SEPARATOR + numberOfCPs;
		            		}
	            		} else {
	            			//Something went wrong for this Input Set, go to the next one
	            			for (int i = readingLineNumber; i < inputLinesToRead; i++){
	            				lineReadFromInputFile = bufferedReader.readLine();
	                        	readingLineNumber++;
	            			}
	            			readingLineNumber = 0;
	            		}
	            	} 
            	} else {
            		isOkToCallLTLGenerator = ((scope != null) && (pattern != null) && (L != null) && (P != null) && (Q != null) && (R != null));
            		if (isOkToCallLTLGenerator){
	            		//Process LTL Formula
	            		
            			LTLGeneratorFactory ltlGeneratorFactory = LTLGeneratorFactory.getLTLGeneratorFactory(scope);
            			ltlFormula = ltlGeneratorFactory.getLTLFormula(pattern, P, Q, R, L);
	            		
            			stringBuilder.append(System.lineSeparator());
            			stringBuilder.append("---------------------------------------------------------" + System.lineSeparator());
	            		stringBuilder.append("Scope: " + scope.toString() + System.lineSeparator());
	            		stringBuilder.append("Pattern: " + pattern.toString() + System.lineSeparator());
	            		stringBuilder.append(P + System.lineSeparator());
	            		stringBuilder.append(Q + System.lineSeparator());
	            		stringBuilder.append(R + System.lineSeparator());
	            		stringBuilder.append(L + System.lineSeparator());
	            		stringBuilder.append(System.lineSeparator() + System.lineSeparator());
	            		stringBuilder.append("LTL Formula:" + System.lineSeparator());
	            		stringBuilder.append(ltlFormula + System.lineSeparator());
	            		stringBuilder.append("---------------------------------------------------------" + System.lineSeparator());
	            		
	            		saveResultsToFile(stringBuilder.toString());
	            		stringBuilder.setLength(0);
	            		
	            		readingLineNumber = 0;
	            		scope = null;
	            		pattern = null;
	            		ltlFormula = null;
	            		L = null;
	            		P = null;
	            		Q = null;
	            		R = null;
            		}
            		
            	}
            	
            	lineReadFromInputFile = bufferedReader.readLine();
            	readingLineNumber++;
            }
        } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void saveResultsToFile(String results){
   	 try {
            FileWriter writer = new FileWriter("output.txt", true);
            writer.write(results);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
   }
	
}
