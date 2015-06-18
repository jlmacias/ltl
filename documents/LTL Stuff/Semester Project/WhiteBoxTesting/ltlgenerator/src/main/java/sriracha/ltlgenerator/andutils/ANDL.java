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
public class ANDL extends ANDUtils {

    public ANDL() {
    }
    
    
    private String replaceforANDL(String right, String left){
        return left.replaceAll("\\.(?!.*\\.)", "&"+right);
    }
    
    public String replaceAllforANDL(String formula){
  
        while (formula.contains("&l")){
            
            int pos = formula.indexOf("&l");
            int posleft = this.manageleft(formula, pos);
            int posright = this.manageright(formula, pos);
            
            String substringleft = formula.substring(posleft,pos);
            String substringright = formula.substring(pos+2, posright+1);
            
            String toReplace = this.replaceforANDL(substringright, substringleft);
            
            String substring = formula.substring(posleft, posright+1);
            formula = formula.replace(substring, toReplace);
        }
        
        return formula;
    }

}
