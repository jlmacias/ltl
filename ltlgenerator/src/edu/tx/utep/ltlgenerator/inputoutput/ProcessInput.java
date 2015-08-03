package edu.tx.utep.ltlgenerator.inputoutput;

import edu.tx.utep.ltlgenerator.LTLPatternType;
import edu.tx.utep.ltlgenerator.LTLScopeType;

public class ProcessInput extends LTLInputOutput {

	protected static String getInputType(String lineInput){
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
		} else if (lineInputUpperCase.contains(EMPTY_CP_INDICATOR.toUpperCase())){
			return EMPTY_CP_INDICATOR;
		}
		return inputType;
	}
	
	protected static int getFirstSeparatorIndex(String lineInput){
		return lineInput.indexOf(SEPARATOR);
	}
		
	protected static LTLScopeType getScope(String lineInput){
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
	
	protected static LTLPatternType getPattern(String lineInput){
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
}
