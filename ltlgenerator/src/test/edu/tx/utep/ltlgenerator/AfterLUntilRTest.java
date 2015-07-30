package test.edu.tx.utep.ltlgenerator;

import edu.tx.utep.ltlgenerator.LTLGenerator;
import static org.junit.Assert.assertEquals;

import edu.tx.utep.ltlgenerator.templates.afterl.AfterLUntilRe;
import edu.tx.utep.ltlgenerator.templates.beforer.ExistenceOfPBeforeRe;
import edu.tx.utep.ltlgenerator.templates.global.GlobalAbsenceOfP;
import org.junit.Test;

public class AfterLUntilRTest {

    private LTLGenerator ltlGenerator = new LTLGenerator();


//    @Test
//    public void testAfterLUntilRC() throws Exception {
//        AfterLUntilRc cons = new AfterLUntilRc(new GlobalAbsenceOfP(),new ExistenceOfPBeforeRe());
//        String output = ltlGenerator.generateLTLFormula("AfterLUntilRC", "","","","");
//        assertEquals("G((L &l !R) -> (L &l ((PR ^ ((!FR) -> PG)))))", output);
//    }

    @Test
    public void testAfterLUntilRE() throws Exception {
        AfterLUntilRe cons = new AfterLUntilRe(new GlobalAbsenceOfP(),new ExistenceOfPBeforeRe());
        String output = cons.generateFormula(
                "P_ParallelE_2",
                "Q_EventualC_3",
                "R_ConsecutiveE_2",
                "L_AtLeastOneC_3"
        );


        assertEquals("G((l1 v l2 v l3) -> ([(l1 v l2 v l3) & [(((F(!r1 ^ !r2) ^ ((!r1 ^ !r2) U (r1 ^ !r2 ^ X(r2)))) -> ((!(((!r1 ^ !r2) ^ X((r1 ^ !r2 ^ X(r2))))) U [[(!p1 ^ !p2) ^ ((!p1 ^ !p2) U (p1 ^ p2))] & [!(r1 ^ !r2 ^ X(r2))]] ^ ((!F((!r1 ^ !r2) ^ ((!r1 ^ !r2) U (r1 ^ !r2 ^ X(r2))))) -> G!((!p1 ^ !p2) ^ ((!p1 ^ !p2) U (p1 ^ p2))))))]]))", output);

    }

}


