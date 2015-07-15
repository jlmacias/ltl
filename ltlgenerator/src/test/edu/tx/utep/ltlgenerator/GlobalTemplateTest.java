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

}
