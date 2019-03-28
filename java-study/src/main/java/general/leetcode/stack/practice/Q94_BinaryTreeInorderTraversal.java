package general.leetcode.stack.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. ���������������
 * ����һ���������������������� ������
 * @author javon
 *
 */
public class Q94_BinaryTreeInorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		TreeNode cur = root;
		while(cur != null || !stack.isEmpty()){
			if(cur != null){
				stack.push(cur);
				cur = cur.left;
			}else{
				cur = stack.pop();
				list.add(cur.val);
				cur = cur.right;
			}
		}
		return list;
	}
}

class TreeNode {
	int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


