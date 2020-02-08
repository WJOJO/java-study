package general.leetcode;

/**
 * 21. 合并两个有序链表
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * @author javon
 *
 */
public class Question21 {
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		ListNode head = new ListNode(0);
		ListNode node = head;
		
		while (l1 != null && l2 != null){
			if(l1.val < l2.val){
				node.next = l1;
				l1 = l1.next;
				node = node.next;
			}else if(l1.val > l2.val){
				node.next = l2;
				l2 = l2.next;
				node = node.next;
			}else{
				node.next = l1;
				l1 = l1.next;
				node.next.next = l2;
				l2 = l2.next;
				node = node.next.next;
			}
		}
		if(l1 != null) node.next = l1;
		if(l2 != null) node.next = l2;
		return head.next;
        
    }

	class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }
}
