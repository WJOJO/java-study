package general.node.other;

import org.junit.Test;

import general.node.AbstractTest;

public class ReversePrintTest<E> extends AbstractTest{

	@Test
	public void test() {
		ReversePrint<Integer> reversePrint = new ReversePrint<Integer>();
		print(compariableNode1);
		reversePrint.reversePrint(compariableNode1);
	}

}
