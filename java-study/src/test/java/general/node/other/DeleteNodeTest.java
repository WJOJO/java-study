package general.node.other;

import org.junit.Test;

import general.node.AbstractTest;
import general.node.Node;

public class DeleteNodeTest extends AbstractTest{

	@Test
	public void test() {
		DeleteNode<Integer> deleteNode = new DeleteNode<Integer>();
		Node<Integer> next = compariableNode1.getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext();
		print(compariableNode1);
		Node<Integer> deleteNode2 = deleteNode.deleteNode(compariableNode1, next);
		print(deleteNode2);
	}

}
