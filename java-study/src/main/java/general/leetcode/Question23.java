package general.leetcode;

/**
 * 23. �ϲ�K����������
 * �ϲ� k �������������غϲ������������������������㷨�ĸ��Ӷȡ�
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
