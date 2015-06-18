package prospec.model.scope;

import prospec.model.scope.AfterL;
import prospec.model.scope.AfterLuntilR;
import prospec.model.scope.BeforeR;
import prospec.model.scope.BetweenLandR;
import prospec.model.scope.Global;

abstract public class Scope {
	
	public String getScopeType()
	{
		if (this instanceof AfterL)
		{
			return "After L";
		}
		else if (this instanceof AfterLuntilR)
		{
			return "After L until R";
		}
		else if (this instanceof BeforeR)
		{
			return "Before R";
		}
		else if (this instanceof BetweenLandR)
		{
			return "Between L and R";
		}
		else if (this instanceof Global)
		{
			return "Between L and R";
		}
		else 
			return "Undefined";
	}
}