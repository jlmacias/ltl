package prospec.model.pattern;
import prospec.model.proposition.Proposition;


public class Response extends Pattern 
{

	Proposition Q;
	
	public Response(Proposition P, Proposition Q) 
	{
        this.P = P;
        this.Q = Q;
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
