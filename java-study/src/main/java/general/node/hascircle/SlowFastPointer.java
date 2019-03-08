package general.node.hascircle;

import general.node.Node;

/**
 * 快慢指针法
 * @author javon
 *
 */
public class SlowFastPointer {
	
	public <E> boolean hasCircle(Node<E> head){
		if(head == null){
			return false;
		}
		Node<E> slow = head;
		Node<E> fast = head;
		
		while(true){
			slow = slow.getNext();
			if(slow == null){
				return false;
			}
			fast = fast.getNext().getNext();
			if(fast == null){
				return false;
			}
			if(slow == fast)
				return true;
		}
	}
	
	/**
	 * 获取快慢指针第一次相遇的节点
	 * @param head
	 * @return
	 */
	public <E> Node<E> getFirstMeetingNode(Node<E> head){
		if(head == null){
			return null;
		}
		Node<E> slow = head;
		Node<E> fast = head;
		
		while(true){
			slow = slow.getNext();
			if(slow == null){
				return null;
			}
			fast = fast.getNext().getNext();
			if(fast == null){
				return null;
			}
			System.out.println("slow:" + slow.getValue() + "  fast:" + fast.getValue());
			if(slow == fast)
				return slow;
		}
	}

}
