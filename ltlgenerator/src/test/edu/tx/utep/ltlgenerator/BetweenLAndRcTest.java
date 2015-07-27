package test.edu.tx.utep.ltlgenerator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import edu.tx.utep.ltlgenerator.LTLGenerator;

public class BetweenLAndRcTest {
    private LTLGenerator ltlGenerator = new LTLGenerator();

    @Test
    public void testAbsenceOfPBetweenLAndRc() throws Exception {
        String output = ltlGenerator.generateLTLFormula("AbsenceOfPAfterL", "P_AtLeastOneC_4", "", "", "L_ConsecutiveC_3");
        assertEquals("!((!(l1 ^ X(l2 ^ X(l3)))) U (l1 ^ X(l2 ^ X([l3 & [!(G!(p1 v p2 v p3 v p4))]]))))", output);
    }

}
