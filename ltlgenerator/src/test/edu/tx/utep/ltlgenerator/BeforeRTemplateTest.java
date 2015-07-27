package test.edu.tx.utep.ltlgenerator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.tx.utep.ltlgenerator.LTLGenerator;

public class BeforeRTemplateTest {

	private LTLGenerator ltlGenerator = new LTLGenerator();

	// generateLTLFormula(templateName, pProposition, qProposition, rProposition, lProposition)

	@Test
	public void testAbsenceOfPBeforeRc() throws Exception {
		String output = ltlGenerator.generateLTLFormula("AbsenceOfPBeforeRc", "P_AtLeastOneC_3", "", "R_ParallelC_3", "");
		assertEquals("!((!(r1 ^ r2 ^ r3)) U ([[(p1 v p2 v p3)] & [!(r1 ^ r2 ^ r3) & [F(r1 ^ r2 ^ r3)]]]))", output);
	}

	@Test
	public void testAbsenceOfPBeforeRe() throws Exception {
		String output = ltlGenerator.generateLTLFormula("AbsenceOfPBeforeRe", "P_AtLeastOneC_3", "", "R_ParallelC_3", "");
		assertEquals("(F(r1 ^ r2 ^ r3)) -> !((!(((!p1 ^ !p2 ^ !p3)) ^ X((r1 ^ r2 ^ r3)))) U [[(p1 v p2 v p3)] & [!(r1 ^ r2 ^ r3)]])", output);
	}

	@Test
	public void testExistenceOfPBeforeRc() throws Exception {
		String output = ltlGenerator.generateLTLFormula("ExistenceOfPBeforeRc", "P_ConsecutiveC_4", "", "R_ParallelC_3", "");
		assertEquals("!((![[(p1 ^ X(p2 ^ X(p3 ^ X(p4))))] & [!(r1 ^ r2 ^ r3)]]) U (r1 ^ r2 ^ r3))", output);
	}

	@Test
	public void testExistenceOfPBeforeRe() throws Exception {
		String output = ltlGenerator.generateLTLFormula("ExistenceOfPBeforeRe", "P_ConsecutiveC_4", "", "R_ParallelC_3", "");
		assertEquals("(F(r1 ^ r2 ^ r3)) -> ((!(((!r1 ^ !r2 ^ !r3) ^ X((r1 ^ r2 ^ r3)))) U [[(p1 ^ X(p2 ^ X(p3 ^ X(p4))))] & [!(r1 ^ r2 ^ r3)]]", output);
	}

	@Test
	public void testQPrecedesPcBeforeRe() throws Exception {
		String output = ltlGenerator.generateLTLFormula("QPrecedesPcBeforeRe", "P_ConsecutiveC_4", "Q_ConsecutiveE_2", "R_ParallelC_3", "");
		assertEquals("(F(r1 ^ r2 ^ r3)) -> (((![[(p1 ^ X(p2 ^ X(p3 ^ X(p4))))] & [!(r1 ^ r2 ^ r3)]]) U ([(!q1 ^ !q2) & [!(p1 ^ X(p2 ^ X(p3 ^ X(p4))))]] ^ ([(!q1 ^ !q2) & [!(p1 ^ X(p2 ^ X(p3 ^ X(p4))))]] U ([q1 ^ !q2 & [!(p1 ^ X(p2 ^ X(p3 ^ X(p4))))]] ^ X(q2))) v (((!r1 ^ !r2 ^ !r3)) ^ X(r1 ^ r2 ^ r3)))))", output);
	}

	@Test
	public void testQPrecedesPcBeforeRc() throws Exception {
		String output = ltlGenerator.generateLTLFormula("QPrecedesPcBeforeRc", "P_ConsecutiveC_4", "Q_ConsecutiveE_2", "R_ParallelC_3", "");
		assertEquals("(F(r1 ^ r2 ^ r3)) -> ((![[(p1 ^ X(p2 ^ X(p3 ^ X(p4))))] & [!(r1 ^ r2 ^ r3)]])) U ([(!q1 ^ !q2) & [!(p1 ^ X(p2 ^ X(p3 ^ X(p4))))]] ^ ([(!q1 ^ !q2) & [!(p1 ^ X(p2 ^ X(p3 ^ X(p4))))]] U ([q1 ^ !q2 & [!(p1 ^ X(p2 ^ X(p3 ^ X(p4))))]] ^ X(q2))) v (r1 ^ r2 ^ r3))))", output);
	}
	
	@Test
	public void testQPrecedesPeBeforeRc() throws Exception {
		String output = ltlGenerator.generateLTLFormula("QPrecedesPeBeforeRc", "P_ConsecutiveE_3", "Q_ParallelE_3", "R_ParallelC_3", "");
		assertEquals("(F (r1 ^ r2 ^ r3)) -> ((!(((!p1 ^ !p2 ^ !p3)) ^ !(r1 ^ r2 ^ r3) ^ X([[(p1 ^ !p2 ^ !p3 ^ X(p2 ^ !p3 ^ X(p3)))] & [!(r1 ^ r2 ^ r3)]]))) U (([(!q1 ^ !q2 ^ !q3) & [!(p1 ^ !p2 ^ !p3 ^ X(p2 ^ !p3 ^ X(p3)))]] ^ ([(!q1 ^ !q2 ^ !q3) & [!(p1 ^ !p2 ^ !p3 ^ X(p2 ^ !p3 ^ X(p3)))]] U (q1 ^ q2 ^ q3))) v (r1 ^ r2 ^ r3)))", output);
	}
	
	@Test
	public void testQPrecedesPeBeforeRe() throws Exception {
		String output = ltlGenerator.generateLTLFormula("QPrecedesPeBeforeRe", "P_ConsecutiveE_3", "Q_ParallelE_3", "R_ParallelE_3", "");
		assertEquals("(F (!r1 ^ !r2 ^ !r3) ^ ((!r1 ^ !r2 ^ !r3) U (r1 ^ r2 ^ r3))) -> ((!(((!p1 ^ !p2 ^ !p3)) ^ !(r1 ^ r2 ^ r3) ^ X([[(p1 ^ !p2 ^ !p3 ^ X(p2 ^ !p3 ^ X(p3)))] & [!(r1 ^ r2 ^ r3)]]))) U (([(!q1 ^ !q2 ^ !q3) & [!(p1 ^ !p2 ^ !p3 ^ X(p2 ^ !p3 ^ X(p3)))]] ^ ([(!q1 ^ !q2 ^ !q3) & [!(p1 ^ !p2 ^ !p3 ^ X(p2 ^ !p3 ^ X(p3)))]] U (q1 ^ q2 ^ q3))) v (((!r1 ^ !r2 ^ !r3)) ^ X (r1 ^ r2 ^ r3) )))", output);
	}
	
	@Test
	public void testQRespondsToPBeforeRc() throws Exception {
		String output = ltlGenerator.generateLTLFormula("QRespondsToPBeforeRc", "P_ConsecutiveE_3", "Q_ParallelE_3", "R_ParallelC_3", "");
		assertEquals("!((!(r1 ^ r2 ^ r3)) U ([[(!p1 ^ !p2 ^ !p3) ^ ((!p1 ^ !p2 ^ !p3) U (p1 ^ !p2 ^ !p3 ^ X(p2 ^ !p3 ^ X(p3))))] & [!(r1 ^ r2 ^ r3) & [((!([[(!q1 ^ !q2 ^ !q3) ^ ((!q1 ^ !q2 ^ !q3) U (q1 ^ q2 ^ q3))] & [!(r1 ^ r2 ^ r3)]])) U (r1 ^ r2 ^ r3))]]]))", output);
	}
	
	@Test
	public void testQRespondsToPBeforeRc_EventualC() throws Exception {
		String output = ltlGenerator.generateLTLFormula("QRespondsToPBeforeRc", "P_ConsecutiveE_3", "Q_EventualE_3", "R_EventualC_3", "");
		assertEquals("!((!(r1 ^ X(!r2 U (r2 ^ X(!r3 U (r3)))))) U ([[(!p1 ^ !p2 ^ !p3) ^ ((!p1 ^ !p2 ^ !p3) U (p1 ^ !p2 ^ !p3 ^ X(p2 ^ !p3 ^ X(p3))))] & [!(r1 ^ X(!r2 U (r2 ^ X(!r3 U (r3) & [((!([[(!q1 ^ !q2 ^ !q3) ^ ((!q1 ^ !q2 ^ !q3) U (q1 ^ !q2 ^ !q3 ^ ((!q2 ^ !q3) U (q2 ^ !q3 ^ ((!q3) U (q3))))))] & [!(r1 ^ X(!r2 U (r2 ^ X(!r3 U (r3)))))]])) U (r1 ^ X(!r2 U (r2 ^ X(!r3 U (r3))))))]))))]]))", output);
	}
	
	@Test
	public void testQRespondsToPBeforeRe() throws Exception {
		String output = ltlGenerator.generateLTLFormula("QRespondsToPBeforeRe", "P_ConsecutiveE_3", "Q_ParallelE_3", "R_EventualE_3", "");
		assertEquals("!((!(((!r1 ^ !r2 ^ !r3) ^ ((!r1 ^ !r2 ^ !r3) U (r1 ^ !r2 ^ !r3 ^ ((!r2 ^ !r3) U (r2 ^ !r3 ^ ((!r3) U (r3))))))) ^ X((r1 ^ !r2 ^ !r3 ^ ((!r2 ^ !r3) U (r2 ^ !r3 ^ ((!r3) U (r3)))))))) U ([[(!p1 ^ !p2 ^ !p3) ^ ((!p1 ^ !p2 ^ !p3) U (p1 ^ !p2 ^ !p3 ^ X(p2 ^ !p3 ^ X(p3))))] & [!(r1 ^ !r2 ^ !r3 ^ ((!r2 ^ !r3) U (r2 ^ !r3 ^ ((!r3) U (r3) & [((!([[(!q1 ^ !q2 ^ !q3) ^ ((!q1 ^ !q2 ^ !q3) U (q1 ^ q2 ^ q3))] & [!(r1 ^ !r2 ^ !r3 ^ ((!r2 ^ !r3) U (r2 ^ !r3 ^ ((!r3) U (r3)))))]])) U (r1 ^ !r2 ^ !r3 ^ ((!r2 ^ !r3) U (r2 ^ !r3 ^ ((!r3) U (r3))))) )]))))]]))", output);
	}
	
	@Test
	public void testQRespondsToPBeforeReEventualE() throws Exception {
		String output = ltlGenerator.generateLTLFormula("QRespondsToPBeforeRe", "P_ParallelE_3", "Q_EventualE_3", "R_EventualE_3", "");
		assertEquals("!((!(((!r1 ^ !r2 ^ !r3) ^ ((!r1 ^ !r2 ^ !r3) U (r1 ^ !r2 ^ !r3 ^ ((!r2 ^ !r3) U (r2 ^ !r3 ^ ((!r3) U (r3))))))) ^ X((r1 ^ !r2 ^ !r3 ^ ((!r2 ^ !r3) U (r2 ^ !r3 ^ ((!r3) U (r3)))))))) U ([[(!p1 ^ !p2 ^ !p3) ^ ((!p1 ^ !p2 ^ !p3) U (p1 ^ p2 ^ p3))] & [!(r1 ^ !r2 ^ !r3 ^ ((!r2 ^ !r3) U (r2 ^ !r3 ^ ((!r3) U (r3) & [((!([[(!q1 ^ !q2 ^ !q3) ^ ((!q1 ^ !q2 ^ !q3) U (q1 ^ !q2 ^ !q3 ^ ((!q2 ^ !q3) U (q2 ^ !q3 ^ ((!q3) U (q3))))))] & [!(r1 ^ !r2 ^ !r3 ^ ((!r2 ^ !r3) U (r2 ^ !r3 ^ ((!r3) U (r3)))))]])) U (r1 ^ !r2 ^ !r3 ^ ((!r2 ^ !r3) U (r2 ^ !r3 ^ ((!r3) U (r3))))) )]))))]]))", output);
	}

	@Test
	public void testQStrictlyPrecedesPcBeforeRc() throws Exception {
		String output = ltlGenerator.generateLTLFormula("QStrictlyPrecedesPcBeforeRc", "P_ConsecutiveC_3", "Q_EventualE_3", "R_ParallelH_3", "");
		assertEquals("(F(r1 ^ r2 ^ r3)) -> ((!([[(p1 ^ X(p2 ^ X(p3)))] & [!(r1 ^ r2 ^ r3)]])) U (([[(!q1 ^ !q2 ^ !q3) ^ ((!q1 ^ !q2 ^ !q3) U (q1 ^ !q2 ^ !q3 ^ ((!q2 ^ !q3) U (q2 ^ !q3 ^ ((!q3) U (q3))))))] & [!(p1 ^ X(p2 ^ X(p3)))]]) v (r1 ^ r2 ^ r3)))", output);
	}

	@Test
	public void testQStrictlyPrecedesPeBeforeRc() throws Exception {
		String output = ltlGenerator.generateLTLFormula("QStrictlyPrecedesPeBeforeRc", "P_ConsecutiveC_3", "Q_EventualE_3", "R_ParallelH_3", "");
		assertEquals("(F(r1 ^ r2 ^ r3)) -> ((!((!p1 ^ !p2 ^ !p3) ^ !(r1 ^ r2 ^ r3) ^ X([[(p1 ^ !p2 ^ !p3 ^ X(p2 ^ !p3 ^ X(p3)))] & [!(r1 ^ r2 ^ r3)]]))) U (([[(!q1 ^ !q2 ^ !q3) ^ ((!q1 ^ !q2 ^ !q3) U (q1 ^ !q2 ^ !q3 ^ ((!q2 ^ !q3) U (q2 ^ !q3 ^ ((!q3) U (q3))))))] & [!(p1 ^ !p2 ^ !p3 ^ X(p2 ^ !p3 ^ X(p3)))]]) v (r1 ^ r2 ^ r3)))", output);
	}

	@Test
	public void testQStrictlyPrecedesPcBeforeRe() throws Exception {
		String output = ltlGenerator.generateLTLFormula("QStrictlyPrecedesPcBeforeRe", "P_ConsecutiveC_3", "Q_EventualE_3", "R_ParallelH_3", "");
		assertEquals("(F(r1 ^ r2 ^ r3)) -> (((!([[(p1 ^ X(p2 ^ X(p3)))] & [!(r1 ^ r2 ^ r3)]])) U (([[(!q1 ^ !q2 ^ !q3) ^ ((!q1 ^ !q2 ^ !q3) U (q1 ^ !q2 ^ !q3 ^ ((!q2 ^ !q3) U (q2 ^ !q3 ^ ((!q3) U (q3))))))] & [!(p1 ^ X(p2 ^ X(p3)))]]) v ((!r1 ^ !r2 ^ !r3) ^ X(r1 ^ r2 ^ r3)))))", output);
	}

	@Test
	public void testQStrictlyPrecedesPeBeforeRe() throws Exception {
		String output = ltlGenerator.generateLTLFormula("QStrictlyPrecedesPeBeforeRe", "P_ConsecutiveC_3", "Q_EventualE_3", "R_ParallelH_3", "");
		assertEquals("(F(r1 ^ r2 ^ r3)) -> ((!((!p1 ^ !p2 ^ !p3) ^ !(r1 ^ r2 ^ r3) ^ X([[(p1 ^ !p2 ^ !p3 ^ X(p2 ^ !p3 ^ X(p3)))] & [!(r1 ^ r2 ^ r3)]]))) U (([[(!q1 ^ !q2 ^ !q3) ^ ((!q1 ^ !q2 ^ !q3) U (q1 ^ !q2 ^ !q3 ^ ((!q2 ^ !q3) U (q2 ^ !q3 ^ ((!q3) U (q3))))))] & [!(p1 ^ !p2 ^ !p3 ^ X(p2 ^ !p3 ^ X(p3)))]]) v ((!r1 ^ !r2 ^ !r3) ^ X(r1 ^ r2 ^ r3))))", output);
	}

}
