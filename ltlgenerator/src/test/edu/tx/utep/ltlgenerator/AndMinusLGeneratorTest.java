package test.edu.tx.utep.ltlgenerator;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import edu.tx.utep.ltlgenerator.CPGenerator;
import edu.tx.utep.ltlgenerator.OperatorGenerator;
import edu.tx.utep.ltlgenerator.factories.OperatorFactory;

public class AndMinusLGeneratorTest {

	private static final String AND_MINUSL = OperatorFactory.AND_MINUS_L;

	private CPGenerator cpGenerator = new CPGenerator();
	private OperatorGenerator operatorGenerator = new OperatorGenerator();

	@Test
	public void testAtLeastOneC() throws Exception {
		List<String> leftSides = cpGenerator.getCompositeProposition2("L_AtLeastOneC_3");
		List<String> rightSides = cpGenerator.getCompositeProposition2("P_AtLeastOneH_3");
		String output = operatorGenerator.getAndedPropositions(AND_MINUSL, leftSides, rightSides);
		assertEquals("[(l1 v l2 v l3) & [(p1 v p2 v p3)]]", output);
	}

	@Test
	public void testAtLeastOneE() throws Exception {
		List<String> leftSides = cpGenerator.getCompositeProposition2("L_AtLeastOneE_3");
		List<String> rightSides = cpGenerator.getCompositeProposition2("P_AtLeastOneH_3");
		String output = operatorGenerator.getAndedPropositions(AND_MINUSL, leftSides, rightSides);
		assertEquals("[(!l1 ^ !l2 ^ !l3) & [(p1 v p2 v p3)]] ^ ([(!l1 ^ !l2 ^ !l3) & [(p1 v p2 v p3)]] U (l1 v l2 v l3))", output);
	}

	@Test
	public void testParallelC() throws Exception {
		List<String> leftSides = cpGenerator.getCompositeProposition2("L_ParallelC_3");
		List<String> rightSides = cpGenerator.getCompositeProposition2("P_ParallelH_3");
		String output = operatorGenerator.getAndedPropositions(AND_MINUSL, leftSides, rightSides);
		assertEquals("[(l1 ^ l2 ^ l3) & [(p1 ^ p2 ^ p3)]]", output);
	}

	@Test
	public void testParallelE() throws Exception {
		List<String> leftSides = cpGenerator.getCompositeProposition2("R_ParallelE_3");
		List<String> rightSides = cpGenerator.getCompositeProposition2("P_ParallelH_3");
		String output = operatorGenerator.getAndedPropositions(AND_MINUSL, leftSides, rightSides);
		assertEquals("[(!r1 ^ !r2 ^ !r3) & [(p1 ^ p2 ^ p3)]] ^ ([(!r1 ^ !r2 ^ !r3) & [(p1 ^ p2 ^ p3)]] U (r1 ^ r2 ^ r3))", output);
	}

	@Test
	public void testConsecutiveC() throws Exception {
		List<String> leftSides = cpGenerator.getCompositeProposition2("L_ConsecutiveC_3");
		List<String> rightSides = cpGenerator.getCompositeProposition2("P_ParallelH_3");
		String output = operatorGenerator.getAndedPropositions(AND_MINUSL, leftSides, rightSides);
		assertEquals("([l1 & [(p1 ^ p2 ^ p3)]] ^ X([l2 & [(p1 ^ p2 ^ p3)]] ^ X(l3)))", output);
	}

	@Test
	public void testConsecutiveE() throws Exception {
		List<String> leftSides = cpGenerator.getCompositeProposition2("L_ConsecutiveE_3");
		List<String> rightSides = cpGenerator.getCompositeProposition2("P_ParallelC_3");
		String output = operatorGenerator.getAndedPropositions(AND_MINUSL, leftSides, rightSides);
		assertEquals("[(!l1 ^ !l2 ^ !l3) & [(p1 ^ p2 ^ p3)]] ^ ([(!l1 ^ !l2 ^ !l3) & [(p1 ^ p2 ^ p3)]] U ([l1 ^ !l2 ^ !l3 & [(p1 ^ p2 ^ p3)]] ^ X([l2 ^ !l3 & [(p1 ^ p2 ^ p3)]] ^ X(l3))))", output);
	}
	
	/***updated July 11**/
	@Test
	public void testAtLeastOneH() throws Exception {
		List<String> leftSides = cpGenerator.getCompositeProposition2("L_AtLeastOneC_3");
		List<String> rightSides = cpGenerator.getCompositeProposition2("P_AtLeastOneH_3");
		String output = operatorGenerator.getAndedPropositions(AND_MINUSL, leftSides, rightSides);
		assertEquals("[(l1 v l2 v l3) & [(p1 v p2 v p3)]]", output);
	}
	
	@Test
	public void testParallelH() throws Exception {
		List<String> leftSides = cpGenerator.getCompositeProposition2("L_ParallelC_3");
		List<String> rightSides = cpGenerator.getCompositeProposition2("P_ParallelH_3");
		String output = operatorGenerator.getAndedPropositions(AND_MINUSL, leftSides, rightSides);
		assertEquals("[(l1 ^ l2 ^ l3) & [(p1 ^ p2 ^ p3)]]", output);
	}
	
	@Test
	public void testConsecutiveH() throws Exception {
		List<String> leftSides = cpGenerator.getCompositeProposition2("L_ConsecutiveE_3");
		List<String> rightSides = cpGenerator.getCompositeProposition2("P_ParallelC_3");
		String output = operatorGenerator.getAndedPropositions(AND_MINUSL, leftSides, rightSides);
		assertEquals("(l1 ^ !l2 ^ [!l3 & [(p1 ^ p2 ^ p3)]] ^ X(l2 ^ [!l3 & [(p1 ^ p2 ^ p3)]] ^ Xl3))", output);
	}
	
	@Test
	public void testEventualC() throws Exception {
		List<String> leftSides = cpGenerator.getCompositeProposition2("L_ConsecutiveE_3");
		List<String> rightSides = cpGenerator.getCompositeProposition2("P_ParallelC_3");
		String output = operatorGenerator.getAndedPropositions(AND_MINUSL, leftSides, rightSides);
		assertEquals("([l1 & [(p1 ^ p2 ^ p3)]] ^ X([!l2 & [(p1 ^ p2 ^ p3)]] U ([l2 & [(p1 ^ p2 ^ p3)]] ^ X([!l3 & [(p1 ^ p2 ^ p3)]] U l3))))", output);
	}
	
	@Test
	public void testEventualE() throws Exception {
		List<String> leftSides = cpGenerator.getCompositeProposition2("L_ConsecutiveE_3");
		List<String> rightSides = cpGenerator.getCompositeProposition2("P_ParallelC_3");
		String output = operatorGenerator.getAndedPropositions(AND_MINUSL, leftSides, rightSides);
		assertEquals("[(!l1 ^ !l2 ^ !l3) & [(p1 ^ p2 ^ p3)]] ^ ([(!l1 ^ !l2 ^ !l3) & [(p1 ^ p2 ^ p3)]] U ([l1 ^ !l2 ^ !l3 & [(p1 ^ p2 ^ p3)]] ^ (([!l2 ^ !l3 & [(p1 ^ p2 ^ p3)]]) U ([l2 ^ !l3 & [(p1 ^ p2 ^ p3)]] ^ ([!l3 & [(p1 ^ p2 ^ p3)]] U l3)))))", output);
	}
	
	@Test
	public void testEventualH() throws Exception {
		List<String> leftSides = cpGenerator.getCompositeProposition2("L_ConsecutiveE_3");
		List<String> rightSides = cpGenerator.getCompositeProposition2("P_ParallelC_3");
		String output = operatorGenerator.getAndedPropositions(AND_MINUSL, leftSides, rightSides);
		assertEquals("([l1 ^ !l2 ^ !l3 & [(p1 ^ p2 ^ p3)]] ^ ([(!l2 ^ !l3) & [(p1 ^ p2 ^ p3)]] U ([l2 ^ !l3 & [(p1 ^ p2 ^ p3)]] ^ ([(!l3) & [(p1 ^ p2 ^ p3)]] U l3))))", output);
	}
	

}
