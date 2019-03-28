package general.leetcode.stack.practice;

import java.util.Stack;

/**
 * 84. ��״ͼ�����ľ���
 * ���� n ���Ǹ�������������ʾ��״ͼ�и������ӵĸ߶ȡ�ÿ�����ӱ˴����ڣ��ҿ��Ϊ 1 ��
 * ���ڸ���״ͼ�У��ܹ����ճ����ľ��ε���������
 * @author javon
 *
 */
public class Q84_LargestRectangle {
	/**
	 * ����ĵݹ�����
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
	 * ʹ�õ���ջ
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
            //�ж�i�Ƿ�ﵽ�ұ߽磬Ӱ�����ĵ����ұ߽��stack�����������߼�
            int curHeight = i == n ? -1 : heights[i];
            //ά��һ������ջ����ջ�׵�ջ���Ǵ�С�����˳�����Ҫ��ջ��Ԫ�ر�ջ����ֵС����ջ����ֵ�����������߼�
            while (!stack.isEmpty() && curHeight <= heights[stack.peek()]) {
                int stackHeight = heights[stack.pop()];
                // i - stack.peek() - 1 �Ǽ���width�����code��Ҫ��һ��
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
