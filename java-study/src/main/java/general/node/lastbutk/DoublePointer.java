package general.node.lastbutk;

import general.node.Node;

/**
 * ˫ָ�뷢 �ҵ�����������K���ڵ�
 * @author javon
 *
 */
public class DoublePointer {

	public <E> Node<E> findLastK(Node<E> head, int k){
		int n = 1;
		Node<E> next = head;
		Node<E> kNode = null;
		if(next == null){
			return null;
		}
		while(next.getNext() != null){
			next = next.getNext();
			if(n < k){
				n++;
				kNode = head;
			}else{
				kNode = kNode.getNext();
			}
		}
		return kNode;
	}
	
}
