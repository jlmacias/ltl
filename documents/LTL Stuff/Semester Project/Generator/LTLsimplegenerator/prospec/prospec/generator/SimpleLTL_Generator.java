package prospec.generator;
import prospec.model.pattern.Absence;
import prospec.model.pattern.Existence;
import prospec.model.pattern.Precedence;
import prospec.model.pattern.Response;
import prospec.model.pattern.StrictPrecedence;
import prospec.model.pattern.Universality;
import prospec.model.property.Property;
import prospec.model.scope.AfterL;
import prospec.model.scope.AfterLuntilR;
import prospec.model.scope.BeforeR;
import prospec.model.scope.BetweenLandR;
import prospec.model.scope.Global;


public class SimpleLTL_Generator{

	private String generateUniversalityAfterLuntilR(Property P) {	
	       
		return "[]((" + ((AfterLuntilR)P.getScope()).getL().getName() + " AND ¬" + ((AfterLuntilR)P.getScope()).getR().getName() + 
		")->(¬((" + ((Universality)P.getPattern()).getP().getName() + " AND ¬" + ((AfterLuntilR)P.getScope()).getR().getName() + ")U((¬" + 
	    ((Universality)P.getPattern()).getP().getName() + ") AND ¬" + ((AfterLuntilR)P.getScope()).getR().getName() + "))))";
	}
	
	private String generateUniversalityAfterL(Property P) {
		     
		return "¬((¬" + ((AfterL)P.getScope()).getL().getName() + ")U(" + ((AfterL)P.getScope()).getL().getName() + " AND <>¬" +
				((Universality)P.getPattern()).getP().getName() + "))";
	}
	
	private String generateAbsenceAfterL(Property P) {
		   
		return "¬((¬" + ((AfterL)P.getScope()).getL().getName() + ")U(" + ((AfterL)P.getScope()).getL().getName() + " AND <>" +
				((Absence)P.getPattern()).getP().getName() + "))";
	}
	
	private String generateAbsenceAfterLuntilR(Property P) {
	       
		return "[](" + ((AfterLuntilR)P.getScope()).getL().getName() + " AND ¬(" + ((AfterLuntilR)P.getScope()).getR().getName() + 
		")->¬(¬(" + ((AfterLuntilR)P.getScope()).getR().getName() + ")U" + ((Absence)P.getPattern()).getP().getName() + "))";
	}
	
	private String generateExistenceAfterL(Property P) {
	       
		return "¬((¬" + ((AfterL)P.getScope()).getL().getName() + ")U(" + ((AfterL)P.getScope()).getL().getName() + " AND ¬<>" +
		((Existence)P.getPattern()).getP().getName() + "))";
	}
	
	private String generatePrecedenceAfterL(Property P) {
	       
		return "¬((¬" + ((AfterL)P.getScope()).getL().getName() + ")U(" +  ((AfterL)P.getScope()).getL().getName() + " AND ((¬" + 
		((Precedence)P.getPattern()).getQ().getName() + ")U(" + ((Precedence)P.getPattern()).getP().getName() + " AND ¬" + 
		((Precedence)P.getPattern()).getQ().getName() + "))))";
	}
	
	private String generatePrecedenceAfterLuntilR(Property P) {
	       
		return "[]((" + ((AfterLuntilR)P.getScope()).getL().getName() + " AND ¬" + ((AfterLuntilR)P.getScope()).getR().getName() +
		")->(¬(((¬" + ((Precedence)P.getPattern()).getQ().getName() + ") AND ¬" + ((AfterLuntilR)P.getScope()).getR().getName() + ")U(" + 
		((Precedence)P.getPattern()).getP().getName() + " AND (¬" + ((Precedence)P.getPattern()).getQ().getName() + ") AND ¬" + 
		((AfterLuntilR)P.getScope()).getR().getName() + ")))";
	}
	
	private String generateResponseAfterL(Property P) {
	       
		return "¬((¬" + ((AfterL)P.getScope()).getL().getName() + ")U(" + ((AfterL)P.getScope()).getL().getName() +
		" AND (¬[](" + ((Response)P.getPattern()).getP().getName() + "-><>" + ((Response)P.getPattern()).getQ().getName() + "))))";
	}
	
	private String generateResponseAfterLuntilR(Property P) {
	       
		return "[]((" + ((AfterLuntilR)P.getScope()).getL().getName() + " AND ¬" + ((AfterLuntilR)P.getScope()).getR().getName() + ")->¬((¬" +
		((AfterLuntilR)P.getScope()).getR().getName() + ")U(" + ((Response)P.getPattern()).getP().getName() + " AND (¬" + 
		((AfterLuntilR)P.getScope()).getR().getName() + ") AND (([]((¬" + ((Response)P.getPattern()).getQ().getName() + ") AND ¬" +
		((AfterLuntilR)P.getScope()).getR().getName() + ")) OR ((¬" + ((Response)P.getPattern()).getQ().getName() + ")U" + 
		((AfterLuntilR)P.getScope()).getR().getName() + "))))))";
	}
	
	private String generateStrictPrecedenceAfterL(Property P) {
	       
		return "¬((¬" + ((AfterL)P.getScope()).getL().getName() + ")U(" + ((AfterL)P.getScope()).getL().getName() + " AND ((¬(" +
		((StrictPrecedence)P.getPattern()).getQ().getName() + " AND ¬" + ((StrictPrecedence)P.getPattern()).getP().getName() + "))U" + 
		((StrictPrecedence)P.getPattern()).getP().getName() + ")))";
	}
	
	private String generateStrictPrecedenceAfterLuntilR(Property P) {
	       
		return "¬<>(" + ((AfterLuntilR)P.getScope()).getL().getName() + " AND (¬" + ((AfterLuntilR)P.getScope()).getR().getName() + 
		") AND (((¬" + ((StrictPrecedence)P.getPattern()).getQ().getName() + ") AND ¬" + ((AfterLuntilR)P.getScope()).getR().getName() + ")U(" +
		((StrictPrecedence)P.getPattern()).getP().getName() + " AND ¬" + ((AfterLuntilR)P.getScope()).getR().getName() + ")))";
	}
	
	private String generateExistenceBeforeR(Property P) {
	       
		return "¬((¬" + ((Existence)P.getPattern()).getP().getName() + ")U" + ((BeforeR)P.getScope()).getR().getName() + ")";
	}
	
	private String generateExistenceBetweenLandR(Property P) {
	       
		return "[]((" + ((BetweenLandR)P.getScope()).getL().getName() + " AND ¬" + ((BetweenLandR)P.getScope()).getR().getName() + ")->(¬((¬" +
		((Existence)P.getPattern()).getP().getName() + ")U" + ((BetweenLandR)P.getScope()).getR().getName() + ")))";
	}
	
	private String generateResponseBeforeR(Property P) {
	       
		return "¬((¬" + ((BeforeR)P.getScope()).getR().getName() + ")U(" + ((Response)P.getPattern()).getP().getName() + " AND (¬" +		 
		((BeforeR)P.getScope()).getR().getName() + ")))";
	}
	
	private String generateResponseBetweenLandR(Property P) {
	       
		return "[]((" + ((BetweenLandR)P.getScope()).getL().getName() + " AND ¬" + ((BetweenLandR)P.getScope()).getR().getName() + 
		")->¬((¬" + ((BetweenLandR)P.getScope()).getR().getName() + ")U(" + ((Response)P.getPattern()).getP().getName() + " AND (¬" + 
		((BetweenLandR)P.getScope()).getR().getName() + ") AND ((¬" + ((Response)P.getPattern()).getQ().getName() + ")U" +
		((BetweenLandR)P.getScope()).getR().getName() + "))))";
	}
	
	private String generateStrictPrecedenceBetweenLandR(Property P) {
	       
		return "[]((" + ((BetweenLandR)P.getScope()).getL().getName() + " AND ¬" + ((BetweenLandR)P.getScope()).getR().getName() + 
		")->(¬(((¬(" + ((StrictPrecedence)P.getPattern()).getQ().getName() + " AND ¬" + ((StrictPrecedence)P.getPattern()).getP().getName() + ")) AND ¬" +
		((BetweenLandR)P.getScope()).getR().getName() + ")U(" + ((StrictPrecedence)P.getPattern()).getP().getName() + " AND (¬(" + 
		((StrictPrecedence)P.getPattern()).getQ().getName() + " AND ¬" + ((StrictPrecedence)P.getPattern()).getP().getName() + ")) AND (¬" + 
		((BetweenLandR)P.getScope()).getR().getName() + ") AND <>" + ((BetweenLandR)P.getScope()).getR().getName() + "))))";
	}
	
	private String generatePrecedenceGlobal(Property P) {
	       
		return "¬((¬" + ((Precedence)P.getPattern()).getQ().getName() + ")U(" + ((Precedence)P.getPattern()).getP().getName() + " AND ¬" +
		((Precedence)P.getPattern()).getQ().getName() + "))";
	}
	
	private String generateStrictPrecedenceGlobal(Property P) {
	       
		return "¬((¬" + ((StrictPrecedence)P.getPattern()).getQ().getName() + " AND ¬" + ((StrictPrecedence)P.getPattern()).getP().getName() + "))U" +
		((StrictPrecedence)P.getPattern()).getP().getName() + "))";
	}
	
	private String generateAbsenceGlobal(Property P) {
	       
		return "¬(<>" + ((Absence)P.getPattern()).getP().getName() + ")";
	}
	
	private String generateAbsenceBeforeR(Property P) {
	       
		return "<>" + ((BeforeR)P.getScope()).getR().getName() + "->¬(¬(" + ((BeforeR)P.getScope()).getR().getName() + ")U" + 
		((Absence)P.getPattern()).getP().getName() + ")";
	}
	
	private String generateAbsenceBetweenLandR(Property P) {
	       
		return "[]((" + ((BetweenLandR)P.getScope()).getL().getName() + " AND ¬(" + ((BetweenLandR)P.getScope()).getR().getName() + ") AND <>" + 
		((BetweenLandR)P.getScope()).getR().getName() + ")->¬(¬(" + ((BetweenLandR)P.getScope()).getR().getName() + ")U" + ((Absence)P.getPattern()).getP().getName() +
		"))";
	}
	
	private String generateExistenceGlobal(Property P) {
	       
		return "(<>" + ((Existence)P.getPattern()).getP().getName() + ")";
	}
	
	private String generateExistenceAfterLuntilR(Property P) {
	       
		return "[]((" + ((AfterLuntilR)P.getScope()).getL().getName() + " AND ¬(" + ((AfterLuntilR)P.getScope()).getR().getName() + "))->(¬(" +
		((AfterLuntilR)P.getScope()).getR().getName() + ")U(" + ((Existence)P.getPattern()).getP().getName() + " AND ¬(" + ((AfterLuntilR)P.getScope()).getR().getName() +
		"))))";
	}
	
	private String generateUniversalityGlobal(Property P) {
	       
		return "[]" + ((Universality)P.getPattern()).getP().getName();
	}
	
	private String generateUniversalityBeforeR(Property P) {
	       
		return "<>" + ((BeforeR)P.getScope()).getR().getName() + "->(" + ((Universality)P.getPattern()).getP().getName() + "U" +
		((BeforeR)P.getScope()).getR().getName() + ")";
	}
	
	private String generateUniversalityBetweenLandR(Property P) {
	       
		return "[]((" + ((BetweenLandR)P.getScope()).getL().getName() + " AND ¬(" + ((BetweenLandR)P.getScope()).getR().getName() + ") AND <>" +
		((BetweenLandR)P.getScope()).getR().getName() + ")->(" + ((Universality)P.getPattern()).getP().getName() + "U" + ((BetweenLandR)P.getScope()).getR().getName() +
		"))";
	}
	
	private String generatePrecedenceBeforeR(Property P) {
	       
		return "<>" + ((BeforeR)P.getScope()).getR().getName() + "->(¬(" + ((Precedence)P.getPattern()).getP().getName() + ")U(" + 
		((Precedence)P.getPattern()).getQ().getName() + " OR " + ((BeforeR)P.getScope()).getR().getName() + "))";
	}
	
	private String generatePrecedenceBetweenLandR(Property P) {
	       
		return "[]((" + ((BetweenLandR)P.getScope()).getL().getName() + " AND ¬(" + ((BetweenLandR)P.getScope()).getR().getName() + ") AND <>" + 
		((BetweenLandR)P.getScope()).getR().getName() + ")->(¬(" + ((Precedence)P.getPattern()).getP().getName() + ")U((" + ((Precedence)P.getPattern()).getQ().getName() +
		" OR " + ((BetweenLandR)P.getScope()).getR().getName() + ")))";
	}
	
	private String generateStrictPrecedenceBeforeR(Property P) {
	       
		return "<>" + ((BeforeR)P.getScope()).getR().getName() + "->(¬(" + ((StrictPrecedence)P.getPattern()).getP().getName() + ")U((" + 
		((StrictPrecedence)P.getPattern()).getQ().getName() + " AND ¬(" + ((StrictPrecedence)P.getPattern()).getP().getName() + ")) OR " + 
		((BeforeR)P.getScope()).getR().getName() + "))";
	}
	
	private String generateResponseGlobal(Property P) {
	       
		return "[](" + ((Response)P.getPattern()).getP().getName() + "-><>" + ((Response)P.getPattern()).getQ().getName() + ")";
	}	
	
	public String getStringRepresentation(Property P)
	{
		if (P.getPattern() instanceof Universality)
		{
			if (P.getScope() instanceof Global)
				return this.generateUniversalityGlobal(P);
			else
			if (P.getScope() instanceof BetweenLandR)
				return this.generateUniversalityBetweenLandR(P);
			else
			if (P.getScope() instanceof BeforeR)
				return this.generateUniversalityBeforeR(P);
			else
			if (P.getScope() instanceof AfterLuntilR)
				return this.generateUniversalityAfterLuntilR(P);
			else
			if (P.getScope() instanceof AfterL)
				return this.generateUniversalityAfterL(P);
			else
				return "Error, invalid pattern or scope combination defined, did you extend scope and patterns?";
		}
		else
		if (P.getPattern() instanceof StrictPrecedence)
		{
			if (P.getScope() instanceof Global)
				return this.generateStrictPrecedenceGlobal(P);
			else
			if (P.getScope() instanceof BetweenLandR)
				return this.generateStrictPrecedenceBetweenLandR(P);
			else
			if (P.getScope() instanceof BeforeR)
				return this.generateStrictPrecedenceBeforeR(P);
			else
			if (P.getScope() instanceof AfterLuntilR)
				return this.generateStrictPrecedenceAfterLuntilR(P);
			else
			if (P.getScope() instanceof AfterL)
				return this.generateStrictPrecedenceAfterL(P);
			else
				return "Error, invalid pattern or scope combination defined, did you extend scope and patterns?";
		}
		else
		if (P.getPattern() instanceof Response)
		{
			if (P.getScope() instanceof Global)
				return this.generateResponseGlobal(P);
			else
			if (P.getScope() instanceof BetweenLandR)
				return this.generateResponseBetweenLandR(P);
			else
			if (P.getScope() instanceof BeforeR)
				return this.generateResponseBeforeR(P);
			else
			if (P.getScope() instanceof AfterLuntilR)
				return this.generateResponseAfterLuntilR(P);
			else
			if (P.getScope() instanceof AfterL)
				return this.generateResponseAfterL(P);
			else
			return "Error, invalid pattern or scope combination defined, did you extend scope and patterns?";
		}
		else	
		if (P.getPattern() instanceof Precedence)
		{
			if (P.getScope() instanceof Global)
				return this.generatePrecedenceGlobal(P);
			else
			if (P.getScope() instanceof BetweenLandR)
				return this.generatePrecedenceBetweenLandR(P);
			else
			if (P.getScope() instanceof BeforeR)
				return this.generatePrecedenceBeforeR(P);
			else
			if (P.getScope() instanceof AfterLuntilR)
				return this.generatePrecedenceAfterLuntilR(P);
			else
			if (P.getScope() instanceof AfterL)
				return this.generatePrecedenceAfterL(P);
			else
				return "Error, invalid pattern or scope combination defined, did you extend scope and patterns?";
		}
		else
		if (P.getPattern() instanceof Existence)
		{
			if (P.getScope() instanceof Global)
				return this.generateExistenceGlobal(P);
			else
			if (P.getScope() instanceof BetweenLandR)
				return this.generateExistenceBetweenLandR(P);
			else
			if (P.getScope() instanceof BeforeR)
				return this.generateExistenceBeforeR(P);
			else
			if (P.getScope() instanceof AfterLuntilR)
				return this.generateExistenceAfterLuntilR(P);
			else
			if (P.getScope() instanceof AfterL)
				return this.generateExistenceAfterL(P);
			else
				return "Error, invalid pattern or scope combination defined, did you extend scope and patterns?";
		}
		else
		if (P.getPattern() instanceof Absence)
		{
			if (P.getScope() instanceof Global)
				return this.generateAbsenceGlobal(P);
			else
			if (P.getScope() instanceof BetweenLandR)
				return this.generateAbsenceBetweenLandR(P);
			else
			if (P.getScope() instanceof BeforeR)
				return this.generateAbsenceBeforeR(P);
			else
			if (P.getScope() instanceof AfterLuntilR)
				return this.generateAbsenceAfterLuntilR(P);
			else
			if (P.getScope() instanceof AfterL)
				return this.generateAbsenceAfterL(P);
			else
				return "Error, invalid pattern or scope combination defined, did you extend scope and patterns?";
		}
		else
			return "Error, invalid pattern or scope combination defined, did you extend scope and patterns?";
	}
}
