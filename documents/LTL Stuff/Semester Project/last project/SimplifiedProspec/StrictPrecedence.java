package prospec.model.pattern;
import prospec.model.proposition.Proposition;


public class StrictPrecedence extends Pattern {

	Proposition Q;
	
    public StrictPrecedence(Proposition P, Proposition Q) 
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

