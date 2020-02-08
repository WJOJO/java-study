package general.leetcode;

import java.util.Arrays;

/**
 * 16. 最接近的三数之和
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
 * 找出 nums 中的三个整数，使得它们的和与 target 最接近。
 * 返回这三个数的和。假定每组输入只存在唯一答案。
 * @author javon
 *
 */
public class Question16 {
	private int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length-2; i++) {
        	int m = i + 1;
        	int n = nums.length - 1;
			while(m < n){
				int sum = nums[i] + nums[m] + nums[n];
				if(sum < target)
					m++;
				else if(sum > target)
					n--;
				else
					return target;
				if(Math.abs(diff) > Math.abs(sum - target))
					diff = sum - target;
			}
		}
        return diff + target;
    }
	
	public static void main(String[] args) {
		int[] nums = {-1,2,1,-4};
		int target = 1;
		Question16 question16 = new Question16();
		int threeSumClosest = question16.threeSumClosest(nums, target);
		System.out.println(threeSumClosest);
	}
}
