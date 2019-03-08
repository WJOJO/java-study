package general.node.hascircle;

import java.util.HashSet;
import java.util.Set;

import general.node.Node;

/**
 * ��ϣ���淨
 * @author javon
 *	ʱ�临�Ӷ� O(n)
 *	�ռ临�Ӷ� O(n)
 */
public class HashCaching {

	public <E> boolean hasCircle(Node<E> head){
		if(head == null){
			return false;
		}
		Set<Node<E>> set = new HashSet<Node<E>>();
		set.add(head);
		Node<E> next = head;
		while((next = next.getNext()) != null){
			if(set.contains(next)){
				return true;
			}
			set.add(next);
		}
		return false;
	}
	
	
}
