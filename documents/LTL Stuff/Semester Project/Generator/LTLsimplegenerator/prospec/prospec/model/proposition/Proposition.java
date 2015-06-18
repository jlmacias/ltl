package prospec.model.proposition;

public class Proposition {
	
	protected String name;
	protected String description;
		
	public Proposition(String name, String description) 
	{
		this.name = name;
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getPropositionType()
	{
	    if (this instanceof Atomic)
        {
            return "Atomic";
        }
	    /*if (this instanceof AtLeastOneC)
		{
			return "AtLeastOneC";
		}
		else if (this instanceof AtLeastOneE)
		{
			return "AtLeastOneE";
		}
		else if (this instanceof Atomic)
		{
			return "Atomic";
		}
		else if (this instanceof ConsecutiveC)
		{
			return "ConsecutiveC";
		}
		else if (this instanceof ConsecutiveE)
		{
			return "ConsecutiveE";
		}
		else if (this instanceof EventualC)
		{
			return "EventualC";
		}	
		else if (this instanceof EventualE)
		{
			return "EventualE";
		}	
		else if (this instanceof ParallelC)
		{
			return "ParallelC";
		}
		else if (this instanceof ParallelE)
		{
			return "ParallelE";
		}
		else if (this instanceof Incomplete)
		{
			return "Incomplete";
		}	
		else if (this instanceof CompositePropositions)
		{
			return "CompositePropositions";
		}*/
		else if (this instanceof Proposition)
		{
			return "Proposition";
		}
		else 
			return "Undefined";
	}
}
