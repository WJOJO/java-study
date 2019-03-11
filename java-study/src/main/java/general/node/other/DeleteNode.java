package general.node.other;

import general.node.Node;

/**
 * 删除指定节点
 * @author javon
 *
 */
public class DeleteNode<E> {
	
	public Node<E> deleteNode(Node<E> head, Node<E> delete){
		Node<E> resultHead = head;
		while(true){
			if(head == delete){
				return head.getNext();
			}else if(head.getNext() == delete){
				if(delete.getNext() == null){
					head.setNext(null);
				}else{
					head.setNext(delete.getNext());
				}
				return resultHead;
			}
			head = head.getNext();
		}
	}

}
