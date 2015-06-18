package prospec.model.pattern;
import prospec.model.proposition.Proposition;


public class Precedence extends Pattern 
{

	protected Proposition Q;
	
	public Precedence(Proposition P, Proposition Q) 
	{
        this.P = P;
        this.P = Q;
    }
    
    
    public Proposition getQ() 
    {
        return Q;
    }	 
    public void setQ(Proposition Q)
    {
    	this.Q = Q;
    }
}
