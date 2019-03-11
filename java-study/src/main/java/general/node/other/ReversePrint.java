package general.node.other;

import java.util.Stack;

import general.node.Node;

/**
 * ÄæÐò´òÓ¡Á´±í
 * @author javon
 *
 */
public class ReversePrint<E> {

	public void reversePrint(Node<E> head){
		Stack<E> stack = new Stack<E>();
		stack.push(head.getValue());
		Node<E> next = null;
		while(head.getNext() != null){
			next = head.getNext();
			head = next;
			stack.push(next.getValue());
		}
		
		System.out.println(stack.size());
		
		while(! stack.isEmpty()){
			System.out.print(stack.pop() + " ");
		}
		System.out.println();
	}
	
	
}
