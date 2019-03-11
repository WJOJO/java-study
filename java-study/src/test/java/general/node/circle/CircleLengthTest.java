package general.node.circle;

import org.junit.Test;

import general.node.AbstractTest;

public class CircleLengthTest extends AbstractTest{

	@Test
	public void test() {
		CircleLength circleLength = new CircleLength();
		int lengthOfCircle = circleLength.getLengthOfCircle(rootCircle);
		System.out.println(lengthOfCircle);
		int lengthOfCircle1 = circleLength.getLengthOfCircle(root);
		System.out.println(lengthOfCircle1);
	}

}
