package general.node.circle;

import org.junit.Test;

import general.node.AbstractTest;
import general.node.Node;

public class EntranceOfCircleTest extends AbstractTest{


	@Test
	public void test() {
		EntranceOfCircle entranceOfCircle = new EntranceOfCircle();
		Node<String> node = entranceOfCircle.getTheEntranceOfCircle(rootCircle);
		System.out.println(node.getValue());
	}

}
