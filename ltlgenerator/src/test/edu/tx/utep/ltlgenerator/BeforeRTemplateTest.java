package test.edu.tx.utep.ltlgenerator;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import edu.tx.utep.ltlgenerator.CPGenerator;
import edu.tx.utep.ltlgenerator.LTLGenerator;
import edu.tx.utep.ltlgenerator.OperatorGenerator;
import edu.tx.utep.ltlgenerator.factories.OperatorFactory;

public class BeforeRTemplateTest {

	private LTLGenerator ltlGenerator = new LTLGenerator();

	// generateLTLFormula(templateName, pProposition, qProposition, rProposition, lProposition)

//	@Test
//	public void testAbsenceOfPBeforeRc() throws Exception {
//		String output = ltlGenerator.generateLTLFormula("AbsenceOfPBeforeRc", "P_AtLeastOneC_3", "", "R_ParallelC_3", "");
//		assertEquals("!(((r1 ^ r2 ^ r3)) U (( [(p1 v p2 v p3) & [[!(r1 ^ r2 ^ r3) & [F(r1 ^ r2 ^ r3)]]]])))", output);
//	}

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

	
	private static final String ANDR = OperatorFactory.AND_R;
	private static final String AND_MINUSL = OperatorFactory.AND_MINUS_L;
	private static final String ANDL = OperatorFactory.AND_L;
	private CPGenerator cpGenerator = new CPGenerator();
	private OperatorGenerator operatorGenerator = new OperatorGenerator();
	@Test
	public void testAtLeastOneE() throws Exception {
		List<String> leftSides = cpGenerator.getCompositeProposition("P_ConsecutiveC_3");
		List<String> rightSides = cpGenerator.getCompositeProposition("R_ParallelC_3");
		//System.out.println(operatorGenerator.getAndedPropositions(ANDR, leftSides, rightSides));
	}

}
