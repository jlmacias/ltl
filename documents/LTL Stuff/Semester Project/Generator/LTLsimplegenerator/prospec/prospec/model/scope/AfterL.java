package prospec.model.scope;
import prospec.model.proposition.Proposition;


public class AfterL extends Scope {

	private Proposition L;	
	
    public AfterL(Proposition L) {
        this.L = L;
    }
    
    public Proposition getL() {
        return L;
    }
    
    public void setL(Proposition L)
    {
    	this.L=L;
    }	   
}
