package general.leetcode.stack.practice;

import java.util.Stack;

/**
 * 84. 柱状图中最大的矩形
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * @author javon
 *
 */
public class Q84_LargestRectangle {
	/**
	 * 纯粹的递归做法
	 * @param heights
	 * @return
	 */
	public int largestRectangleArea(int[] heights) {
		if(heights.length == 0) return 0;
        return max(heights, 0, heights.length-1);
    }
	
	private int max(int[] heights, int i, int j){
		if(i >= j){
			return Math.min(heights[i], heights[j]) * (j-i + 1);
		}
		int min = heights[i];
		int n = i;
		for (int m = i + 1; m <= j; m++) {
			if(min > heights[m]){
				min = heights[m];
				n = m;
			}
		}
		int leftMax = n > i?max(heights, i, n -1):heights[n];
		int rightMax = n < j?max(heights, n+1, j):heights[n];
		int thisMax = (j-i+1) * min;
		return Math.max(Math.max(leftMax, rightMax), thisMax);
	}

	/**
	 * 使用单调栈
	 * @param heights
	 * @return
	 */
	public int largestRectangleAreaStack(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        for (int i = 0; i <= n; i++) {
            //判断i是否达到右边界，影响后面的到达右边界的stack弹出，计算逻辑
            int curHeight = i == n ? -1 : heights[i];
            //维持一个单调栈，从栈底到栈顶是从小到大的顺序，如果要进栈的元素比栈顶的值小，将栈顶的值弹出，计算逻辑
            while (!stack.isEmpty() && curHeight <= heights[stack.peek()]) {
                int stackHeight = heights[stack.pop()];
                // i - stack.peek() - 1 是计算width，这个code需要扣一下
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, stackHeight * width);
            }
            stack.push(i);
        }
        return max;
    }
	
	
	public static void main(String[] args) {
		int[] heights = {0,1,1,1,1,2,7,1,1,1};
		Q84_LargestRectangle rectangle = new Q84_LargestRectangle();
		int area = rectangle.largestRectangleAreaStack(heights);
		System.out.println(area);
	}
}
