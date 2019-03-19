package general.leetcode;

/**
 * 2. �������
 * �������� �ǿ� ������������ʾ�����Ǹ������������У����Ǹ��Ե�λ���ǰ��� ���� ��
 * ��ʽ�洢�ģ��������ǵ�ÿ���ڵ�ֻ�ܴ洢 һλ ���֡�
 * ��������ǽ��������������������᷵��һ���µ���������ʾ���ǵĺ͡�
 * �����Լ���������� 0 ֮�⣬���������������� 0 ��ͷ��
 * @author javon
 * 
 *
 */
public class Question2 {
	
	/**
	 * ��һ�ֽⷨ
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if(l1 == null)	return l2;
		if(l2 == null)	return l1;
		ListNode node = l1;
		ListNode pre = l1;
		int carry = 0;
		int sum = 0;
		while(node != null){
			pre = node;
			if(l2 == null){
				sum = node.val + carry;
				node.val = sum >= 10?sum - 10:sum;
				carry = sum >= 10?1:0;
				node = node.next;
			}else{
				sum = node.val + carry + l2.val;
				node.val = sum >= 10?sum - 10:sum;
				carry = sum >= 10?1:0;
				node = node.next;
				l2 = l2.next;
			}
		}
		pre.next = l2;
		node = pre.next;
		while(node != null){
			pre = node;
			if(carry == 0){
				break;
			}else{
				sum = carry + node.val;
				node.val = sum >= 10?sum - 10:sum;
				carry = sum >= 10?1:0;
				node = node.next;
			}
		}
		
		if(carry == 1){
			pre.next = new ListNode(1);
		}
		return l1;
	}
	
	
	
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(9);
		l1.next = new ListNode(8);
//		l1.next.next = new ListNode(3);
		
		ListNode l2 = new ListNode(1);
//		l2.next = new ListNode(6);
//		l2.next.next = new ListNode(4);
		Question2 question2 = new Question2();
		question2.addTwoNumbers(l1, l2);
	}
	

}
class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }