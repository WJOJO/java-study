package general.leetcode;

/**
 * 23. 合并K个排序链表
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * @author javon
 *
 */
public class Question23 {
	
	public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0);
        ListNode next = max(lists);
        head.next = next;
        while(next != null){
        	next.next = max(lists);
        	next = next.next;
        }
        return head.next;
    }
	
	private ListNode max(ListNode[] lists){
		ListNode max = lists[0];
		for (int i = 1; i < lists.length; i++) {
			if(max == null)
				max = lists[i];
			else if(lists[i] != null && max.val < lists[i].val)
				max = lists[i];
		}
		ListNode result = max;
		max = max.next;
		return result;
	}

	class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }
}
