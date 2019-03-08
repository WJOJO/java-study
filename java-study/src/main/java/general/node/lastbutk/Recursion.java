package general.node.lastbutk;

import general.node.Node;

/**
 * 
 * 递归法 找到单链表倒数第K个节点
 * @author javon
 *
 * @param <E>
 */
public class Recursion<E> {

	int num ;
	
	public Node<E> findLastButK(Node<E> pre, int k){
		num = k;
		if(pre == null){
			return pre;
		}
		Node<E> node = findLastButK(pre.getNext(), k);
		if(node != null){
			return node;
		}else{
			num --;
			if(num == 0){
				return pre;
			}
			return null;
		}
	}
	
	
	
}
