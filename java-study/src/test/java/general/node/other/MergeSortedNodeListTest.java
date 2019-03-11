package general.node.other;

import org.junit.Test;

import general.node.AbstractTest;
import general.node.Node;

public class MergeSortedNodeListTest<E> extends AbstractTest{

	@Test
	public void test() {
		print(compariableNode1);
		print(compariableNode2);
		MergeSortedNodeList<Integer> mergeSortedNodeList = new MergeSortedNodeList<>();
		Node<Integer> merge = mergeSortedNodeList.merge(compariableNode1, compariableNode2);
		print(merge);
	
	}
	
	@Test
	public void test2(){
		print(compariableNode1);
		print(compariableNode2);
		MergeSortedNodeList<Integer> mergeSortedNodeList = new MergeSortedNodeList<>();
		Node<Integer> merge = mergeSortedNodeList.merge(compariableNode1, compariableNode2);
		print(merge);
	}
	

}
