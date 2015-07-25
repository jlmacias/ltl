package test.edu.tx.utep.ltlgenerator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.tx.utep.ltlgenerator.LTLGenerator;

public class GlobalTemplateTest {
	
	private LTLGenerator ltlGenerator = new LTLGenerator();


	@Test
	public void testGlobalAbsenceOfP() throws Exception {
		String output = ltlGenerator.generateLTLFormula("GlobalAbsenceOfP", "P_AtLeastOneC_4", "", "", "");
		assertEquals("G!(p1 v p2 v p3 v p4)", output);
	}

	@Test
	public void testGlobalExistanceOfP() throws Exception {
		String output = ltlGenerator.generateLTLFormula("GlobalExistanceOfP", "P_AtLeastOneC_4", "", "", "");
		assertEquals("F(p1 v p2 v p3 v p4)", output);
	}

	@Test
	public void testGlobalQRespondsToP() throws Exception {
		String output = ltlGenerator.generateLTLFormula("GlobalQRespondsToP", "P_AtLeastOneE_3", "Q_AtLeastOneH_3", "", "");
					//G((!p1 ^ !p2 ^ !p3) ^ ((!p1 ^ !p2 ^ !p3) U [(p1 v p2 v p3) & [F(q1 v q2 v q3)]]) -> ((!p1 ^ !p2 ^ !p3) ^ ((!p1 ^ !p2 ^ !p3) U [(p1 v p2 v p3) & [F(q1 v q2 v q3)]]))))
		assertEquals("G((!p1 ^ !p2 ^ !p3) ^ ((!p1 ^ !p2 ^ !p3) U (p1 v p2 v p3)) -> ((!p1 ^ !p2 ^ !p3) ^ ((!p1 ^ !p2 ^ !p3) U [(p1 v p2 v p3) & [F((q1 v q2 v q3))]]))))", output);
	}
	
	/********/
	
	// Q can be anything BUT AtLeastOneC or ParallelC, and P has to be conditional type

	@Test
    public void testGlobalQPrecedesPCPlus() throws Exception {
       	String output = ltlGenerator.generateLTLFormula("GlobalQPrecedesPC", "Q_ConsecutiveC_3", "P_ParallelC_3", "","");
        assertEquals("!((!([q1 & [(!p1 ^ !p2 ^ !p3)]] ^ X([q2 & [(!p1 ^ !p2 ^ !p3)]] ^ X(q3)))) U (p1 ^ p2 ^ p3))", output);
    }

    // Q can be anything BUT AtLeastOneC or ParallelC, and P has to be event type
    @Test
    public void testGlobalQPrecedesPEPlus() throws Exception {
        String output = ltlGenerator.generateLTLFormula("GlobalQPrecedesPE", "Q_ConsecutiveC_3", "P_AtLeastOneE_3", "","");
        assertEquals("!((!([q1 & [!(!p1 ^ !p2 ^ !p3 ^ X(p1 v p2 v p3))]] ^ X([q2 & [!(!p1 ^ !p2 ^ !p3 ^ X(p1 v p2 v p3))]] ^ X(q3)))) U (!p1 ^ !p2 ^ !p3 ^ X(p1 v p2 v p3)))", output);
    }


    @Test
	public void testGlobalQPrecedesPCStarWithQAtLeastOneC() throws Exception {
		String output = ltlGenerator.generateLTLFormula("GlobalQPrecedesPC", "P_AtLeastOneC_2", "Q_AtLeastOneC_2", "", "");
		assertEquals("!((!(q1 v q2)) U ((p1 v p2) ^ !(q1 v q2)))", output);
	}
    
    @Test
	public void testGlobalQPrecedesPCStarWithQParallelC() throws Exception {
		String output = ltlGenerator.generateLTLFormula("GlobalQPrecedesPC", "P_AtLeastOneC_2", "Q_ParallelC_2", "", "");
		assertEquals("!((!(q1 ^ q2)) U ((p1 v p2) ^ !(q1 ^ q2)))", output);
	}

    @Test
	public void testGlobalQPrecedesPCPlusAtLeastOneH() throws Exception {
		String output = ltlGenerator.generateLTLFormula("GlobalQPrecedesPC", "P_AtLeastOneH_2", "Q_AtLeastOneH_2", "", "");
		assertEquals("!((!([(q1 v q2) & [!(p1 v p2)]])) U (p1 v p2))", output);
	}
    
    @Test
	public void testGlobalQPrecedesPCConsecutiveE() throws Exception {
		String output = ltlGenerator.generateLTLFormula("GlobalQPrecedesPC", "P_ConsecutiveE_2", "Q_ConsecutiveE_2", "", "");
		assertEquals("!((!([(!q1 ^ !q2) & [!(!p1 ^ !p2) ^ ((!p1 ^ !p2) U (p1 ^ !p2 ^ X(p2)))]] ^ ([(!q1 ^ !q2) & [!(!p1 ^ !p2) ^ ((!p1 ^ !p2) U (p1 ^ !p2 ^ X(p2)))]] U ([q1 ^ !q2 & [!(!p1 ^ !p2) ^ ((!p1 ^ !p2) U (p1 ^ !p2 ^ X(p2)))]] ^ X(q2))))) U (!p1 ^ !p2) ^ ((!p1 ^ !p2) U (p1 ^ !p2 ^ X(p2))))", output);
	}
    
    @Test
    public void testGlobalQPrecedesPCEventualAndConsecutiveE() throws Exception {
		String output = ltlGenerator.generateLTLFormula("GlobalQPrecedesPC", "P_EventualE_3", "Q_ConsecutiveE_3", "", "");
		assertEquals("!((!([(!q1 ^ !q2 ^ !q3) & [!(!p1 ^ !p2 ^ !p3) ^ ((!p1 ^ !p2 ^ !p3) U (p1 ^ !p2 ^ !p3 ^ ((!p2 ^ !p3) U (p2 ^ !p3 ^ ((!p3) U (p3))))))]] ^ ([(!q1 ^ !q2 ^ !q3) & [!(!p1 ^ !p2 ^ !p3) ^ ((!p1 ^ !p2 ^ !p3) U (p1 ^ !p2 ^ !p3 ^ ((!p2 ^ !p3) U (p2 ^ !p3 ^ ((!p3) U (p3))))))]] U ([q1 ^ !q2 ^ !q3 & [!(!p1 ^ !p2 ^ !p3) ^ ((!p1 ^ !p2 ^ !p3) U (p1 ^ !p2 ^ !p3 ^ ((!p2 ^ !p3) U (p2 ^ !p3 ^ ((!p3) U (p3))))))]] ^ X([q2 ^ !q3 & [!(!p1 ^ !p2 ^ !p3) ^ ((!p1 ^ !p2 ^ !p3) U (p1 ^ !p2 ^ !p3 ^ ((!p2 ^ !p3) U (p2 ^ !p3 ^ ((!p3) U (p3))))))]] ^ X(q3)))))) U (!p1 ^ !p2 ^ !p3) ^ ((!p1 ^ !p2 ^ !p3) U (p1 ^ !p2 ^ !p3 ^ ((!p2 ^ !p3) U (p2 ^ !p3 ^ ((!p3) U (p3)))))))", output);
	}
    


}
