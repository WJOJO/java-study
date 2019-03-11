package general.node.lastbutk;

import org.junit.Test;

import general.node.AbstractTest;
import general.node.Node;

public class DoublePointerTest extends AbstractTest{

	@Test
	public void test() {
		Node<String> node = new DoublePointer().findLastK(root, 3);
		System.out.println(node.getValue());
	}

}
