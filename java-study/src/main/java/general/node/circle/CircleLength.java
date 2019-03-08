package general.node.circle;

import general.node.Node;
import general.node.hascircle.SlowFastPointer;

/**
 * 获取单链表中的环的length
 * @author javon
 *
 */
public class CircleLength {
	
	//方法1： 根据EntranceOfCircle获取到环的入口节点  然后继续往下走，直到又遇到入口节点 所走过的就是环的长度
	
	
	/**
	 * 方法2： 快慢指针法，第二次相遇 慢指针走过环的一圈
	 * @param head
	 * @return
	 */
	public <E> int getLengthOfCircle(Node<E> head){
		Node<E> firstMeetingNode = new SlowFastPointer().getFirstMeetingNode(head);
		if(firstMeetingNode == null){
			return 0;
		}
		
		Node<E> slow = firstMeetingNode;
		Node<E> fast = firstMeetingNode;
		for(int i = 1; ; i++){
			slow = slow.getNext();
			fast = fast.getNext().getNext();
			if(slow == fast){
				return i;
			}
		}
		
	}
	

}
