package general.node.circle;

import general.node.Node;
import general.node.hascircle.SlowFastPointer;

/**
 * ��λ���������
 * ����ָ�뷨
 * @author javon
 * ʱ�临�Ӷ� O(n)
 *
 */
public class EntranceOfCircle {

	public <E> Node<E>  getTheEntranceOfCircle(Node<E> head){
		//�ж��Ƿ��л�����ȡ�ÿ���ָ���һ������ʱ�Ľڵ�
		Node<E> firstMeetingNode = new SlowFastPointer().getFirstMeetingNode(head);
		if(firstMeetingNode == null){
			return null;
		}
		//�������ڵ㿪ʼ��ͬʱʹ����ָ�룬�ֱ�������ڵ�   �� ͷ������  ��Ȼ�����ڻ���ڽڵ�
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
