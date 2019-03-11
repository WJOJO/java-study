package general.node.other;

import general.node.Node;

/**
 * ��ת����
 * @author javon
 * 
 */
public class ReverseNodeList<E> {

	/**
	 * ˼·1�� ʹ��ջ������  ��ջ ��ջ�����µ�����
	 */
	
	
	/**
	 * ˼·2�� ��������
	 * @param head
	 * @return
	 */
	public Node<E> reverseNodeList(Node<E> head){
		//null�ж�
		if(head == null){
			return null;
		}
		
		Node<E> pre = head;
		Node<E> next = pre.getNext();
		//1���ڵ�
		if(next == null){
			return pre;
		}
		pre.setNext(null);
		Node<E> nextNext = next.getNext();
		//�����ڵ�
		if(nextNext == null){
			next.setNext(pre);
			return next;
		}
		//���ڵ���3���ڵ�
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
