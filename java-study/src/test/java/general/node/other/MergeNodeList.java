package general.node.other;

import general.node.Node;

/**
 * ��������ϲ�
 * ����Ϊ����
 * @author javon
 *
 */
public class MergeNodeList {
	
	public <E> Node<E> merge(Node<E> head1, Node<E> head2){
		if(head1 == null && head2 == null){
			return null;
		}else if(head1 == null){
			return head2;
		}else if(head2 == null){
			return head1;
		}else{
			return null;
		}
		
	}
	

}
