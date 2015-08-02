package test.edu.tx.utep.ltlgenerator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.tx.utep.ltlgenerator.LTLGenerator;

public class GlobalTemplateTest {

	private LTLGenerator ltlGenerator = new LTLGenerator();

	@Test
	public void testGlobalAbsenceOfP() throws Exception {
		String output = ltlGenerator.generateLTLFormula("GlobalAbsenceOfP", "P_AtLeastOneC_4", "", "", "");
		assertEquals("G!((p1 v p2 v p3 v p4))", output);
	}

	@Test
	public void testGlobalExistenceOfP() throws Exception {
		String output = ltlGenerator.generateLTLFormula("GlobalExistenceOfP", "P_AtLeastOneC_4", "", "", "");
		assertEquals("F(p1 v p2 v p3 v p4)", output);
	}

	@Test
	public void testGlobalQRespondsToP() throws Exception {
		String output = ltlGenerator.generateLTLFormula("GlobalQRespondsToP", "P_AtLeastOneE_3", "Q_AtLeastOneH_3", "", "");
		assertEquals("G((!p1 ^ !p2 ^ !p3) ^ ((!p1 ^ !p2 ^ !p3) U (p1 v p2 v p3)) -> ((!p1 ^ !p2 ^ !p3) ^ ((!p1 ^ !p2 ^ !p3) U [(p1 v p2 v p3) & [F((q1 v q2 v q3))]]))))", output);
	}

	// Q can be anything BUT AtLeastOneC or ParallelC, and P has to be conditional type
	@Test
	public void testGlobalQPrecedesPCPlus() throws Exception {
		String output = ltlGenerator.generateLTLFormula("GlobalQPrecedesPC", "P_ParallelC_3", "Q_ConsecutiveC_3", "", "");
		assertEquals("!((!(([q1 & [!(p1 ^ p2 ^ p3)]] ^ X([q2 & [!(p1 ^ p2 ^ p3)]] ^ X(q3))))) U (p1 ^ p2 ^ p3))", output);
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

	@Test
	public void testGlobalQStrictlyPrecedesPC() throws Exception {
		String output = ltlGenerator.generateLTLFormula("GlobalQStrictlyPrecedesPC", "P_ConsecutiveE_3", "Q_AtLeastOneH_4", "", "");
		assertEquals("!((!([[(q1 v q2 v q3 v q4)] & [!(!p1 ^ !p2 ^ !p3) ^ ((!p1 ^ !p2 ^ !p3) U (p1 ^ !p2 ^ !p3 ^ X(p2 ^ !p3 ^ X(p3))))]])) U (!p1 ^ !p2 ^ !p3) ^ ((!p1 ^ !p2 ^ !p3) U (p1 ^ !p2 ^ !p3 ^ X(p2 ^ !p3 ^ X(p3)))))", output);
	}

	@Test
	public void testGlobalQStrictlyPrecedesPE() throws Exception {
		String output = ltlGenerator.generateLTLFormula("GlobalQStrictlyPrecedesPE", "P_ConsecutiveE_3", "Q_AtLeastOneH_4", "", "");
		assertEquals("!((!([[(q1 v q2 v q3 v q4)] & [!((!p1 ^ !p2 ^ !p3) ^ X(p1 ^ !p2 ^ !p3 ^ X(p2 ^ !p3 ^ X(p3))))]])) U ((!p1 ^ !p2 ^ !p3) ^ X(p1 ^ !p2 ^ !p3 ^ X(p2 ^ !p3 ^ X(p3)))))", output);
	}

	@Test
	public void testGlobalQPrecedesPEStar() throws Exception {
		String output = ltlGenerator.generateLTLFormula("GlobalQPrecedesPEStar", "P_ParallelC_3", "Q_AtLeastOneC_3", "", "");
		assertEquals("!((!((q1 v q2 v q3) ^ !((!p1 ^ !p2 ^ !p3) ^ X(p1 ^ p2 ^ p3)))) U ((!p1 ^ !p2 ^ !p3) ^ X(p1 ^ p2 ^ p3) ^ !(q1 v q2 v q3)))", output);
	}
	
	@Test
	public void testGlobalQPrecedesPE() throws Exception {
		String output = ltlGenerator.generateLTLFormula("GlobalQPrecedesPE", "P_ParallelC_3", "Q_AtLeastOneC_3", "", "");
		assertEquals("!((!((q1 v q2 v q3) ^ !((!p1 ^ !p2 ^ !p3) ^ X(p1 ^ p2 ^ p3)))) U ((!p1 ^ !p2 ^ !p3) ^ X(p1 ^ p2 ^ p3) ^ !(q1 v q2 v q3)))", output);
	}

	@Test
	public void testGlobalQPrecedesPCStar() throws Exception {
		String output = ltlGenerator.generateLTLFormula("GlobalQPrecedesPCStar", "P_ParallelC_3", "Q_AtLeastOneC_3", "", "");
		assertEquals("!((!(q1 v q2 v q3)) U ((p1 ^ p2 ^ p3) ^ !(q1 v q2 v q3)))", output);
	}

	@Test
	public void testGlobalQPrecedesPEPlus() throws Exception {
		String output = ltlGenerator.generateLTLFormula("GlobalQPrecedesPCStar", "P_EventualC_3", "Q_ConsecutiveE_3", "", "");
		assertEquals("!((!(!q1 ^ !q2 ^ !q3) ^ ((!q1 ^ !q2 ^ !q3) U (q1 ^ !q2 ^ !q3 ^ X(q2 ^ !q3 ^ X(q3))))) U ((p1 ^ X(!p2 U (p2 ^ X(!p3 U (p3))))) ^ !(!q1 ^ !q2 ^ !q3) ^ ((!q1 ^ !q2 ^ !q3) U (q1 ^ !q2 ^ !q3 ^ X(q2 ^ !q3 ^ X(q3))))))", output);
	}

	@Test
	public void testGlobalQPrecedesPEStar2() throws Exception {
		String output = ltlGenerator.generateLTLFormula("GlobalQPrecedesPEStar", "P_EventualC_2", "Q_ConsecutiveE_2", "", "");
		assertEquals("!((!((!q1 ^ !q2) ^ ((!q1 ^ !q2) U (q1 ^ !q2 ^ X(q2))) ^ !((!p1 ^ !p2) ^ X(p1 ^ !p2 ^ ((!p2) U (p2)))))) U ((!p1 ^ !p2) ^ X(p1 ^ !p2 ^ ((!p2) U (p2))) ^ !(!q1 ^ !q2) ^ ((!q1 ^ !q2) U (q1 ^ !q2 ^ X(q2)))))", output);
	}

}
