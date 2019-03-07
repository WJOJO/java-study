package general.node.lastbutk;

import org.junit.Before;

import general.node.Node;

public class AbstractTest {

	protected Node<String> root;
	
	@Before
	public void init(){
		Node<String> E = new Node<String>("6", null);
		Node<String> D = new Node<String>("5", E);
		Node<String> C = new Node<String>("4", D);
		Node<String> B = new Node<String>("3", C);
		Node<String> A = new Node<String>("2", B);
		root = new Node<String>("1", A);
	}
	
}
