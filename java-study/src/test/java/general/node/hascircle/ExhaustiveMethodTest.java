package general.node.hascircle;

import org.junit.Test;

import general.node.lastbutk.AbstractTest;

public class ExhaustiveMethodTest extends AbstractTest {

	@Test
	public void test() {
		ExhaustiveMethod method = new ExhaustiveMethod();
		boolean circle = method.hasCircle(root);
		System.out.println(circle);
		
		boolean circle1 = method.hasCircle(rootCircle);
		System.out.println(circle1);
	}

}
