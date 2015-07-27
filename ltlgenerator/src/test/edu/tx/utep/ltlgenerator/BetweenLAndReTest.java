package test.edu.tx.utep.ltlgenerator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import edu.tx.utep.ltlgenerator.LTLGenerator;

public class BetweenLAndReTest {
    private LTLGenerator ltlGenerator = new LTLGenerator();

    @Test // 1
    public void testAbsenceOfPBetweenLAndRe() throws Exception {
        String output = ltlGenerator.generateLTLFormula("AbsenceOfPBetweenLAndRe", "P_AtLeastOneC_3", "Q_ParallelC_3", "R_ParallelC_3", "L_ConsecutiveC_3");
        assertEquals("G((l1 ^ X(l2 ^ X(l3))) -> (l1 ^ X(l2 ^ X([l3 & [G!(p1 v p2 v p3)]]))))", output);
    }

    @Test // 2
    public void testExistenceOfPBetweenLAndRe() throws Exception {
        String output = ltlGenerator.generateLTLFormula("ExistenceOfPBetweenLAndRe", "P_AtLeastOneC_3", "Q_ParallelC_3", "R_ParallelC_3", "L_ConsecutiveC_3");
        assertEquals("G((l1 ^ X(l2 ^ X(l3))) -> (l1 ^ X(l2 ^ X([l3 & [F(p1 v p2 v p3)]]))))", output);
    }

    @Test // 3
    public void testQPrecedesPcBetweenLAndRe() throws Exception {
        String output = ltlGenerator.generateLTLFormula("QPrecedesPcBetweenLAndRe", "P_AtLeastOneC_3", "Q_ParallelC_3", "R_ParallelC_3", "L_ConsecutiveC_3");
        assertEquals("G((l1 ^ X(l2 ^ X(l3))) -> (l1 ^ X(l2 ^ X([l3 & [!((!(q1 ^ q2 ^ q3)) U ((p1 v p2 v p3) ^ !(q1 ^ q2 ^ q3)))]]))))", output);
    }

    @Test // 4
    public void testQPrecedesPeBetweenLAndRe() throws Exception {
        String output = ltlGenerator.generateLTLFormula("QPrecedesPeBetweenLAndRe", "P_AtLeastOneC_3", "Q_ParallelE_3", "R_ParallelC_3", "L_ConsecutiveC_3");
        assertEquals("G((l1 ^ X(l2 ^ X(l3))) -> (l1 ^ X(l2 ^ X([l3 & [!((!([(!q1 ^ !q2 ^ !q3) & [!((!p1 ^ !p2 ^ !p3) ^ X(p1 v p2 v p3))]] ^ ([(!q1 ^ !q2 ^ !q3) & [!((!p1 ^ !p2 ^ !p3) ^ X(p1 v p2 v p3))]] U (q1 ^ q2 ^ q3)))) U ((!p1 ^ !p2 ^ !p3) ^ X(p1 v p2 v p3)))]]))))", output);
    }

    @Test // 5
    public void testQStrictlyPrecedesPcBetweenLAndRe() throws Exception {
        String output = ltlGenerator.generateLTLFormula("QStrictlyPrecedesPcBetweenLAndRe", "P_AtLeastOneC_3", "Q_ParallelE_3", "R_ParallelC_3", "L_ConsecutiveC_3");
        assertEquals("G((l1 ^ X(l2 ^ X(l3))) -> (l1 ^ X(l2 ^ X([l3 & [!((!([[(!q1 ^ !q2 ^ !q3) ^ ((!q1 ^ !q2 ^ !q3) U (q1 ^ q2 ^ q3))] & [!(p1 v p2 v p3)]])) U (p1 v p2 v p3))]]))))", output);
    }

    @Test // 6
    public void testQStrictlyPrecedesPeBetweenLAndRe() throws Exception {
        String output = ltlGenerator.generateLTLFormula("QStrictlyPrecedesPeBetweenLAndRe", "P_AtLeastOneC_3", "Q_ParallelE_3", "R_ParallelC_3", "L_ConsecutiveC_3");
        assertEquals("G((l1 ^ X(l2 ^ X(l3))) -> (l1 ^ X(l2 ^ X([l3 & [!((!([[(!q1 ^ !q2 ^ !q3) ^ ((!q1 ^ !q2 ^ !q3) U (q1 ^ q2 ^ q3))] & [!((!p1 ^ !p2 ^ !p3) ^ X(p1 v p2 v p3))]])) U ((!p1 ^ !p2 ^ !p3) ^ X(p1 v p2 v p3)))]]))))", output);
    }

    @Test // 7
    public void testQRespondsToPBetweenLAndRe() throws Exception {
        String output = ltlGenerator.generateLTLFormula("QRespondsToPBetweenLAndRe", "P_AtLeastOneC_3", "Q_ParallelE_3", "R_ParallelC_3", "L_ConsecutiveC_3");
        assertEquals("G((l1 ^ X(l2 ^ X(l3))) -> (l1 ^ X(l2 ^ X([l3 & [G((p1 v p2 v p3) -> ([(p1 v p2 v p3) & [F((!q1 ^ !q2 ^ !q3) ^ ((!q1 ^ !q2 ^ !q3) U (q1 ^ q2 ^ q3)))]])))]]))))", output);
    }
}
