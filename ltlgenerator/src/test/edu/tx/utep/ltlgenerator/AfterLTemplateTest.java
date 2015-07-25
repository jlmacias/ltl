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
	public void testExistanceOfPAfterL() throws Exception {
		String output = ltlGenerator.generateLTLFormula("ExistanceOfPAfterL", "P_AtLeastOneC_4", "", "", "L_ConsecutiveC_3");
		//(l1 ^ X(l2 ^ X(l3))) L_ConsecutiveC_3
		// G!(p1 v p2 v p3 v p4) "GlobalAbsenceOfP", "P_AtLeastOneC_4"
		// (l1 ^ X(l2 ^ X([l3 & [F(p1 v p2 v p3 v p4)]])))
		assertEquals("!((!(l1 ^ X(l2 ^ X(l3)))) U (l1 ^ X(l2 ^ X([l3 & [!(F(p1 v p2 v p3 v p4))]]))))", output);
	}
	
	@Test
	public void testQRespondsToPAfterL() throws Exception {
		String output = ltlGenerator.generateLTLFormula("QRespondsToPAfterL", "P_AtLeastOneE_3", "Q_AtLeastOneH_3", "", "L_ConsecutiveC_3");
		assertEquals("!((!(l1 ^ X(l2 ^ X(l3)))) U (l1 ^ X(l2 ^ X([l3 & [!(G((!p1 ^ !p2 ^ !p3) ^ ((!p1 ^ !p2 ^ !p3) U (p1 v p2 v p3)) -> ((!p1 ^ !p2 ^ !p3) ^ ((!p1 ^ !p2 ^ !p3) U [(p1 v p2 v p3) & [F((q1 v q2 v q3))]])))))]]))))", output);
	}
	
}
