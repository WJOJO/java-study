package general.leetcode.stack;

import org.junit.Test;

public class SequenceStackTest {

	@Test
	public void test() {
		SequenceStack<Integer> sequenceStack = new SequenceStack<>();
		for (int i = 0; i < 100; i++) {
			sequenceStack.push(i);
		}
		
		for (int i = 0; i < 100; i++) {
			System.out.println(sequenceStack.pop());
		}
	}

}
