package test.edu.tx.utep.ltlgenerator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import edu.tx.utep.ltlgenerator.LTLGenerator;

public class BetweenLAndRcTest {
    private LTLGenerator ltlGenerator = new LTLGenerator();

    @Test // 1
    public void testAbsenceOfPBetweenLAndRc() throws Exception {
        String output = ltlGenerator.generateLTLFormula("AbsenceOfPBetweenLAndRc", "P_AtLeastOneC_3", "Q_ParallelC_3", "R_ParallelC_3", "L_ConsecutiveC_3");
        assertEquals("G((l1 ^ X(l2 ^ X([l3 & [!(r1 ^ r2 ^ r3)]]))) -> (l1 ^ X(l2 ^ X[([l3 & [!(r1 ^ r2 ^ r3)]] & [G!(p1 v p2 v p3)]]))))", output);
    }

    @Test // 2
    public void testExistenceOfPBetweenLAndRc() throws Exception {
        String output = ltlGenerator.generateLTLFormula("ExistenceOfPBetweenLAndRc", "P_AtLeastOneC_3", "Q_ParallelC_3", "R_ParallelC_3", "L_ConsecutiveC_3");
        assertEquals("G((l1 ^ X(l2 ^ X([l3 & [!(r1 ^ r2 ^ r3)]]))) -> (l1 ^ X(l2 ^ X[([l3 & [!(r1 ^ r2 ^ r3)]] & [F(p1 v p2 v p3)]]))))", output);
    }

    @Test // 3
    public void testQPrecedesPcBetweenLAndRc() throws Exception {
        String output = ltlGenerator.generateLTLFormula("QPrecedesPcBetweenLAndRc", "P_AtLeastOneC_3", "Q_ParallelC_3", "R_ParallelC_3", "L_ConsecutiveC_3");
        assertEquals("G((l1 ^ X(l2 ^ X([l3 & [!(r1 ^ r2 ^ r3)]]))) -> (l1 ^ X(l2 ^ X[([l3 & [!(r1 ^ r2 ^ r3)]] & [!((!(q1 ^ q2 ^ q3)) U ((p1 v p2 v p3) ^ !(q1 ^ q2 ^ q3)))]]))))", output);
    }

    @Test // 4
    public void testQPrecedesPeBetweenLAndRc() throws Exception {
        String output = ltlGenerator.generateLTLFormula("QPrecedesPeBetweenLAndRc", "P_AtLeastOneC_3", "Q_ParallelE_3", "R_ParallelC_3", "L_ConsecutiveC_3");
        assertEquals("G((l1 ^ X(l2 ^ X([l3 & [!(r1 ^ r2 ^ r3)]]))) -> (l1 ^ X(l2 ^ X[([l3 & [!(r1 ^ r2 ^ r3)]] & [!((!([(!q1 ^ !q2 ^ !q3) & [!((!p1 ^ !p2 ^ !p3) ^ X(p1 v p2 v p3))]] ^ ([(!q1 ^ !q2 ^ !q3) & [!((!p1 ^ !p2 ^ !p3) ^ X(p1 v p2 v p3))]] U (q1 ^ q2 ^ q3)))) U ((!p1 ^ !p2 ^ !p3) ^ X(p1 v p2 v p3)))]]))))", output);
    }

    @Test // 5
    public void testQStrictlyPrecedesPcBetweenLAndRc() throws Exception {
        String output = ltlGenerator.generateLTLFormula("QStrictlyPrecedesPcBetweenLAndRc", "P_AtLeastOneC_3", "Q_ParallelE_3", "R_ParallelC_3", "L_ConsecutiveC_3");
        assertEquals("G((l1 ^ X(l2 ^ X([l3 & [!(r1 ^ r2 ^ r3)]]))) -> (l1 ^ X(l2 ^ X[([l3 & [!(r1 ^ r2 ^ r3)]] & [!((!([[(!q1 ^ !q2 ^ !q3) ^ ((!q1 ^ !q2 ^ !q3) U (q1 ^ q2 ^ q3))] & [!(p1 v p2 v p3)]])) U (p1 v p2 v p3))]]))))", output);
    }

    @Test // 6
    public void testQStrictlyPrecedesPeBetweenLAndRc() throws Exception {
        String output = ltlGenerator.generateLTLFormula("QStrictlyPrecedesPeBetweenLAndRc", "P_AtLeastOneC_3", "Q_ParallelE_3", "R_ParallelC_3", "L_ConsecutiveC_3");
        assertEquals("G((l1 ^ X(l2 ^ X([l3 & [!(r1 ^ r2 ^ r3)]]))) -> (l1 ^ X(l2 ^ X[([l3 & [!(r1 ^ r2 ^ r3)]] & [!((!([[(!q1 ^ !q2 ^ !q3) ^ ((!q1 ^ !q2 ^ !q3) U (q1 ^ q2 ^ q3))] & [!((!p1 ^ !p2 ^ !p3) ^ X(p1 v p2 v p3))]])) U ((!p1 ^ !p2 ^ !p3) ^ X(p1 v p2 v p3)))]]))))", output);
    }

    @Test // 7
    public void testQRespondsToPBetweenLAndRc() throws Exception {
        String output = ltlGenerator.generateLTLFormula("QRespondsToPBetweenLAndRc", "P_AtLeastOneC_3", "Q_ParallelE_3", "R_ParallelC_3", "L_ConsecutiveC_3");
        assertEquals("G((l1 ^ X(l2 ^ X([l3 & [!(r1 ^ r2 ^ r3)]]))) -> (l1 ^ X(l2 ^ X[([l3 & [!(r1 ^ r2 ^ r3)]] & [G((p1 v p2 v p3) -> ([(p1 v p2 v p3) & [F((!q1 ^ !q2 ^ !q3) ^ ((!q1 ^ !q2 ^ !q3) U (q1 ^ q2 ^ q3)))]])))]]))))", output);
    }

}
