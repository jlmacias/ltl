/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sriracha.ltlgenerator.pattern;

/**
 * 
 * 
 */
public class Pattern {

    public String reponse_beforeRc = "!((![R])U(([P]&r![R])&l((!([Q]&r![R]))U[R])))";
    public String L;
    public String R;
    public String P;
    public String Q;

    public Pattern(String L, String R, String P, String Q) {
        this.L = L;
        this.R = R;
        this.P = P;
        this.Q = Q;
    }
    
    public String getResponseBeforeRc(){
        
        reponse_beforeRc = reponse_beforeRc.replace("[R]", this.R).replace("[P]", this.P).replace("[Q]", this.Q);
        return reponse_beforeRc;
    }
    
}
