package general.node.other;

import org.junit.Test;

import general.node.AbstractTest;
import general.node.Node;

public class ReverseNodeListTest extends AbstractTest{

	@Test
	public void test() {
		ReverseNodeList<Integer> reverseNodeList = new ReverseNodeList<Integer>();
		Node<Integer> reverseNodeList2 = reverseNodeList.reverseNodeList(compariableNode1);
		print(reverseNodeList2);
	}

}
