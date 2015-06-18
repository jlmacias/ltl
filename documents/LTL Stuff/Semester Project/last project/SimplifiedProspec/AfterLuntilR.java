package prospec.model.scope;
import prospec.model.proposition.Proposition;


public class AfterLuntilR extends Scope {

	private Proposition L;
	private Proposition R;
	
	     
    public AfterLuntilR(Proposition L, Proposition R) {
        this.L = L;
        this.R = R;
    }
    
    public Proposition getL() {
        return L;
    }
    
    public Proposition getR() {
        return R;
    }
	   
    public void setL(Proposition L)
    {
    	this.L=L;
    }
    
    public void setR(Proposition R)
    {
    	this.R=R;
    }
}

