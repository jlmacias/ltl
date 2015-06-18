/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sriracha.ltlgenerator.scope;

/**
 * 
 * 
 */
public class Scope {
    
    public String betweenLANDR = "G(([L]&l![R])->([L]&l[P]))";
    public String L;
    public String R;
    public String P;
    public String Q;

    public Scope(String L, String R, String P, String Q) {
        this.L = L;
        this.R = R;
        this.P = P;
        this.Q = Q;
    }

    public String getFormulaBetweenLANDR(){
       betweenLANDR = betweenLANDR.replace("[L]", this.L).replace("[R]", this.R).replace("[P]", this.P); 
       return  betweenLANDR;
    }
    
    
}
