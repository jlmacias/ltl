package prospec.model.property;
import prospec.model.pattern.Existence;
import prospec.model.pattern.Pattern;
import prospec.model.pattern.Response;
import prospec.model.proposition.Atomic;
import prospec.model.proposition.Proposition;
import prospec.model.scope.BeforeR;
import prospec.model.scope.AfterL;
import prospec.model.scope.BetweenLandR;
import prospec.model.scope.Scope;


public class Property extends Object {

	String Name;
	String Description;
	String Assumptions;	
	Scope scope;
	Pattern pattern;
	
	Proposition[] associatedPropositions;

	public Property(String name, String description, String assumptions) {
		Name = name;
		Description = description;
		Assumptions = assumptions;
	}
	public Property(Scope scope, Pattern pattern)
	{
		this.scope = scope;
		this.pattern = pattern;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getAssumptions() {
		return Assumptions;
	}

	public void setAssumptions(String assumptions) {
		Assumptions = assumptions;
	}

	public Scope getScope() {
	    /*//Step 1 Test 1 and 3
	    String nameL = "L";
	    String nameR = "R";
	    String description = "none";
	    Proposition l = new Proposition(nameL, description);
	    Proposition r = new Proposition(nameR, description);      
	    Scope scope = new BetweenLandR(l, r);
	    System.out.println("Scope: " + scope.getScopeType());*/
	    /*//Step 1 Test 2
        scope = new Scope() {
        };*/
	    /*//Step 2 (A,B,D) Test 1 and 3 //Step 3 (A, B, C, D, E) Test 1 and 2 //Step 4 (A,B,C,D,E,F) Test 1 and 2
        String nameR = "R";
        String description = "none";
        Proposition r = new Proposition(nameR, description);      
        Scope scope = new BeforeR(r);
        System.out.println("Scope: " + scope.getScopeType());*/
        /*//Step 2 (A,B,D) Test 2
        scope = new Scope() {
        };*/
       //Step 5 (A,B,C,D,E,F,G) Test 1
        String nameL = "L";
        String description = "none";
        Proposition l = new Proposition(nameL, description);      
        Scope scope = new AfterL(l);
        System.out.println("Scope: " + scope.getScopeType());
		return scope;
	}
	
    
	
	public void setScope(Scope scope) {
		this.scope = scope;
	}

	public Pattern getPattern() {
	    /*//Step 1 Test 1 and 2
	    String nameP = "P";
	    String nameQ = "Q";
	    String description = "none";
	    Proposition p = new Atomic(nameP, description, true);
	    Proposition q = new Proposition(nameQ, description);
	    Pattern pattern = new Response(p, q);
	    System.out.println("Pattern: " + pattern.getPatternType());
	    */
	    /*//Step 1 Test 3
	    pattern = new Pattern();*/
	    /*//Step 2 (A, B, C) Test 1 and 2
	    String nameP = "P";
        String description = "none";
        Proposition p = new Atomic(nameP, description, true);
        Pattern pattern = new Existence(p);
        System.out.println("Pattern: " + pattern.getPatternType());*/
	    /*//Step 2 (A, B, C) Test 3
        pattern = new Pattern();*/
	    /*//Step 3 (A, B, C, D, E) Test 1
	    String nameP = "P";
        String description = "none";
        Proposition p = new Atomic(nameP, description, true);
        Pattern pattern = new Existence(p);
        System.out.println("Pattern: " + pattern.getPatternType());
        System.out.println("Propositions: " + p.getPropositionType());*/
        /*//Step 3 (A, B, C, D, E) Test 2
	    String nameP = "P";
        String description = "none";
        Proposition p = new Proposition(nameP, description);
        Pattern pattern = new Existence(p);
        System.out.println("Pattern: " + pattern.getPatternType());
        System.out.println("Propositions: " + p.getPropositionType());*/
        /*//Step 4 (A, B, C, D, E, F) Test 1
	    String nameP = "P";
        String description = "none";
        Proposition p = new Atomic(nameP, description, true);
        Pattern pattern = new Existence(p);
        System.out.println("Pattern: " + pattern.getPatternType());
        System.out.println("Propositions: " + p.getPropositionType());
        System.out.println("Atomic Polarity: " + ((Atomic) p).getPolarity());*/
        /*//Step 4 (A, B, C, D, E, F) Test 2
	    String nameP = "P";
        String description = "none";
        Proposition p = new Atomic(nameP, description, false);
        Pattern pattern = new Existence(p);
        System.out.println("Pattern: " + pattern.getPatternType());
        System.out.println("Propositions: " + p.getPropositionType());
        System.out.println("Atomic Polarity: " + ((Atomic) p).getPolarity());*/
       //Step 5 (A, B, C, D, E, F, G) Test 1
	    String nameP = "P";
        String description = "none";
        Proposition p = new Atomic(nameP, description, true);
        Pattern pattern = new Existence(p);
        System.out.println("Pattern: " + pattern.getPatternType());
        System.out.println("Propositions: " + p.getPropositionType());
        System.out.println("Atomic Polarity: " + ((Atomic) p).getPolarity());
	    return pattern;
	}
	
	public void setPattern(Pattern pattern) {
		this.pattern = pattern;
	}

	public Proposition[] getAssociatedPropositions() {
		return associatedPropositions;
	}

	public void setAssociatedPropositions(Proposition[] associatedPropositions) {
		this.associatedPropositions = associatedPropositions;
	}
	
	public Property getDeepCopy(){
		String copyName = this.getName();
		String copyDescription = this.getDescription();
		String copyAssumption = this.getAssumptions();
		Property copy;
		copy = new Property(copyName, copyDescription, copyAssumption);
		copy.setPattern(this.getPattern());
		copy.setScope(this.getScope());
		return copy;
	}
}
