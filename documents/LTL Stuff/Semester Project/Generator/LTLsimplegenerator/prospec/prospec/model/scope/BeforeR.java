package prospec.model.scope;
import prospec.model.proposition.Proposition;


public class BeforeR extends Scope {

	private Proposition R;	
     
    public BeforeR(Proposition R) {
        this.R = R;
    }
    
    public Proposition getR() {
        return R;
    }
    
    public void setR(Proposition R)
    {
    	this.R=R;
    }
	   
}
