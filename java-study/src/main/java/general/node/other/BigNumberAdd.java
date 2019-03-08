package general.node.other;

import general.node.Node;

/**
 * 两个使用链表表示的大数相加
 * @author javon
 *
 */
public class BigNumberAdd {

	static Node<Integer> NODE_ZERO = new Node<Integer>(0,null);
	
	public Node<Integer> add(Node<Integer> head1, Node<Integer> head2){
		int carry = 0;
		int tmp = 0;
		Node<Integer> result = new Node<Integer>();
		Node<Integer> pre = new Node<Integer>();
		if(head1 == null && head2 == null){
			return null;
		}else if(head1 == null){
			return head2;
		}else if(head2 == null){
			return head1;
		}else{
			tmp = head1.getValue() + head2.getValue();
		}
		if(tmp >= 10){
			tmp -= 10;
			carry = 1;
		}
		pre.setValue(tmp);
		
		result = pre;
		
		while(true){
			Node<Integer> next = new Node<Integer>();
			if(head1.getNext() == null && head2.getNext() == null){
				if(carry == 1){
					next.setValue(carry);
					pre.setNext(next);
				}
				return result;
			}else if(head1.getNext() == null){
				head2 = head2.getNext();
				tmp = head2.getValue() + carry;
			}else if(head2.getNext() == null){
				head1 = head1.getNext();
				tmp = head1.getValue() + carry;
			}else{
				head2 = head2.getNext();
				head1 = head1.getNext();
				tmp = head1.getValue() + head2.getValue() + carry;
			}
			if(tmp >= 10){
				tmp -= 10;
				carry = 1;
			}else{
				carry = 0;
			}
			next.setValue(tmp);
			pre.setNext(next);
			pre = next;
			
		}
	}
	
}
