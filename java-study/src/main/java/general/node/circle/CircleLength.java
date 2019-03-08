package general.node.circle;

import general.node.Node;
import general.node.hascircle.SlowFastPointer;

/**
 * ��ȡ�������еĻ���length
 * @author javon
 *
 */
public class CircleLength {
	
	//����1�� ����EntranceOfCircle��ȡ��������ڽڵ�  Ȼ����������ߣ�ֱ����������ڽڵ� ���߹��ľ��ǻ��ĳ���
	
	
	/**
	 * ����2�� ����ָ�뷨���ڶ������� ��ָ���߹�����һȦ
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
