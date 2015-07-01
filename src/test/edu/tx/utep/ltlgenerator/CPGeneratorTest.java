package test.edu.tx.utep.ltlgenerator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.tx.utep.ltlgenerator.CPGenerator;

public class CPGeneratorTest {

	private CPGenerator cpGenerator = new CPGenerator();

	@Test
	public void testAtLeastOneC() throws Exception {
		String output = cpGenerator.getCompositeProposition("L_AtLeastOneC_4");
		assertEquals("(l1 ^ l2 ^ l3 ^ l4)", output);
	}
	
	@Test
	public void testAtLeastOneH() throws Exception {
		String output = cpGenerator.getCompositeProposition("G_AtLeastOneH_4");
		assertEquals("(g1 ^ g2 ^ g3 ^ g4)", output);
	}
	
	@Test
	public void testAtLeastOneE() throws Exception {
		String output = cpGenerator.getCompositeProposition("L_AtLeastOneE_3");
		assertEquals("(!l1 ^ !l2 ^ !l3) ^ ((!l1 ^ !l2 ^ !l3) U (l1 ^ l2 ^ l3))", output);
	}
	
	@Test
	public void testParallelC() throws Exception {
		String output = cpGenerator.getCompositeProposition("R_ParallelC_4");
		assertEquals("(r1 v r2 v r3 v r4)", output);
	}
	
	@Test
	public void testParallelH() throws Exception {
		String output = cpGenerator.getCompositeProposition("L_ParallelH_4");
		assertEquals("(l1 v l2 v l3 v l4)", output);
	}
	
	@Test
	public void testParallelE() throws Exception {
		String output = cpGenerator.getCompositeProposition("R_ParallelE_3");
		assertEquals("(!r1 ^ !r2 ^ !r3) ^ ((!r1 ^ !r2 ^ !r3) U (r1 v r2 v r3))", output);
	}
	
	@Test
	public void testConsecutiveC() throws Exception {
		String output = cpGenerator.getCompositeProposition("Q_ConsecutiveC_4");
		assertEquals("(q1 ^ X(q2 ^ X(q3 ^ X(q4))))", output);
	}
	
}
