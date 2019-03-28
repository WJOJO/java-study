package general.leetcode.stack;

import static org.junit.Assert.*;

import org.junit.Test;

public class ChainStackTest {

	@Test
	public void test() {
		ChainStack<Integer> stack = new ChainStack<Integer>();
		for (int i = 0; i < 100; i++) {
			int s = stack.push(i);
			System.out.print(s + " ");
		}
		System.out.println();
		for (int i = 0; i < 101; i++) {
			System.out.print(stack.pop() + " ");
		}
		System.out.println(stack);
	}

}
