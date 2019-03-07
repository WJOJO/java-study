package general.node.lastbutk;

import general.node.Node;

/**
 * ���α�����
 * ������K���ڵ�
 * @author Administrator
 *
 */
public class CountTwice<E> {

	
	public Node<E> countTwice(Node<E> root, int k){
		//��������
		int size = getSize(root);
		//���ص�size - k���ڵ�
		return getNth(root, size, size - k);
	}
	
	
	/**
	 * ��ȡ����ĵ�N���ڵ�
	 * Ĭ�������ȴ���n
	 * @param root
	 * @param n
	 */
	private Node<E> getNth(Node<E> root, int size, int n){
		
		if(size < n || n < 0){
			return null;
		}
		Node<E> nodeN = root;
		for (int i = 0; i < n; i++) {
			nodeN = nodeN.getNext();
		}
		return nodeN;
	}
	
	
	private int getSize(Node<E> root){
		int size = 0;
		if(root == null){
			return size;
		}
		size += 1;
		while (null != (root=root.getNext()) ){
			size += 1;
		}
		return size;
	}
	
	
}
