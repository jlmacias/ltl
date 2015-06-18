package prospec.generator;
import prospec.model.pattern.Absence;
import prospec.model.pattern.Existence;
import prospec.model.pattern.Pattern;
import prospec.model.pattern.Precedence;
import prospec.model.pattern.Response;
import prospec.model.pattern.StrictPrecedence;
import prospec.model.pattern.Universality;
import prospec.model.property.Property;
import prospec.model.proposition.Proposition;
import prospec.model.proposition.Atomic;
import prospec.model.scope.AfterL;
import prospec.model.scope.AfterLuntilR;
import prospec.model.scope.BeforeR;
import prospec.model.scope.BetweenLandR;
import prospec.model.scope.Global;
import prospec.model.scope.Scope;
import prospec.generator.SimpleLTL_Generator;

public class Tester {
    public static void main(String[] args) {
        /*//Driver Step 1
        SimpleLTL_Generator generator = new SimpleLTL_Generator();
        Property property = new Property("name", "description", "assumptions");
        String outputString = generator.getStringRepresentation(property);
        System.out.println("Formula: " + outputString);*/
        /*//Driver Step 2 (A, B, C) Test 1 and 3
        String nameL = "L";
        String description = "none";
        Proposition l = new Proposition(nameL, description);
        Scope scope = new AfterL(l);
        System.out.println("Scope: " + scope.getScopeType());
        SimpleLTL_Generator generator = new SimpleLTL_Generator();
        Property property = new Property("name", "description", "assumptions");
        property.setScope(scope);
        System.out.println("Property Scope: " + property.getScope().getScopeType());
        String outputString = generator.getStringRepresentation(property);
        System.out.println("Formula: " + outputString);*/
        /* //Driver Step 2 (A, B, C) Test 2
        Scope scope = new Scope(){};
        System.out.println("Scope: " + scope.getScopeType());
        SimpleLTL_Generator generator = new SimpleLTL_Generator();
        Property property = new Property("name", "description", "assumptions");
        property.setScope(scope);
        System.out.println("Property Scope: " + property.getScope().getScopeType());
        String outputString = generator.getStringRepresentation(property);
        System.out.println("Formula: " + outputString);*/
        /*//Driver Step 2 (A, B, D) Test 1 and 2
        String nameP = "P";
        String description = "none";
        Proposition p = new Proposition(nameP, description);
        Pattern pattern = new Absence(p);
        System.out.println("Pattern: " + pattern.getPatternType());
        SimpleLTL_Generator generator = new SimpleLTL_Generator();
        Property property = new Property("name", "description", "assumptions");
        property.setPattern(pattern);
        System.out.println("Property pattern: " + property.getPattern().getPatternType());
        String outputString = generator.getStringRepresentation(property);
        System.out.println("Formula: " + outputString);*/
        /* //Driver Step 2 (A, B, D) Test 3
        Pattern pattern = new Pattern();
        System.out.println("Pattern: " + pattern.getPatternType());
        SimpleLTL_Generator generator = new SimpleLTL_Generator();
        Property property = new Property("name", "description", "assumptions");
        property.setPattern(pattern);
        System.out.println("Property pattern: " + property.getPattern().getPatternType());
        String outputString = generator.getStringRepresentation(property);
        System.out.println("Formula: " + outputString);*/
        /*//Driver Step 2 (A,B,C,D) Test 1
        Scope scope = new Global();
        String nameP = "P";
        String nameQ = "Q";
        String description = "none";
        Proposition p = new Proposition(nameP, description);
        Proposition q = new Proposition(nameQ, description);
        Pattern pattern = new Precedence(p, q);
        System.out.println("Pattern: " + pattern.getPatternType());
        System.out.println("Scope: " + scope.getScopeType());
        SimpleLTL_Generator generator = new SimpleLTL_Generator();
        Property property = new Property("name", "description", "assumptions");
        property.setScope(scope);
        property.setPattern(pattern);
        System.out.println("Property pattern: " + property.getPattern().getPatternType());
        System.out.println("Property scope: " + property.getScope().getScopeType());
        String outputString = generator.getStringRepresentation(property);
        System.out.println("Formula: " + outputString);*/
        /*//Driver Step 2 (A,B,C,D) Test 2
        Scope scope = new Scope(){};
        String nameP = "P";
        String nameQ = "Q";
        String description = "none";
        Proposition p = new Proposition(nameP, description);
        Proposition q = new Proposition(nameQ, description);
        Pattern pattern = new Precedence(p, q);
        System.out.println("Pattern: " + pattern.getPatternType());
        System.out.println("Scope: " + scope.getScopeType());
        SimpleLTL_Generator generator = new SimpleLTL_Generator();
        Property property = new Property("name", "description", "assumptions");
        property.setScope(scope);
        property.setPattern(pattern);
        System.out.println("Property pattern: " + property.getPattern().getPatternType());
        System.out.println("Property scope: " + property.getScope().getScopeType());
        String outputString = generator.getStringRepresentation(property);
        System.out.println("Formula: " + outputString);*/
        /*//Driver Step 2 (A,B,C,D) Test 3
        Scope scope = new Global();
        Pattern pattern = new Pattern();
        System.out.println("Pattern: " + pattern.getPatternType());
        System.out.println("Scope: " + scope.getScopeType());
        SimpleLTL_Generator generator = new SimpleLTL_Generator();
        Property property = new Property("name", "description", "assumptions");
        property.setScope(scope);
        property.setPattern(pattern);
        System.out.println("Property pattern: " + property.getPattern().getPatternType());
        System.out.println("Property scope: " + property.getScope().getScopeType());
        String outputString = generator.getStringRepresentation(property);
        System.out.println("Formula: " + outputString);*/
        //Driver Step 3 (A,B,C,D,E) Test 1 and 2     //Step 4 (A,B,C,D,E,F) Test 1 and 2
    	//Driver Step 5 (A,B,C,D,E,F,G) Test 1
        Scope scope = new Global();
        String nameP = "P";
        String nameQ = "Q";
        String description = "none";
        Proposition p = new Proposition(nameP, description);
        Proposition q = new Proposition(nameQ, description);
        Proposition[] associatedPropositions = new Proposition[2];
        Pattern pattern = new Precedence(p, q);
        System.out.println("Pattern: " + pattern.getPatternType());
        System.out.println("Scope: " + scope.getScopeType());
        SimpleLTL_Generator generator = new SimpleLTL_Generator();
        Property property = new Property("name", "description", "assumptions");
        property.setScope(scope);
        property.setPattern(pattern);
        associatedPropositions[0] = p;
        associatedPropositions[1] = q;
        property.setAssociatedPropositions(associatedPropositions);
        System.out.println("Property pattern: " + property.getPattern().getPatternType());
        System.out.println("Property scope: " + property.getScope().getScopeType());
        Proposition temp[] = property.getAssociatedPropositions();
        System.out.println("Propositions: " + temp[0].getPropositionType());
        String outputString = generator.getStringRepresentation(property);
        System.out.println("Formula: " + outputString);
        }
}
