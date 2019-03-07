package general.node.lastbutk;

import org.junit.Test;

import general.node.Node;

public class LastButKTest extends AbstractTest{
	
	

	@Test
	public void testCountTwice() {
		CountTwice<String> butK = new CountTwice<String>();
		Node<String> node1 = butK.countTwice(root, -1);
		System.out.println(node1.getValue());
		Node<String> node2 = butK.countTwice(root, 2);
		System.out.println(node2.getValue());
		Node<String> node3 = butK.countTwice(root, 3);
		System.out.println(node3.getValue());
		Node<String> node4 = butK.countTwice(root, 4);
		System.out.println(node4.getValue());
		Node<String> node5 = butK.countTwice(root, 5);
		System.out.println(node5.getValue());
	}

}
