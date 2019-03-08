package general.node.circle;

import general.node.Node;
import general.node.hascircle.SlowFastPointer;

/**
 * 定位单链表环入口
 * 快慢指针法
 * @author javon
 * 时间复杂度 O(n)
 *
 */
public class EntranceOfCircle {

	public <E> Node<E>  getTheEntranceOfCircle(Node<E> head){
		//判断是否有环，并取得快慢指针第一次相遇时的节点
		Node<E> firstMeetingNode = new SlowFastPointer().getFirstMeetingNode(head);
		if(firstMeetingNode == null){
			return null;
		}
		//从相遇节点开始，同时使用慢指针，分别从相遇节点   和 头结点出发  必然相遇于环入口节点
		Node<E> slow1 = head;
		Node<E> slow2 = firstMeetingNode;
 		while(true){
 			slow1 = slow1.getNext();
 			slow2 = slow2.getNext();
 			if(slow1 == slow2){
 				return slow1;
 			}
 		}
	}
	
	
	
	
}
