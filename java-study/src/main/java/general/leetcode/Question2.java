package general.leetcode;

/**
 * 2. 两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的
 * 方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * @author javon
 * 
 *
 */
public class Question2 {
	
	/**
	 * 第一种解法
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