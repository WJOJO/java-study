package general.node.hascircle;

import org.junit.Test;

import general.node.AbstractTest;

public class HashCachingTest extends AbstractTest{

	@Test
	public void test() {
		HashCaching method = new HashCaching();
		boolean circle = method.hasCircle(root);
		System.out.println(circle);
		
		boolean circle1 = method.hasCircle(rootCircle);
		System.out.println(circle1);
	}

}
