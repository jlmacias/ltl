package edu.tx.utep.ltlgenerator.factories;

import edu.tx.utep.ltlgenerator.LTLCharacters;
import edu.tx.utep.ltlgenerator.LTLScopeType;
import edu.tx.utep.ltlgenerator.LTLPatternType;
import edu.tx.utep.ltlgenerator.LTLGenerator;

//Abstract Factory
public abstract class LTLGeneratorFactory {
	
	protected LTLGenerator ltlGenerator = new LTLGenerator();
	
	public static LTLGeneratorFactory getLTLGeneratorFactory(LTLScopeType ltlScopeType){
		
		switch ( ltlScopeType ){
			case Global:
				return new GlobalFactory();
				
			case BeforeR:
				return new BeforeRFactory();
				
			case AfterL:
				return new AfterLFactory();
				
			case BetweenLAndR:
				return new BetweenLAndRFactory();
				
			case AfterLUntilR:
				return new AfterLUntilRFactory();

			default:
				return null;
				
		}
		
	}
	
	public abstract String getLTLFormula(LTLPatternType ltlPatternType, String p, String q, String r, String l);
	
	protected static boolean isCompositePropositionOfTypeC(String cp){
		int cpTypeLetterIndicatorIndex = getCPTypeLetterIndicatorIndex(cp); 
		if (cp.charAt(cpTypeLetterIndicatorIndex) == 'C'){
			return true;
		} else {
			return false;
		}
	}
	
	protected static boolean isCompositePropositionOfTypeE(String cp){
		int cpTypeLetterIndicatorIndex = getCPTypeLetterIndicatorIndex(cp); 
		if (cp.charAt(cpTypeLetterIndicatorIndex) == 'E'){
			return true;
		} else {
			return false;
		}
	}
	
	private static int getCPTypeLetterIndicatorIndex(String cp){
		return cp.lastIndexOf(LTLCharacters.CP_SEPARATOR) - 1;
	}
}