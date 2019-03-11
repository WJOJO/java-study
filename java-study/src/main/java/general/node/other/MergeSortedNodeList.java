package general.node.other;

import general.node.Node;

/**
 * 有序链表合并
 * @author javon
 *
 */
public class MergeSortedNodeList<E extends Comparable<E>> {
	
	/**
	 * 循环
	 * head1 head2 都已排好序
	 * @param head1
	 * @param head2
	 * @return
	 */
	public Node<E> merge(Node<E> head1, Node<E> head2){
		
		Node<E> result = new Node<E>();
		
		if(head1 == null){
			return head2;
		}else if(head2 == null){
			return head1;
		}else{
			if(head1.getValue().compareTo(head2.getValue()) <= 0){
				result = head1;
				head1 = head1.getNext();
			}else{
				result = head2;
				head2 = head2.getNext();
			}
			Node<E> resultHead = result;
			
			while(true){
				if(head1 == null && head2 == null){
					return resultHead;
				}else if(head2 == null){
					result.setNext(head1);
					return resultHead;
				}else if(head1 == null){
					result.setNext(head2);
					return resultHead;
				}else{
					if(head1.getValue().compareTo(head2.getValue()) <= 0){
						result.setNext(head1);
						result = head1;
						head1 = head1.getNext();
					}else{
						result.setNext(head2);
						result = head2;
						head2 = head2.getNext();
					}
				}
				
			}
		}
	}
	
	
	private Node<E> result = new Node<>();
	
	private Node<E> resultHead = result;
	
	
	public  Node<E> recursionMerge(Node<E> head1, Node<E> head2){
		if(head1 == null && head2 == null){
			return resultHead;
		}else if(head1 == null){
			result.setNext(head2);
			result = head2;
			head2 = head2.getNext();
		}else if(head2 == null){
			result.setNext(head1);
			result = head1;
			head1 = head1.getNext();
		}else if(head1.getValue().compareTo(head2.getValue()) <= 0){
			result.setNext(head1);
			result = head1;
			head1 = head1.getNext();
		}else{
			result.setNext(head2);
			result = head2;
			head2 = head2.getNext();
		}
		recursionMerge(head1, head2);
		return resultHead.getNext();
	}
	

}

