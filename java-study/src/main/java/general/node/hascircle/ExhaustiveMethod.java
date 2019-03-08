package general.node.hascircle;

import java.util.ArrayList;
import java.util.List;

import general.node.Node;

/**
 * ��ٷ��жϵ������Ƿ��л�
 * @author javon
 * 
 * ʱ�临�Ӷ�O(n^2)
 * �ռ临�Ӷ�O(n)
 *
 */
public class ExhaustiveMethod {

	
	public <E> boolean hasCircle(Node<E> head){
		List<Node<E>> nodeList = new ArrayList<Node<E>>();
		if(head == null){
			return false;
		}
		nodeList.add(head);
		Node<E> next = head;
		while((next = next.getNext()) != null){
			if(nodeList.contains(next)){
				return true;
			}
			nodeList.add(next);
		}
		return false;
	}
	
}
