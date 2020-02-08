package general.leetcode.array.practice;

import java.util.Stack;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 
 * 数组问题，先找到最高点，然后分别遍历数组
 * @author javon
 *
 */
public class Q42_TrappingRainWater {
	
	public int trap(int[] height) {
		if(height.length <= 2) return 0;
		int max = height[0];
		int n = 0;
		for (int i = 1; i < height.length; i++) {
			if(max < height[i]){
				max = height[i];
				n = i;
			}
		}
		int sum = 0;
		int tmp = height[0];
		for (int i = 0; i < n; i++) {
			int diff = tmp - height[i];
			if(diff >= 0){
				sum += diff;
			}else{
				tmp = height[i];
			}
		}
		tmp = height[height.length - 1];
		for (int i = height.length-1; i > n; i--) {
			int diff = tmp - height[i];
			if(diff >= 0){
				sum += diff;
			}else{
				tmp = height[i];
			}
		}
		return sum;
	}
	
	
	public int trapStack(int[] height){
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(height[0]);
		int sum = 0;
		for (int i = 1; i < height.length; i++) {
			int first = stack.firstElement();
			while(first <= height[i]){
				int pop = stack.pop();
				if(!stack.isEmpty()){
					sum += first - pop;
				}else{
					break;
				}
			}
			stack.push(height[i]);
		}
		return sum;
	}

	
	public static void main(String[] args) {
		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		Q42_TrappingRainWater water = new Q42_TrappingRainWater();
		int trap = water.trapStack(height);
		System.out.println(trap);
	}
}
