package test.edu.tx.utep.ltlgenerator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.tx.utep.ltlgenerator.LTLGenerator;

public class AfterLTemplateTest {

	private LTLGenerator ltlGenerator = new LTLGenerator();

	// generateLTLFormula(templateName, pProposition, qProposition, rProposition, lProposition)
	// !((!L) U (L &l !Pg))

	@Test
	public void testAbsenceOfPAfterL() throws Exception {
		String output = ltlGenerator.generateLTLFormula("AbsenceOfPAfterL", "P_AtLeastOneC_4", "", "", "L_ConsecutiveC_3");
		assertEquals("!((!(l1 ^ X(l2 ^ X(l3)))) U (l1 ^ X(l2 ^ X([l3 & [!(G!(p1 v p2 v p3 v p4))]]))))", output);
	}
	
	@Test
	public void testExistenceOfPAfterL() throws Exception {
		String output = ltlGenerator.generateLTLFormula("ExistenceOfPAfterL", "P_AtLeastOneC_4", "", "", "L_ConsecutiveC_3");
		assertEquals("!((!(l1 ^ X(l2 ^ X(l3)))) U (l1 ^ X(l2 ^ X([l3 & [!(F(p1 v p2 v p3 v p4))]]))))", output);
	}
	
//	@Test
//	public void testQStrictlyPrecedesPcAfterL() throws Exception {
//		String output = ltlGenerator.generateLTLFormula("QStrictlyPrecedesPcAfterL", "P_AtLeastOneE_3", "Q_AtLeastOneH_3", "", "L_ConsecutiveC_3");
//		assertEquals("", output);
//	}
	
	@Test
	public void testQStrictlyPrecedesPeAfterL() throws Exception {
		String output = ltlGenerator.generateLTLFormula("QStrictlyPrecedesPeAfterL", "P_AtLeastOneE_3", "Q_AtLeastOneH_3", "", "L_ConsecutiveC_3");
		assertEquals("!((!(l1 ^ X(l2 ^ X(l3)))) U (l1 ^ X(l2 ^ X([l3 & [!(!((!([[(q1 v q2 v q3)] & [!((!p1 ^ !p2 ^ !p3) ^ X(p1 v p2 v p3))]])) U ((!p1 ^ !p2 ^ !p3) ^ X(p1 v p2 v p3))))]]))))", output);
	}
	
	@Test
	public void testGlobalQPrecedesPcAfterLStar() throws Exception {
		String output = ltlGenerator.generateLTLFormula("GlobalQPrecedesPcAfterL", "P_AtLeastOneE_3", "Q_AtLeastOneH_3", "", "L_ConsecutiveC_3");
		assertEquals("!((!(l1 ^ X(l2 ^ X(l3)))) U (l1 ^ X(l2 ^ X([l3 & [!(!((!([(q1 v q2 v q3) & [!(!p1 ^ !p2 ^ !p3) ^ ((!p1 ^ !p2 ^ !p3) U (p1 v p2 v p3))]])) U (!p1 ^ !p2 ^ !p3) ^ ((!p1 ^ !p2 ^ !p3) U (p1 v p2 v p3))))]]))))", output);
	}
	
	@Test
	public void testGlobalQPrecedesPcAfterLPlus() throws Exception {
		String output = ltlGenerator.generateLTLFormula("GlobalQPrecedesPcAfterL", "P_AtLeastOneE_3", "Q_ConsecutiveE_3", "", "L_ParallelC_3");
		assertEquals("!((!(l1 ^ l2 ^ l3)) U [(l1 ^ l2 ^ l3) & [!(!((!([(!q1 ^ !q2 ^ !q3) & [!(!p1 ^ !p2 ^ !p3) ^ ((!p1 ^ !p2 ^ !p3) U (p1 v p2 v p3))]] ^ ([(!q1 ^ !q2 ^ !q3) & [!(!p1 ^ !p2 ^ !p3) ^ ((!p1 ^ !p2 ^ !p3) U (p1 v p2 v p3))]] U ([q1 ^ !q2 ^ !q3 & [!(!p1 ^ !p2 ^ !p3) ^ ((!p1 ^ !p2 ^ !p3) U (p1 v p2 v p3))]] ^ X([q2 ^ !q3 & [!(!p1 ^ !p2 ^ !p3) ^ ((!p1 ^ !p2 ^ !p3) U (p1 v p2 v p3))]] ^ X(q3)))))) U (!p1 ^ !p2 ^ !p3) ^ ((!p1 ^ !p2 ^ !p3) U (p1 v p2 v p3))))]])", output);
	}
	
	@Test
	public void testGlobalQPrecedesPeAfterLStar() throws Exception {
		String output = ltlGenerator.generateLTLFormula("GlobalQPrecedesPeAfterL", "P_AtLeastOneE_3", "Q_AtLeastOneH_3", "", "L_ConsecutiveC_3");
		assertEquals("!((!(l1 ^ X(l2 ^ X(l3)))) U (l1 ^ X(l2 ^ X([l3 & [!(!((![(q1 v q2 v q3) & [!((!p1 ^ !p2 ^ !p3) ^ X(p1 v p2 v p3))]]) U ((!p1 ^ !p2 ^ !p3) ^ X(p1 v p2 v p3))))]]))))", output);
	}
	
	@Test
	public void testGlobalQPrecedesPeAfterLPlus() throws Exception {
		String output = ltlGenerator.generateLTLFormula("GlobalQPrecedesPeAfterL", "P_AtLeastOneE_3", "Q_ConsecutiveE_3", "", "L_ParallelC_3");
		assertEquals("!((!(l1 ^ l2 ^ l3)) U [(l1 ^ l2 ^ l3) & [!(!((![(!q1 ^ !q2 ^ !q3) & [!((!p1 ^ !p2 ^ !p3) ^ X(p1 v p2 v p3))]] ^ ([(!q1 ^ !q2 ^ !q3) & [!((!p1 ^ !p2 ^ !p3) ^ X(p1 v p2 v p3))]] U ([q1 ^ !q2 ^ !q3 & [!((!p1 ^ !p2 ^ !p3) ^ X(p1 v p2 v p3))]] ^ X([q2 ^ !q3 & [!((!p1 ^ !p2 ^ !p3) ^ X(p1 v p2 v p3))]] ^ X(q3))))) U ((!p1 ^ !p2 ^ !p3) ^ X(p1 v p2 v p3))))]])", output);
	}
	
}
