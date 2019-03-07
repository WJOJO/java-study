package general.node.lastbutk;

import general.node.Node;

public class DoublePointer {

	public <E> Node<E> findLastK(Node<E> root, int k){
		Node<E> next = root;
		Node<E> nodeK = null;
		if(next == null){
			return null;
		}
		while(next.getNext() != null){
			if(k > 0){
				next = next.getNext();
				k--;
			}else{
				next = next.getNext();
				nodeK = root.getNext();
			}
		}
		return nodeK;
	}
	
}
