package general.node.hascircle;

import java.util.HashSet;
import java.util.Set;

import general.node.Node;

/**
 * 哈希缓存法
 * @author javon
 *	时间复杂度 O(n)
 *	空间复杂度 O(n)
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
