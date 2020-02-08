package general.leetcode.stack;

/**
 * ��ʽջ
 * @author javon
 *
 */
public class ChainStack<E> {

	Node<E> head;
	
	public synchronized E push (E e){
		head = new Node<E>(e, head);
		return head.value;
	}
	
	public synchronized E pop(){
		if(head == null){
			throw new RuntimeException("stackΪ��");
		}
		E e = head.value;
		head = head.next;
		return e;
	}
	
}

class Node<E> {
	E value;
	Node<E> next;
	public Node(E value, Node<E> next) {
		super();
		this.value = value;
		this.next = next;
	}
	
}
