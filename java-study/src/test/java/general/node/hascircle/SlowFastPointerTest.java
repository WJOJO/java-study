package general.node.hascircle;

import org.junit.Test;

import general.node.lastbutk.AbstractTest;

public class SlowFastPointerTest extends AbstractTest{

	@Test
	public void test() {
		SlowFastPointer method = new SlowFastPointer();
		System.out.println(method.hasCircle(root));
		System.out.println(method.hasCircle(rootCircle));
	}

}
