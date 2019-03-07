package general.node.lastbutk;

import general.node.Node;

/**
 * 两次遍历法
 * 倒数第K个节点
 * @author Administrator
 *
 */
public class CountTwice<E> {

	
	public Node<E> countTwice(Node<E> root, int k){
		//计算数量
		int size = getSize(root);
		//返回第size - k个节点
		return getNth(root, size, size - k);
	}
	
	
	/**
	 * 获取链表的第N个节点
	 * 默认链表长度大于n
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
