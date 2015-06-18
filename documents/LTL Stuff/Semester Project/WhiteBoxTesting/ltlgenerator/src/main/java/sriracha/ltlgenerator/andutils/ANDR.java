/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sriracha.ltlgenerator.andutils;

/**
 * 
 * 
 */
public class ANDR extends ANDUtils {

    public ANDR() {
    }
    
    
    private String replaceforANDR(String right, String left){
        return left.replaceAll("\\.", "&"+right);
    }
    
    
    public String replaceAllforANDR(String formula){
  
        while (formula.contains("&r")){
            
            int pos = formula.indexOf("&r");
            int posleft = this.manageleft(formula, pos);
            int posright = this.manageright(formula, pos);
            
            String substringleft = formula.substring(posleft,pos);
            String substringright = formula.substring(pos+2, posright+1);
            
            String toReplace = this.replaceforANDR(substringright, substringleft);
            
            String substring = formula.substring(posleft, posright+1);
            formula = formula.replace(substring, toReplace);
        }
        
        return formula;
    }

}
