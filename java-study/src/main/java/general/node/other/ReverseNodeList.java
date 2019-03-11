package general.node.other;

import general.node.Node;

/**
 * 反转链表
 * @author javon
 * 
 */
public class ReverseNodeList<E> {

	/**
	 * 思路1： 使用栈的特性  入栈 出栈生成新的链表
	 */
	
	
	/**
	 * 思路2： 遍历链表
	 * @param head
	 * @return
	 */
	public Node<E> reverseNodeList(Node<E> head){
		//null判定
		if(head == null){
			return null;
		}
		
		Node<E> pre = head;
		Node<E> next = pre.getNext();
		//1个节点
		if(next == null){
			return pre;
		}
		pre.setNext(null);
		Node<E> nextNext = next.getNext();
		//两个节点
		if(nextNext == null){
			next.setNext(pre);
			return next;
		}
		//大于等于3个节点
		while(nextNext != null){
			next.setNext(pre);
			pre = next;
			next = nextNext;
			nextNext = nextNext.getNext();
		}
		next.setNext(pre);
		return next;
	}
	
}
