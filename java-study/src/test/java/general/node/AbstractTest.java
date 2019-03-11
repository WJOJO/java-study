package general.node;

import java.util.Random;

import org.junit.Before;

import general.node.Node;

public class AbstractTest {

	protected Node<String> root;
	protected Node<String> rootCircle;
	
	protected Node<Integer> compariableNode1;
	protected Node<Integer> compariableNode2;
	
	
	@Before
	public void init(){
		Node<String> E = new Node<String>("6", null);
		Node<String> D = new Node<String>("5", E);
		Node<String> C = new Node<String>("4", D);
		Node<String> B = new Node<String>("3", C);
		Node<String> A = new Node<String>("2", B);
		root = new Node<String>("1", A);
		
		
		Node<String> C1 = new Node<String>();
		C1.setValue("4");
		Node<String> D1 = new Node<String>("5", C1);
		C1.setNext(D1);
		
		Node<String> B1 = new Node<String>("3", C1);
		Node<String> A1 = new Node<String>("2", B1);
		rootCircle = new Node<String>("1", A1);
		
		compariableNode1 = create(10);
		compariableNode2 = create(30);
		
		
		
	}
	
	
	
	public Node<Integer> create(int n){
		Node<Integer> head = new Node<Integer>(1, null);
		Node<Integer> node = head;
		for (int i = 2; i < n; i++) {
			Node<Integer> node2 = new Node<Integer>(i + 2, null);
			node.setNext(node2);
			node = node2;
		}
		return head;
	}
	
	public <E> void print(Node<E> node){
		System.out.print(node.getValue() + " ");
		while(node.getNext()!=null){
			node = node.getNext();
			System.out.print(node.getValue() + " ");
		}
		System.out.println();
	}
	
}
