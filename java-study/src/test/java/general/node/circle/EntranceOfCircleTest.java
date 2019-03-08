package general.node.circle;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import general.node.Node;
import general.node.lastbutk.AbstractTest;

public class EntranceOfCircleTest extends AbstractTest{


	@Test
	public void test() {
		EntranceOfCircle entranceOfCircle = new EntranceOfCircle();
		Node<String> node = entranceOfCircle.getTheEntranceOfCircle(rootCircle);
		System.out.println(node.getValue());
	}

}
