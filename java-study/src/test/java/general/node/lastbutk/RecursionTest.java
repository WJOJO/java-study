package general.node.lastbutk;

import org.junit.Test;

import general.node.Node;

public class RecursionTest extends AbstractTest{

	@Test
	public void testFindLastButK() {
		Recursion<String> recursion = new Recursion<String>();
		Node<String> lastButK = recursion.findLastButK(root, 2);
		System.out.println(lastButK.getValue());
	}

}
