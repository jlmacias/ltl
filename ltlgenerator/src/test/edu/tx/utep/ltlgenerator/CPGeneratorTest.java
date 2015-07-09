package test.edu.tx.utep.ltlgenerator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.tx.utep.ltlgenerator.CPGenerator;

public class CPGeneratorTest {

	private CPGenerator cpGenerator = new CPGenerator();

	@Test
	public void testAtLeastOneC() throws Exception {
		String output = String.join("", cpGenerator.getCompositeProposition2("L_AtLeastOneC_4"));
		assertEquals("(l1 v l2 v l3 v l4)", output);
	}
	
	@Test
	public void testAtLeastOneH() throws Exception {
		String output = String.join("", cpGenerator.getCompositeProposition2("P_AtLeastOneH_4"));
		assertEquals("(p1 v p2 v p3 v p4)", output);
	}
	
	@Test
	public void testAtLeastOneE() throws Exception {
		String output = String.join("", cpGenerator.getCompositeProposition2("L_AtLeastOneE_3"));
		assertEquals("(!l1 ^ !l2 ^ !l3) ^ ((!l1 ^ !l2 ^ !l3) U (l1 v l2 v l3))", output);
	}
	
	@Test
	public void testParallelInverse() throws Exception {
		String output = String.join("", cpGenerator.getCompositeProposition2("R_ParallelInverse_4"));
		assertEquals("(!r1 ^ !r2 ^ !r3 ^ !r4)", output);
	}
	
	@Test
	public void testParallelC() throws Exception {
		String output = String.join("", cpGenerator.getCompositeProposition2("R_ParallelC_4"));
		assertEquals("(r1 ^ r2 ^ r3 ^ r4)", output);
	}
	 
	@Test
	public void testParallelH() throws Exception {
		String output = String.join("", cpGenerator.getCompositeProposition2("L_ParallelH_4"));
		assertEquals("(l1 ^ l2 ^ l3 ^ l4)", output);
	}
	
	@Test
	public void testParallelE() throws Exception {
		String output = String.join("", cpGenerator.getCompositeProposition2("R_ParallelE_3"));
		assertEquals("(!r1 ^ !r2 ^ !r3) ^ ((!r1 ^ !r2 ^ !r3) U (r1 ^ r2 ^ r3))", output);
	}
	
	@Test
	public void testConsecutiveC() throws Exception {
		String output = String.join("", cpGenerator.getCompositeProposition2("Q_ConsecutiveC_4"));
		assertEquals("(q1 ^ X(q2 ^ X(q3 ^ X(q4))))", output);
	}

	@Test
	public void testConsecutiveH() throws Exception {
		String output = cpGenerator.getCompositeProposition("P_ConsecutiveH_4");
		assertEquals("(p1 ^ !p2 ^ !p3 ^ !p4 ^ X(p2 ^ !p3 ^ !p4 ^ X(p3 ^ !p4 ^ Xp4)))", output);
	}

	@Test
	public void testConsecutiveE_3() throws Exception {
		String output = String.join("", cpGenerator.getCompositeProposition2("L_ConsecutiveE_3"));
		assertEquals("(!l1 ^ !l2 ^ !l3) ^ ((!l1 ^ !l2 ^ !l3) U (l1 ^ !l2 ^ !l3 ^ X(l2 ^ !l3 ^ X(l3))))", output);
	}
	
	@Test
	public void testConsecutiveE_4() throws Exception {
		String output = String.join("", cpGenerator.getCompositeProposition2("L_ConsecutiveE_4"));
		assertEquals("(!l1 ^ !l2 ^ !l3 ^ !l4) ^ ((!l1 ^ !l2 ^ !l3 ^ !l4) U (l1 ^ !l2 ^ !l3 ^ !l4 ^ X(l2 ^ !l3 ^ !l4 ^ X(l3 ^ !l4 ^ X(l4)))))", output);
	}
	
	@Test
	public void testEventualC() throws Exception {
		String output = cpGenerator.getCompositeProposition("Q_EventualC_4");
		assertEquals("(q1 ^ X(!q2 U (q2 ^ X(!q3 U (q3 ^ X(!q4 U q4))))))", output);
	}
	
	@Test
	public void testEventualH() throws Exception {
		String output = cpGenerator.getCompositeProposition("P_EventualH_4");
		assertEquals("(p1 ^ !p2 ^ !p3 ^ !p4 ^ ((!p2 ^ !p3 ^ !p4) U (p2 ^ !p3 ^ !p4 ^ ((!p3 ^ !p4) U (p3 ^ !p4 ^ ((!p4) U p4))))))", output);
	}
	
	@Test
	public void testEventualE() throws Exception {
		String output = cpGenerator.getCompositeProposition("L_EventualE_4");
		assertEquals("(!l1 ^ !l2 ^ !l3 ^ !l4) ^ ((!l1 ^ !l2 ^ !l3 ^ !l4) U (l1 ^ !l2 ^ !l3 ^ !l4 ^ ((!l2 ^ !l3 ^ !l4) U (l2 ^ !l3 ^ !l4 ^ ((!l3 ^ !l4) U (l3 ^ !l4 ^ (!l4 U l4)))))))", output);
	}
}