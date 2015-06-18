package prospec.model.property;
import prospec.model.pattern.Pattern;
import prospec.model.proposition.Proposition;
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
		return scope;
	}
	
	public void setScope(Scope scope) {
		this.scope = scope;
	}

	public Pattern getPattern() {
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
