package prospec.model.pattern;

import prospec.model.proposition.Proposition;

public class Pattern 
{	
	protected Proposition P;
	
	public String getPatternType()
	{
		if (this instanceof Absence)
		{
			return "Absence";
		}
		else if (this instanceof Existence)
		{
			return "Existence";
		}
		else if (this instanceof Precedence)
		{
			return "Precedence";
		}
		else if (this instanceof Response)
		{
			return "Response";
		}
		else if (this instanceof StrictPrecedence)
		{
			return "StrictPrecedence";
		}
		else if (this instanceof Universality)
		{
			return "Universality";
		}	
		else 
			return "Undefined";
	}

	public Proposition getP() 
	{
		return P;
	}
	
	public void setP(Proposition P)
	{
		this.P=P;
	}
}
