package general.node.other;

import static org.junit.Assert.fail;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import general.node.Node;

public class BigNumberAddTest {
	
	private Node<Integer> head1 = new Node<Integer>(9, null); 
	private Node<Integer> head2 = new Node<Integer>(8, null); 
	
	@Before
	public void init(){
		
		Node<Integer> head1 = this.head1;
		Node<Integer> head2 = this.head2;
		Random random = new Random();
		for (int i = 0; i < 600; i++) {
			Node<Integer> next1 = new Node<Integer>(random.nextInt(9),null);
			head1.setNext(next1);
			head1 = next1;
		}
		
		for (int i = 0; i < 700; i++) {
			Node<Integer> next2 = new Node<Integer>(random.nextInt(9),null);
			head2.setNext(next2);
			head2 = next2;
		}
	}

	@Test
	public void test() {
		printNode(head1);
		System.out.println("+");
		printNode(head2);
		System.out.println("=");
		BigNumberAdd bigNumberAdd = new BigNumberAdd();
		Node<Integer> node = bigNumberAdd.add(head1, head2);
		printNode(node);
	}
	
	
	private void printNode(Node<Integer> head){
		System.out.print(head.getValue());
		while(head.getNext() != null){
			head = head.getNext();
			System.out.print(head.getValue());
		}
		System.out.println();
	}
	

}
