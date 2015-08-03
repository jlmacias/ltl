package test.edu.tx.utep.ltlgenerator;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import edu.tx.utep.ltlgenerator.CPGenerator;
import edu.tx.utep.ltlgenerator.OperatorGenerator;
import edu.tx.utep.ltlgenerator.factories.OperatorFactory;

public class AndRGeneratorTest {

	private static final String ANDR = OperatorFactory.AND_R;

	private CPGenerator cpGenerator = new CPGenerator();
	private OperatorGenerator operatorGenerator = new OperatorGenerator();

	@Test
	public void testAtLeastOneC() throws Exception {       //same as At least one H
		List<String> leftSides = cpGenerator.getCompositeProposition("L_AtLeastOneC_3");
		List<String> rightSides = cpGenerator.getCompositeProposition("P_AtLeastOneH_3");
		String output = operatorGenerator.getAndedPropositions(ANDR, leftSides, rightSides);
		assertEquals("[(l1 v l2 v l3) & [(p1 v p2 v p3)]]", output);
	}

	@Test
	public void testAtLeastOneE() throws Exception {
		List<String> leftSides = cpGenerator.getCompositeProposition("L_AtLeastOneE_3");
		List<String> rightSides = cpGenerator.getCompositeProposition("P_AtLeastOneH_3");
		String output = operatorGenerator.getAndedPropositions(ANDR, leftSides, rightSides);
		assertEquals("[(!l1 ^ !l2 ^ !l3) & [(p1 v p2 v p3)]] ^ ([(!l1 ^ !l2 ^ !l3) & [(p1 v p2 v p3)]] U [(l1 v l2 v l3) & [(p1 v p2 v p3)]])", output);
	}

	@Test
	public void testParallelC() throws Exception {          //same as parallel H
		List<String> leftSides = cpGenerator.getCompositeProposition("L_ParallelC_3");
		List<String> rightSides = cpGenerator.getCompositeProposition("P_ParallelH_3");
		String output = operatorGenerator.getAndedPropositions(ANDR, leftSides, rightSides);
		assertEquals("[(l1 ^ l2 ^ l3) & [(p1 ^ p2 ^ p3)]]", output);
	}

	@Test
	public void testParallelE() throws Exception {
		List<String> leftSides = cpGenerator.getCompositeProposition("R_ParallelE_3");
		List<String> rightSides = cpGenerator.getCompositeProposition("P_ParallelH_3");
		String output = operatorGenerator.getAndedPropositions(ANDR, leftSides, rightSides);
		assertEquals("[(!r1 ^ !r2 ^ !r3) & [(p1 ^ p2 ^ p3)]] ^ ([(!r1 ^ !r2 ^ !r3) & [(p1 ^ p2 ^ p3)]] U [(r1 ^ r2 ^ r3) & [(p1 ^ p2 ^ p3)]])", output);
	}

	@Test//
	public void testConsecutiveC() throws Exception {
		List<String> leftSides = cpGenerator.getCompositeProposition("L_ConsecutiveC_3");
		List<String> rightSides = cpGenerator.getCompositeProposition("P_ParallelH_3");
		String output = operatorGenerator.getAndedPropositions(ANDR, leftSides, rightSides);
		assertEquals("([l1 & [(p1 ^ p2 ^ p3)]] ^ X([l2 & [(p1 ^ p2 ^ p3)]] ^ X([l3 & [(p1 ^ p2 ^ p3)]])))", output);
	}

	@Test                   //need consecutive h array list code to test
	public void testConsecutiveH() throws Exception {
		List<String> leftSides = cpGenerator.getCompositeProposition("L_ConsecutiveH_3");
		List<String> rightSides = cpGenerator.getCompositeProposition("P_ParallelC_3");
		String output = operatorGenerator.getAndedPropositions(ANDR, leftSides, rightSides);
		assertEquals("([l1 ^ !l2 ^ !l3 & [(p1 ^ p2 ^ p3)]] ^ X([l2 ^ !l3 & [(p1 ^ p2 ^ p3)]] ^ X([l3 & [(p1 ^ p2 ^ p3)]])))", output);
	}
	
	@Test
	public void testConsecutiveE() throws Exception {
		List<String> leftSides = cpGenerator.getCompositeProposition("L_ConsecutiveE_3");
		List<String> rightSides = cpGenerator.getCompositeProposition("P_ParallelC_3");
		String output = operatorGenerator.getAndedPropositions(ANDR, leftSides, rightSides);
		assertEquals("[(!l1 ^ !l2 ^ !l3) & [(p1 ^ p2 ^ p3)]] ^ ([(!l1 ^ !l2 ^ !l3) & [(p1 ^ p2 ^ p3)]] U ([l1 ^ !l2 ^ !l3 & [(p1 ^ p2 ^ p3)]] ^ X([l2 ^ !l3 & [(p1 ^ p2 ^ p3)]] ^ X[(l3) & [(p1 ^ p2 ^ p3)]])))", output);
	}

	@Test
	public void testEventualC() throws Exception {
		List<String> leftSides = cpGenerator.getCompositeProposition("L_EventualC_3");
		List<String> rightSides = cpGenerator.getCompositeProposition("P_ParallelC_3");
		String output = operatorGenerator.getAndedPropositions(ANDR, leftSides, rightSides);
		assertEquals("([l1 & [(p1 ^ p2 ^ p3)]] ^ X([!l2 & [(p1 ^ p2 ^ p3)]] U ([l2 & [(p1 ^ p2 ^ p3)]] ^ X([!l3 & [(p1 ^ p2 ^ p3)]] U ([l3 & [(p1 ^ p2 ^ p3)]])))))", output);
	}

	@Test
	public void testEventualH() throws Exception {         
		List<String> leftSides = cpGenerator.getCompositeProposition("L_EventualH_3");
		List<String> rightSides = cpGenerator.getCompositeProposition("P_ParallelC_3");
		String output = operatorGenerator.getAndedPropositions(ANDR, leftSides, rightSides);
		assertEquals("([l1 ^ !l2 ^ !l3 & [(p1 ^ p2 ^ p3)]] ^ ([(!l2 ^ !l3) & [(p1 ^ p2 ^ p3)]] U ([l2 ^ !l3 & [(p1 ^ p2 ^ p3)]] ^ ([(!l3) & [(p1 ^ p2 ^ p3)]] U ([l3 & [(p1 ^ p2 ^ p3)]])))))", output);
	}

	@Test
	public void testEventualE() throws Exception {
		List<String> leftSides = cpGenerator.getCompositeProposition("R_EventualE_3");
		List<String> rightSides = cpGenerator.getCompositeProposition("P_ParallelC_3");
		String output = operatorGenerator.getAndedPropositions(ANDR, leftSides, rightSides);
		assertEquals("[(!r1 ^ !r2 ^ !r3) & [(p1 ^ p2 ^ p3)]] ^ ([(!r1 ^ !r2 ^ !r3) & [(p1 ^ p2 ^ p3)]] U ([r1 ^ !r2 ^ !r3 & [(p1 ^ p2 ^ p3)]] ^ ([(!r2 ^ !r3) & [(p1 ^ p2 ^ p3)]] U ([r2 ^ !r3 & [(p1 ^ p2 ^ p3)]] ^ ([(!r3) & [(p1 ^ p2 ^ p3)]] U ([r3 & [(p1 ^ p2 ^ p3)]]))))))", output);
	}
	
	@Test
	public void testEventualEAtLeastOneE() throws Exception {
		List<String> leftSides = cpGenerator.getCompositeProposition("R_EventualE_3");
		List<String> rightSides = cpGenerator.getCompositeProposition("P_AtLeastOneE_3");
		String output = operatorGenerator.getAndedPropositions(ANDR, leftSides, rightSides);
		assertEquals("[(!r1 ^ !r2 ^ !r3) & [(!p1 ^ !p2 ^ !p3) ^ ((!p1 ^ !p2 ^ !p3) U (p1 v p2 v p3))]] ^ ([(!r1 ^ !r2 ^ !r3) & [(!p1 ^ !p2 ^ !p3) ^ ((!p1 ^ !p2 ^ !p3) U (p1 v p2 v p3))]] U ([r1 ^ !r2 ^ !r3 & [(!p1 ^ !p2 ^ !p3) ^ ((!p1 ^ !p2 ^ !p3) U (p1 v p2 v p3))]] ^ ([(!r2 ^ !r3) & [(!p1 ^ !p2 ^ !p3) ^ ((!p1 ^ !p2 ^ !p3) U (p1 v p2 v p3))]] U ([r2 ^ !r3 & [(!p1 ^ !p2 ^ !p3) ^ ((!p1 ^ !p2 ^ !p3) U (p1 v p2 v p3))]] ^ ([(!r3) & [(!p1 ^ !p2 ^ !p3) ^ ((!p1 ^ !p2 ^ !p3) U (p1 v p2 v p3))]] U ([r3 & [(!p1 ^ !p2 ^ !p3) ^ ((!p1 ^ !p2 ^ !p3) U (p1 v p2 v p3))]]))))))", output);
	}
	
	@Test
	public void testEventualEParallelE() throws Exception {
		List<String> leftSides = cpGenerator.getCompositeProposition("R_EventualE_3");
		List<String> rightSides = cpGenerator.getCompositeProposition("P_ParallelE_3");
		String output = operatorGenerator.getAndedPropositions(ANDR, leftSides, rightSides);
		assertEquals("[(!r1 ^ !r2 ^ !r3) & [(!p1 ^ !p2 ^ !p3) ^ ((!p1 ^ !p2 ^ !p3) U (p1 ^ p2 ^ p3))]] ^ ([(!r1 ^ !r2 ^ !r3) & [(!p1 ^ !p2 ^ !p3) ^ ((!p1 ^ !p2 ^ !p3) U (p1 ^ p2 ^ p3))]] U ([r1 ^ !r2 ^ !r3 & [(!p1 ^ !p2 ^ !p3) ^ ((!p1 ^ !p2 ^ !p3) U (p1 ^ p2 ^ p3))]] ^ ([(!r2 ^ !r3) & [(!p1 ^ !p2 ^ !p3) ^ ((!p1 ^ !p2 ^ !p3) U (p1 ^ p2 ^ p3))]] U ([r2 ^ !r3 & [(!p1 ^ !p2 ^ !p3) ^ ((!p1 ^ !p2 ^ !p3) U (p1 ^ p2 ^ p3))]] ^ ([(!r3) & [(!p1 ^ !p2 ^ !p3) ^ ((!p1 ^ !p2 ^ !p3) U (p1 ^ p2 ^ p3))]] U ([r3 & [(!p1 ^ !p2 ^ !p3) ^ ((!p1 ^ !p2 ^ !p3) U (p1 ^ p2 ^ p3))]]))))))", output);
	}
	
	
	@Test
	public void testEventualEConsecutiveE() throws Exception {
		List<String> leftSides = cpGenerator.getCompositeProposition("R_EventualE_3");
		List<String> rightSides = cpGenerator.getCompositeProposition("P_ConsecutiveE_3");
		String output = operatorGenerator.getAndedPropositions(ANDR, leftSides, rightSides);
		assertEquals("[(!r1 ^ !r2 ^ !r3) & [(!p1 ^ !p2 ^ !p3) ^ ((!p1 ^ !p2 ^ !p3) U (p1 ^ !p2 ^ !p3 ^ X(p2 ^ !p3 ^ X(p3))))]] ^ ([(!r1 ^ !r2 ^ !r3) & [(!p1 ^ !p2 ^ !p3) ^ ((!p1 ^ !p2 ^ !p3) U (p1 ^ !p2 ^ !p3 ^ X(p2 ^ !p3 ^ X(p3))))]] U ([r1 ^ !r2 ^ !r3 & [(!p1 ^ !p2 ^ !p3) ^ ((!p1 ^ !p2 ^ !p3) U (p1 ^ !p2 ^ !p3 ^ X(p2 ^ !p3 ^ X(p3))))]] ^ ([(!r2 ^ !r3) & [(!p1 ^ !p2 ^ !p3) ^ ((!p1 ^ !p2 ^ !p3) U (p1 ^ !p2 ^ !p3 ^ X(p2 ^ !p3 ^ X(p3))))]] U ([r2 ^ !r3 & [(!p1 ^ !p2 ^ !p3) ^ ((!p1 ^ !p2 ^ !p3) U (p1 ^ !p2 ^ !p3 ^ X(p2 ^ !p3 ^ X(p3))))]] ^ ([(!r3) & [(!p1 ^ !p2 ^ !p3) ^ ((!p1 ^ !p2 ^ !p3) U (p1 ^ !p2 ^ !p3 ^ X(p2 ^ !p3 ^ X(p3))))]] U ([r3 & [(!p1 ^ !p2 ^ !p3) ^ ((!p1 ^ !p2 ^ !p3) U (p1 ^ !p2 ^ !p3 ^ X(p2 ^ !p3 ^ X(p3))))]]))))))", output);
	}
	
	@Test
	public void testEventualEEventualC() throws Exception {
		List<String> leftSides = cpGenerator.getCompositeProposition("R_EventualE_3");
		List<String> rightSides = cpGenerator.getCompositeProposition("P_EventualC_3");
		String output = operatorGenerator.getAndedPropositions(ANDR, leftSides, rightSides);
		assertEquals("[(!r1 ^ !r2 ^ !r3) & [(p1 ^ X(!p2 U (p2 ^ X(!p3 U (p3)))))]] ^ ([(!r1 ^ !r2 ^ !r3) & [(p1 ^ X(!p2 U (p2 ^ X(!p3 U (p3)))))]] U ([r1 ^ !r2 ^ !r3 & [(p1 ^ X(!p2 U (p2 ^ X(!p3 U (p3)))))]] ^ ([(!r2 ^ !r3) & [(p1 ^ X(!p2 U (p2 ^ X(!p3 U (p3)))))]] U ([r2 ^ !r3 & [(p1 ^ X(!p2 U (p2 ^ X(!p3 U (p3)))))]] ^ ([(!r3) & [(p1 ^ X(!p2 U (p2 ^ X(!p3 U (p3)))))]] U ([r3 & [(p1 ^ X(!p2 U (p2 ^ X(!p3 U (p3)))))]]))))))", output);
	}
	
	@Test
	public void testEventualEEventualH() throws Exception {
		List<String> leftSides = cpGenerator.getCompositeProposition("R_EventualE_3");
		List<String> rightSides = cpGenerator.getCompositeProposition("P_EventualH_3");
		String output = operatorGenerator.getAndedPropositions(ANDR, leftSides, rightSides);
		assertEquals("[(!r1 ^ !r2 ^ !r3) & [(p1 ^ !p2 ^ !p3 ^ ((!p2 ^ !p3) U (p2 ^ !p3 ^ ((!p3) U (p3)))))]] ^ ([(!r1 ^ !r2 ^ !r3) & [(p1 ^ !p2 ^ !p3 ^ ((!p2 ^ !p3) U (p2 ^ !p3 ^ ((!p3) U (p3)))))]] U ([r1 ^ !r2 ^ !r3 & [(p1 ^ !p2 ^ !p3 ^ ((!p2 ^ !p3) U (p2 ^ !p3 ^ ((!p3) U (p3)))))]] ^ ([(!r2 ^ !r3) & [(p1 ^ !p2 ^ !p3 ^ ((!p2 ^ !p3) U (p2 ^ !p3 ^ ((!p3) U (p3)))))]] U ([r2 ^ !r3 & [(p1 ^ !p2 ^ !p3 ^ ((!p2 ^ !p3) U (p2 ^ !p3 ^ ((!p3) U (p3)))))]] ^ ([(!r3) & [(p1 ^ !p2 ^ !p3 ^ ((!p2 ^ !p3) U (p2 ^ !p3 ^ ((!p3) U (p3)))))]] U ([r3 & [(p1 ^ !p2 ^ !p3 ^ ((!p2 ^ !p3) U (p2 ^ !p3 ^ ((!p3) U (p3)))))]]))))))", output);
	}
	
	@Test
	public void testEventualEEventualE() throws Exception {
		List<String> leftSides = cpGenerator.getCompositeProposition("R_EventualE_3");
		List<String> rightSides = cpGenerator.getCompositeProposition("P_EventualE_3");
		String output = operatorGenerator.getAndedPropositions(ANDR, leftSides, rightSides);
		assertEquals("[(!r1 ^ !r2 ^ !r3) & [(!p1 ^ !p2 ^ !p3) ^ ((!p1 ^ !p2 ^ !p3) U (p1 ^ !p2 ^ !p3 ^ ((!p2 ^ !p3) U (p2 ^ !p3 ^ ((!p3) U (p3))))))]] ^ ([(!r1 ^ !r2 ^ !r3) & [(!p1 ^ !p2 ^ !p3) ^ ((!p1 ^ !p2 ^ !p3) U (p1 ^ !p2 ^ !p3 ^ ((!p2 ^ !p3) U (p2 ^ !p3 ^ ((!p3) U (p3))))))]] U ([r1 ^ !r2 ^ !r3 & [(!p1 ^ !p2 ^ !p3) ^ ((!p1 ^ !p2 ^ !p3) U (p1 ^ !p2 ^ !p3 ^ ((!p2 ^ !p3) U (p2 ^ !p3 ^ ((!p3) U (p3))))))]] ^ ([(!r2 ^ !r3) & [(!p1 ^ !p2 ^ !p3) ^ ((!p1 ^ !p2 ^ !p3) U (p1 ^ !p2 ^ !p3 ^ ((!p2 ^ !p3) U (p2 ^ !p3 ^ ((!p3) U (p3))))))]] U ([r2 ^ !r3 & [(!p1 ^ !p2 ^ !p3) ^ ((!p1 ^ !p2 ^ !p3) U (p1 ^ !p2 ^ !p3 ^ ((!p2 ^ !p3) U (p2 ^ !p3 ^ ((!p3) U (p3))))))]] ^ ([(!r3) & [(!p1 ^ !p2 ^ !p3) ^ ((!p1 ^ !p2 ^ !p3) U (p1 ^ !p2 ^ !p3 ^ ((!p2 ^ !p3) U (p2 ^ !p3 ^ ((!p3) U (p3))))))]] U ([r3 & [(!p1 ^ !p2 ^ !p3) ^ ((!p1 ^ !p2 ^ !p3) U (p1 ^ !p2 ^ !p3 ^ ((!p2 ^ !p3) U (p2 ^ !p3 ^ ((!p3) U (p3))))))]]))))))", output);
	}

}

